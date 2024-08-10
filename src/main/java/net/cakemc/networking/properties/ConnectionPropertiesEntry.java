package net.cakemc.networking.properties;

/**
 * The type Connection properties entry.
 *
 * @param <Value> the type parameter
 */
public class ConnectionPropertiesEntry<Value> {

	private final PropertyType type;
	private final Value value;

	/**
	 * Instantiates a new Connection properties entry.
	 *
	 * @param type  the type
	 * @param value the value
	 */
	public ConnectionPropertiesEntry(PropertyType type, Value value) {
		this.type = type;
		this.value = value;
	}

	/**
	 * Gets value.
	 *
	 * @return the value
	 */
	public Value getValue() {
		return value;
	}

	/**
	 * Gets type.
	 *
	 * @return the type
	 */
	public PropertyType getType() {
		return type;
	}
}
