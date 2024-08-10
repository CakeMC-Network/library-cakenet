package net.cakemc.networking.buffer;

import java.util.UUID;

/**
 * The interface Buffer.
 */
@SuppressWarnings("unused")
public interface Buffer {
	/**
	 * Read index int.
	 *
	 * @return the int
	 */
	int readIndex();

	/**
	 * Write index int.
	 *
	 * @return the int
	 */
	int writeIndex();

	/**
	 * Size int.
	 *
	 * @return the int
	 */
	int size();

	/**
	 * Readable boolean.
	 *
	 * @return the boolean
	 */
	boolean readable();

	/**
	 * Read unsigned byte int.
	 *
	 * @return the int
	 */
	int readUnsignedByte();

	/**
	 * Write unsigned byte buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeUnsignedByte(int value);

	/**
	 * Read byte byte.
	 *
	 * @return the byte
	 */
	byte readByte();

	/**
	 * Write byte buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeByte(byte value);

	/**
	 * Read bytes byte [ ].
	 *
	 * @param length the length
	 *
	 * @return the byte [ ]
	 */
	byte[] readBytes(int length);

	/**
	 * Read all byte [ ].
	 *
	 * @return the byte [ ]
	 */
	byte[] readAll();

	/**
	 * Write bytes buffer.
	 *
	 * @param bytes the bytes
	 *
	 * @return the buffer
	 */
	Buffer writeBytes(byte[] bytes);

	/**
	 * Read short short.
	 *
	 * @return the short
	 */
	short readShort();

	/**
	 * Write short buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeShort(short value);

	/**
	 * Read unsigned short int.
	 *
	 * @return the int
	 */
	int readUnsignedShort();

	/**
	 * Read int int.
	 *
	 * @return the int
	 */
	int readInt();

	/**
	 * Write int buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeInt(int value);

	/**
	 * Read var int int.
	 *
	 * @return the int
	 */
	int readVarInt();

	/**
	 * Write var int buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeVarInt(int value);

	/**
	 * Read float float.
	 *
	 * @return the float
	 */
	float readFloat();

	/**
	 * Write float buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeFloat(float value);

	/**
	 * Read long long.
	 *
	 * @return the long
	 */
	long readLong();

	/**
	 * Write long buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeLong(long value);

	/**
	 * Write var long buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeVarLong(long value);

	/**
	 * Read double double.
	 *
	 * @return the double
	 */
	double readDouble();

	/**
	 * Write double buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeDouble(double value);

	/**
	 * Read boolean boolean.
	 *
	 * @return the boolean
	 */
	boolean readBoolean();

	/**
	 * Write boolean buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeBoolean(boolean value);

	/**
	 * Read string string.
	 *
	 * @return the string
	 */
	String readString();

	/**
	 * Read string string.
	 *
	 * @param capacity the capacity
	 *
	 * @return the string
	 */
	String readString(int capacity);

	/**
	 * Read string string.
	 *
	 * @param capacity the capacity
	 * @param length   the length
	 *
	 * @return the string
	 */
	String readString(int capacity, int length);

	/**
	 * Write string buffer.
	 *
	 * @param value the value
	 *
	 * @return the buffer
	 */
	Buffer writeString(String value);

	/**
	 * Read byte array byte [ ].
	 *
	 * @return the byte [ ]
	 */
	byte[] readByteArray();

	/**
	 * Write byte array buffer.
	 *
	 * @param bytes the bytes
	 *
	 * @return the buffer
	 */
	Buffer writeByteArray(byte[] bytes);

	/**
	 * Write uuid buffer.
	 *
	 * @param uuid the uuid
	 *
	 * @return the buffer
	 */
	Buffer writeUUID(UUID uuid);

	/**
	 * Read uuid uuid.
	 *
	 * @return the uuid
	 */
	UUID readUUID();
}
