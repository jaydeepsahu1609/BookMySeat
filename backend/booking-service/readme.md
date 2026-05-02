### Booking Service
- The core engine handling the seat selection and reservation logic.
- Implements distributed locking (via Redis) to prevent double-booking.
- Provides 2D seat map data and manages the lifecycle of a booking (Created, Reserved, Confirmed, Expired).
- Ensures high consistency during the transactional phase of booking.