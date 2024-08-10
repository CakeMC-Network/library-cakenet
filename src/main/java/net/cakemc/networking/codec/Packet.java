package net.cakemc.networking.codec;

import net.cakemc.networking.NetworkObject;
import net.cakemc.networking.io.Read;
import net.cakemc.networking.io.Write;

import java.io.Serializable;

/**
 * The type Packet.
 *
 * @param <T> the type parameter
 */
public abstract class Packet<T extends NetworkObject> implements Serializable, Write<T>, Read<T, Packet<T>> {

	/**
	 * Descriptor packet descriptor.
	 *
	 * @return the packet descriptor
	 */
	public final PacketDescriptor descriptor() {
		return this.getClass().getDeclaredAnnotation(PacketDescriptor.class);
	}

	/**
	 * Is register able boolean.
	 *
	 * @return the boolean
	 *
	 * @throws NoSuchMethodException the no such method exception
	 */
	public boolean isRegisterAble() throws NoSuchMethodException {
		return this.descriptor() != null && this.getClass().getDeclaredConstructor() != null;
	}

	/**
	 * Read packet traffic int.
	 *
	 * @return the int
	 */
	public abstract int readPacketTraffic();

	/**
	 * Write packet traffic id.
	 *
	 * @param diff  the diff
	 * @param value the value
	 */
	public abstract void writePacketTrafficId(int diff, int value);

	/**
	 * Write header.
	 */
	public abstract void writeHeader();

	/**
	 * Write signature.
	 */
	public abstract void writeSignature();

}
