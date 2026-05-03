package com.bms.booking_service.constants;

/**
 * Utility class to hold constant strings related to JPA Entities.
 * Contains table names and column names to prevent hardcoding strings in Entity classes.
 */
public final class EntityConstants {

    // Private constructor to prevent instantiation
    private EntityConstants() {
    }

    // ==========================================
    // Table Names
    // ==========================================
    public static final String TABLE_SHOW_SEAT = "\"show_seat\"";
    public static final String TABLE_BOOKING = "\"booking\"";
    public static final String TABLE_SHOW_BOOKING = "\"show_booking\"";

    // ==========================================
    // Column Names
    // ==========================================
    
    // ShowSeat Columns
    public static final String COL_AUDITORIUM_ID = "auditorium_id";
    public static final String COL_SHOW_ID = "show_id";
    public static final String COL_LOCKED_BY = "locked_by";
    public static final String COL_LOCKED_AT = "locked_at";

    // Booking Columns
    public static final String COL_USER_ID = "user_id";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_UPDATED_AT = "updated_at";

    // ShowBooking Columns
    public static final String COL_BOOKING_ID = "booking_id";
    public static final String COL_SHOW_SEAT_ID = "show_seat_id";
}
