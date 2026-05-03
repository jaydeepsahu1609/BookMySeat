-- BookMySeat PostgreSQL Schema

-- DATABASE :: user_db
SELECT 'CREATE DATABASE "user_db"'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'user_db')\gexec

\c "user_db"

CREATE TABLE IF NOT EXISTS "user" (
    id VARCHAR(255) PRIMARY KEY,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS "user_details" (
    user_id VARCHAR(255) PRIMARY KEY REFERENCES "user"(id) ON DELETE CASCADE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    age INTEGER,
    gender VARCHAR(50)
);

-- DATABASE :: shows_db
SELECT 'CREATE DATABASE "shows_db"'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'shows_db')\gexec

\c "shows_db"

CREATE TABLE IF NOT EXISTS "event" (
    id VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    duration INTEGER NOT NULL,
    category VARCHAR(255),
    age_rating VARCHAR(50),
    release_date DATE
);

CREATE TABLE IF NOT EXISTS "venue" (
    id VARCHAR(255) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    admin_id VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS "auditorium" (
    id VARCHAR(255) PRIMARY KEY,
    capacity INTEGER NOT NULL,
    venue_id VARCHAR(255) NOT NULL REFERENCES "venue"(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS "show" (
    id VARCHAR(255) PRIMARY KEY,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    event_id VARCHAR(255) NOT NULL REFERENCES "event"(id) ON DELETE CASCADE,
    auditorium_id VARCHAR(255) NOT NULL REFERENCES "auditorium"(id) ON DELETE CASCADE
);

-- DATABASE :: bookings_db
SELECT 'CREATE DATABASE "bookings_db"'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'bookings_db')\gexec

\c "bookings_db"

CREATE TABLE IF NOT EXISTS "show_seat" (
    id VARCHAR(255) PRIMARY KEY,
    auditorium_id VARCHAR(255) NOT NULL,
    show_id VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    state VARCHAR(50) NOT NULL,
    locked_by VARCHAR(255),
    locked_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "booking" (
    id VARCHAR(255) PRIMARY KEY,
    show_id VARCHAR(255) NOT NULL,
    total NUMERIC(10, 2) NOT NULL,
    state VARCHAR(50) NOT NULL,
    time TIMESTAMP NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "show_booking" (
    id VARCHAR(255) PRIMARY KEY,
    booking_id VARCHAR(255) NOT NULL REFERENCES "booking"(id) ON DELETE CASCADE,
    show_seat_id VARCHAR(255) NOT NULL REFERENCES "show_seat"(id) ON DELETE CASCADE
);

-- DATABASE :: payments_db
SELECT 'CREATE DATABASE "payments_db"'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'payments_db')\gexec

\c "payments_db"

CREATE TABLE IF NOT EXISTS "transactions" (
    id VARCHAR(255) PRIMARY KEY,
    state VARCHAR(50) NOT NULL,
    amount NUMERIC(10, 2) NOT NULL,
    booking_id VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);