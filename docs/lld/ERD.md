### BookMySeat Entity Relationship Diagram (ERD)

Generated using Google Gemini Agent Using [DB Schema Diagram](./db-schema-diagram.png)

```mermaid
erDiagram
    EVENT {
        int id PK
        string title
        string description
        int duration_minutes
        int category
        int age_rating
        date release_date
    }

    SHOW {
        int id PK
        datetime start_time
        datetime end_time
        int event_id FK
        int auditorium_id FK
    }

    VENUE {
        int id PK
        string title
        int admin_id
        string city
        string address
    }

    AUDITORIUM {
        int id PK
        int catalog_id FK
        int venue_id FK
    }
    
    CATALOG {
        int id PK
        string name
        int total_rows
        int total_columns
    }
    
    CATALOG_SEAT {
        int id PK
        int catalog_id FK
        string row_label
        int seat_number
        int seat_type
    }

    USER {
        int id PK
        int role
    }

    USER_DETAILS {
        int user_id PK
        string first_name
        string last_name
        int age
        int gender
    }

    SHOW_SEAT {
        int id PK
        int show_id FK
        int catalog_seat_id FK
        float price
        string state
        int locked_by FK
        datetime locked_at
        datetime lock_expires_at
    }

    BOOKING {
        int id PK
        int show_id FK
        string state
        int user_id FK
        datetime created_at
        datetime updated_at
        datetime expires_at
    }

    BOOKING_SEAT {
        int id PK
        int booking_id FK
        int show_seat_id FK
    }

    TRANSACTION {
        int id PK
        string state
        float amount
        int booking_id FK
        datetime created_at
        datetime updated_at
    }

    EVENT ||--o{ SHOW : "has"
    VENUE ||--o{ AUDITORIUM : "contains"
    AUDITORIUM ||--o{ SHOW : "hosts"
    USER ||--|| USER_DETAILS : "has details"
    USER ||--o{ BOOKING : "makes"
    SHOW ||--o{ BOOKING : "receives"
    SHOW ||--o{ SHOW_SEAT : "has"
    BOOKING ||--o{ BOOKING_SEAT : "reserves"
    SHOW_SEAT ||--o{ BOOKING_SEAT : "is reserved in"
    BOOKING ||--o{ TRANSACTION : "paid via"
    USER ||--o{ SHOW_SEAT : "locks"
    CATALOG ||--o{ CATALOG_SEAT : "contains"
    CATALOG ||--o{ AUDITORIUM : "used in"
    CATALOG_SEAT ||--o{ SHOW_SEAT : "mapped to"
```