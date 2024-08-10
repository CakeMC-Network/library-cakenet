package net.cakemc.networking.codec;

import java.lang.annotation.*;

/**
 * The interface Packet descriptor.
 */
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PacketDescriptor {
	/**
	 * Id int.
	 *
	 * @return the int
	 */
	int id();

	/**
	 * Serial name string.
	 *
	 * @return the string
	 */
	String serialName() default "Undefined";

	/**
	 * Type type.
	 *
	 * @return the type
	 */
	Type type() default Type.BOTH_WAYS;

	/**
	 * The enum Type.
	 */
	public enum Type {
		/**
		 * Client to server type.
		 */
		CLIENT_TO_SERVER,
		/**
		 * Server to client type.
		 */
		SERVER_TO_CLIENT,
		/**
		 * Both ways type.
		 */
		BOTH_WAYS,
		;
	}
}
