-- BookMySeat PostgreSQL Schema

------------------------------
-- DATABASE :: auth_db
-- OWNER :: auth-service
------------------------------

\c "auth_db"

INSERT INTO "user" (id, role) 
VALUES (1, 1), 
       (2, 2);

INSERT INTO "user_details" (user_id, first_name, last_name, age, gender)
VALUES (1, 'Jaydeep', 'Sahu', 24, 1),
       (2, 'Galaxy', 'Cinemas', NULL, NULL);

------------------------------
-- DATABASE :: show_db
-- OWNER :: show-service
------------------------------

\c "show_db"

INSERT INTO "catalog" (id, name, total_rows, total_columns)
VALUES
    -- Standard layouts
    (1, 'STANDARD_100', 10, 10),     -- 10 x 10 = 100 seats
    (2, 'STANDARD_150', 15, 10),     -- 15 x 10 = 150 seats
    -- Premium layouts
    (3, 'PREMIUM_120', 12, 10),      -- slightly better spacing
    (4, 'PREMIUM_180', 18, 10),
    -- Recliner layouts (less seats, more space)
    (5, 'RECLINER_60', 6, 10),
    (6, 'RECLINER_80', 8, 10),
    -- Large format
    (7, 'IMAX_200', 20, 10),
    (8, 'IMAX_300', 20, 15);

-- STANDARD 10x10 | Rows A–J, seats 1–10
INSERT INTO "catalog_seat" (catalog_id, row_label, seat_number, seat_type)
SELECT
    1 AS catalog_id,
    chr(64 + r) AS row_label,   -- A, B, ..., J
    c AS seat_number,
    1 AS seat_type              -- STANDARD
FROM generate_series(1, 10) AS r
CROSS JOIN generate_series(1, 10) AS c;

-- RECLINER 6x10 | A–F, seats 1–10
INSERT INTO "catalog_seat" (catalog_id, row_label, seat_number, seat_type)
SELECT
    5 AS catalog_id,
    chr(64 + r) AS row_label,   -- A, B, ..., F
    c AS seat_number,
    3 AS seat_type              -- RECLINER
FROM generate_series(1, 6) AS r
CROSS JOIN generate_series(1, 10) AS c;

INSERT INTO "venue" (id, title, admin_id, city, address)
VALUES
    (1, 'PVR Treasure Island', 2, 'Indore', 'Treasure Island Mall, MG Road, Indore'),
    (2, 'INOX C21 Mall', 2, 'Indore', 'C21 Mall, AB Road, Indore');

INSERT INTO "auditorium" (catalog_id, venue_id)
VALUES (1, 1),
       (5, 1),
       (1, 2),
       (5, 2);

------------------------------
-- DATABASE :: booking_db
-- OWNER :: booking-service
------------------------------

------------------------------
-- DATABASE :: payment_db
-- OWNER :: payment-service
------------------------------
