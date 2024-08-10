package net.cakemc.networking.properties;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Connection properties.
 */
public class ConnectionProperties {

	private final List<ConnectionPropertiesEntry<?>> entries;

	/**
	 * Instantiates a new Connection properties.
	 */
	public ConnectionProperties() {
		this.entries = new ArrayList<>();
	}

	/**
	 * Insert connection properties.
	 *
	 * @param <T>   the type parameter
	 * @param type  the type
	 * @param value the value
	 *
	 * @return the connection properties
	 */
	public <T> ConnectionProperties insert(PropertyType type, T value) {
		if (type.getType().equals(value.getClass())) {
			this.entries.add(new ConnectionPropertiesEntry<T>(
				 type, value
			));
		}
		return this;
	}

	/**
	 * Gets for.
	 *
	 * @param <T>  the type parameter
	 * @param type the type
	 *
	 * @return the for
	 */
	@SuppressWarnings("unchecked")
	public <T> T getFor(PropertyType type) {
		return (T) entries.stream()
		                  .filter(connectionPropertiesEntry -> connectionPropertiesEntry.getType() == type)
		                  .findFirst().map(connectionPropertiesEntry -> connectionPropertiesEntry == null
		                                                                ? null : connectionPropertiesEntry.getValue()).orElse(null);
	}

	/**
	 * Gets entries.
	 *
	 * @return the entries
	 */
	public List<ConnectionPropertiesEntry<?>> getEntries() {
		return entries;
	}
}
