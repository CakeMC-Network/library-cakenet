package net.cakemc.lib.cakenet.response;

import net.cakemc.lib.cakenet.NetworkObject;
import net.cakemc.lib.cakenet.codec.Packet;

import java.util.UUID;

/**
 * The type Call packet.
 *
 * @param <T> the type parameter
 */
public abstract class CallPacket<T extends NetworkObject> extends Packet<T> {

	private final UUID callerUUID;

	/**
	 * Instantiates a new Call packet.
	 *
	 * @param callerUUID the caller uuid
	 */
	protected CallPacket(UUID callerUUID) {
		this.callerUUID = callerUUID;
	}

	/**
	 * Instantiates a new Call packet.
	 */
	public CallPacket() {
		this(UUID.randomUUID());
	}

	/**
	 * Gets caller uuid.
	 *
	 * @return the caller uuid
	 */
	public UUID getCallerUUID() {
		return callerUUID;
	}
}
