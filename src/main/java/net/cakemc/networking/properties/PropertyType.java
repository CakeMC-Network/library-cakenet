package net.cakemc.networking.properties;

/**
 * The enum Property type.
 */
public enum PropertyType {

    /**
     * Tpc no delay property type.
     */
    TPC_NO_DELAY("tpc_no_delay", boolean.class)

    ;

    private final String name;
    private final Class<?> type;

    PropertyType(String name, Class<?> type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Class<?> getType() {
        return type;
    }
}
