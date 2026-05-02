### Payment Service
- Facilitates secure transactions via external gateways like stripe, razorpay etc. (simulated for dev).
- Ensures **idempotency** so that retries do not result in duplicate charges.
- Communicates status updates back to the Booking Service.