package com.bms.payment_service.constants;

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
    public static final String TABLE_TRANSACTION = "transaction";

    // ==========================================
    // Column Names
    // ==========================================
    
    // Transactions Columns
    public static final String COL_BOOKING_ID = "booking_id";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_UPDATED_AT = "updated_at";
}
