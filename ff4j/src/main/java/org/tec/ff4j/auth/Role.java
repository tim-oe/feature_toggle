package org.tec.ff4j.auth;

public enum Role {
    ROLE_ANONYMOUS(0),         // Default invalid/unverified/everyone (allows everyone to execute)
    ROLE_CUSTOMER(10),         // authed User
    ROLE_CUSTOMER_ADMIN(20),   // this is a customer that can manage other customers
    ROLE_SUPPORT(30),          // Administrator (Customer support)
    ROLE_ADMIN(40),            // Administrator (Customer support with extra abilities)
    ROLE_SUPERUSER(100);        // Superuser (dev)

    /** the instance type */
    private final int value;

    /**
     * Ctor
     * @param value the role level
     */
    Role(final int value) {
        this.value = value;
    }

    /**
     * Check if permission level is CUSTOMER
     * @param permissionLevel int
     * @return true if CUSTOMER
     */
    public static boolean isCustomer(final int permissionLevel) {
        return permissionLevel == ROLE_CUSTOMER.value;
    }

    /**
     * get the role level
     * @return the role level
     */
    public int getValue() {
        return value;
    }

    /**
     * Check if permission level is ADMIN or higher
     * @param permissionLevel int
     * @return true if ADMIN or higher
     */
    public static boolean isAdmin(final int permissionLevel) {
        return permissionLevel >= ROLE_ADMIN.value;
    }

    /**
     * Check if permission level is ROLE_CUSTOMER_ADMIN or higher
     * @param permissionLevel int
     * @return true if ROLE_CUSTOMER_ADMIN or higher
     */
    public static boolean isCustomerAdmin(final int permissionLevel) {
        return permissionLevel >= ROLE_CUSTOMER_ADMIN.value;
    }

    /**
     * Check if permission level is SUPPORT
     * @param permissionLevel int
     * @return true if SUPPORT or higher
     */
    public static boolean isSupport(final int permissionLevel) {
        return permissionLevel >= ROLE_SUPPORT.value;
    }

    /**
     * Check if permission level is SUPERUSER
     * @param permissionLevel int
     * @return true if SUPERUSER or higher
     */
    public static boolean isSuperuser(final int permissionLevel) {
        return permissionLevel >= ROLE_SUPERUSER.value;
    }
}