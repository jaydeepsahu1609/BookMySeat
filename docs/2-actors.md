## Actors

1. **Customer**:
   - Primary users of the platform.
   - Can search for events by city, venue, or category.
   - View real-time seat availability and book tickets.
   - Manage personal booking history and process payments.

2. **Admin (Venue Owner)**:
   - Can onboard new venues and manage their layouts.
   - Handles event & show management.

3. **System Administrator**:
   - Oversees the entire platform, manages global configurations, and monitors overall system health.
   - Manages user roles, permissions, and platform-wide security policies.
   - Monitors infrastructure performance and handles troubleshooting or disaster recovery.

---

## Services & Components

### 1. Auth Service
- Handles user registration and onboarding for both Customers and Admins.
- Manages authentication (JWT/OAuth2) and Role-Based Access Control (RBAC).

### 2. Query Service
- Optimized for high-read traffic (Search & Discovery).
- Provides event listings, show timings, and venue details.
- Leverages **Redis** caching to ensure low-latency responses for frequent searches.

### 3. Booking Service
- The core engine handling the seat selection and reservation logic.
- Implements distributed locking (via Redis) to prevent double-booking.
- Provides 2D seat map data and manages the lifecycle of a booking (Created, Reserved, Confirmed, Expired).
- Ensures high consistency during the transactional phase of booking.

### 4. Payment Service
- Facilitates secure transactions via external gateways like stripe, razorpay etc. (simulated for dev).
- Ensures **idempotency** so that retries do not result in duplicate charges.
- Communicates status updates back to the Booking Service.

### 5. Show Service
- A back-office tool for Admins to create and update events, shows, and venue metadata.
- Updates the primary **PostgreSQL** database, which eventually syncs with the Query Service cache.

### 6. Notification Service
- An event-driven component that listens to **Kafka** topics.
- Sends automated confirmations, digital tickets, and alerts via Email or WhatsApp.

### 7. Message Broker (Kafka)
- Acts as the backbone for asynchronous communication between services.
- Handles booking events, payment success/failure notifications, and background tasks.

---

## Data Synchronization & CQRS Flow

The system employs a **Command Query Responsibility Segregation (CQRS)** pattern with an event-driven architecture to keep data synchronized across microservices:

### 1. Source of Truth Services
Each core service acts as the definitive source of truth for its own domain:
- **Show Service** owns: Events, Shows, Venues, and Auditoriums.
- **Booking Service** owns: Seat statuses, Pricing, and Booking transactions.

### 2. Publishing Events to Kafka
Whenever a state change occurs in the source of truth services, they publish domain events to **Kafka**. Examples include:
- `SHOW_CREATED`
- `SHOW_UPDATED`
- `SEAT_LAYOUT_CREATED`
- `BOOKING_CONFIRMED`
- `BOOKING_CANCELLED`

### 3. Query Service Consumption (The Read Model)
The **Query Service** acts as a subscriber to these events. It consumes them and builds its own optimized read-heavy database tables (e.g., PostgreSQL or MongoDB) that are specifically tailored for search functionality.
- For example, it might build a denormalized view like `search_show_view`:
  - `show_id`, `movie_title`, `city`, `venue_name`, `start_time`, `available_seats`, `price_range`
- This database is fully owned by the Query Service and is **eventually consistent** with the primary databases.

### 4. Caching Strategy with Redis
To further reduce latency and database load, the Query Service implements a caching layer using **Redis**:
- It caches hot queries such as "Movies in Bangalore Today" or "Available seats for Show 123".
- Cache invalidation relies on either **TTL (Time-To-Live)** expirations or **Event-based invalidation** triggered directly by incoming Kafka events.
