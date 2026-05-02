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
