package net.cakemc.lib.cakenet.response;

import net.cakemc.lib.cakenet.NetworkObject;
import net.cakemc.lib.cakenet.codec.Packet;

import java.util.UUID;

/**
 * The type Response packet.
 *
 * @param <T> the type parameter
 */
public abstract class ResponsePacket<T extends NetworkObject> extends Packet<T> {

	private UUID respondsUUID;

	/**
	 * Sets responds uuid.
	 *
	 * @param respondsUUID the responds uuid
	 */
	public void setRespondsUUID(UUID respondsUUID) {
		this.respondsUUID = respondsUUID;
	}

	/**
	 * Gets responds uuid.
	 *
	 * @return the responds uuid
	 */
	public UUID getRespondsUUID() {
		return respondsUUID;
	}
}
