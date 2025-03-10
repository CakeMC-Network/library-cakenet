package net.cakemc.lib.cakenet.handler;

import net.cakemc.lib.cakenet.codec.Packet;
import net.cakemc.lib.cakenet.connection.Connection;

/**
 * The enum Handler type.
 */
public enum HandlerType {

	/**
	 * Connect handler type.
	 */
	CONNECT(Connection.class),
	/**
	 * Disconnect handler type.
	 */
	DISCONNECT(Connection.class),
	/**
	 * In coming packet handler type.
	 */
	IN_COMING_PACKET(Packet.class),

	/**
	 * Startup handler type.
	 */
	STARTUP(Void.class),
	;

	private final Class<?> handlerType;

	HandlerType(Class<?> handlerType) {
		this.handlerType = handlerType;
	}

	/**
	 * Gets handler type.
	 *
	 * @return the handler type
	 */
	public Class<?> getHandlerType() {
		return handlerType;
	}
}
