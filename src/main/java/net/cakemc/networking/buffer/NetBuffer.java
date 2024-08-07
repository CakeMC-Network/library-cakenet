package net.cakemc.networking.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The type Net buffer.
 */
public class NetBuffer implements Buffer {

    private final ByteBuf buf;

    /**
     * Instantiates a new Net buffer.
     */
    @Deprecated
    public NetBuffer() {
        this(Unpooled.buffer());
    }

    /**
     * Instantiates a new Net buffer.
     *
     * @param size the size
     */
    public NetBuffer(int size) {
        this(Unpooled.buffer(size));
    }

    /**
     * Instantiates a new Net buffer.
     *
     * @param buf the buf
     */
    public NetBuffer(final ByteBuf buf) {
        this.buf = buf;
    }


    @Override
    public int readIndex() {
        return  this.buf.readerIndex();
    }

    @Override
    public int writeIndex() {
        return  this.buf.writerIndex();
    }

    @Override
    public int size() {
        return this.buf.readableBytes();
    }

    @Override
    public boolean readable() {
        return this.buf.isReadable();
    }

    @Override
    public int readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override
    public Buffer writeUnsignedByte(int value) {
        this.buf.writeByte(value);
        return this;
    }

    @Override
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override
    public Buffer writeByte(byte value) {
        this.buf.writeByte(value);
        return this;
    }

    @Override
    public byte[] readBytes(final int length) {
        final byte[] bytes = new byte[length];
        this.buf.readBytes(bytes, 0, length);
        return bytes;
    }

    @Override
    public byte[] readAll() {
        return this.readBytes(this.buf.readableBytes());
    }

    @Override
    public Buffer writeBytes(final byte[] bytes) {
        this.buf.writeBytes(bytes);
        return this;
    }

    @Override
    public short readShort() {
        return this.buf.readShort();
    }

    @Override
    public Buffer writeShort(final short value) {
        this.buf.writeShort(value);
        return this;
    }

    @Override
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    @Override
    public int readInt() {
        return this.buf.readInt();
    }

    @Override
    public Buffer writeInt(int value) {
        this.buf.writeInt(value);
        return this;
    }

    @Override
    public int readVarInt() {
        return readVarInt(this.buf);
    }

    @Override
    public Buffer writeVarInt(final int value) {
        writeVarIntFast(this.buf, value);
        return this;
    }

    @Override
    public float readFloat() {
        return this.buf.readFloat();
    }

    @Override
    public Buffer writeFloat(float value) {
        this.buf.writeFloat(value);
        return this;
    }

    @Override
    public long readLong() {
        return this.buf.readLong();
    }

    @Override
    public Buffer writeLong(long value) {
        this.buf.writeLong(value);
        return this;
    }

    @Override
    public Buffer writeVarLong(long value) {
        while (true) {
            if ((value & ~((long) 0x7F)) == 0) {
                this.writeByte((byte) value);
                return this;
            }
            this.writeByte((byte) ((value & 0x7F) | 0x80));
            value >>>= 7;
        }
    }

    @Override
    public double readDouble() {
        return this.buf.readDouble();
    }

    @Override
    public Buffer writeDouble(double value) {
        this.buf.writeDouble(value);
        return this;
    }

    @Override
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    @Override
    public Buffer writeBoolean(final boolean value) {
        this.buf.writeBoolean(value);
        return this;
    }

    @Override
    public String readString() {
        return this.readString(65536);
    }

    @Override
    public String readString(final int capacity) {
        return this.readString(capacity, this.readVarInt());
    }

    @Override
    public String readString(final int capacity, final int length) {
        return this.buf.readCharSequence(length, UTF_8).toString();
    }

    @Override
    public Buffer writeString(String value) {
        this.writeVarInt(value.length());
        this.buf.writeCharSequence(value, UTF_8);
        return this;
    }

    @Override
    public byte[] readByteArray() {
        return this.readBytes(this.readVarInt());
    }

    @Override
    public Buffer writeByteArray(final byte[] bytes) {
        return this.writeVarInt(bytes.length).writeBytes(bytes);
    }

    @Override
    public Buffer writeUUID(UUID uuid) {
        this.writeLong(uuid.getMostSignificantBits());
        this.writeLong(uuid.getLeastSignificantBits());
        return this;
    }

    @Override
    public UUID readUUID() {
        return new UUID(readLong(), readLong());
    }

    private void writeVarIntFast(final ByteBuf buf, int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            buf.writeByte((byte) value);
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            buf.writeShort((short) ((value & 0x7F | 0x80) << 8 | (value >>> 7)));
        } else if ((value & (0xFFFFFFFF << 21)) == 0) {
            buf.writeMedium(
                    (value & 0x7F | 0x80) << 16 | ((value >>> 7) & 0x7F | 0x80) << 8 | (value >>> 14));
        } else if ((value & (0xFFFFFFFF << 28)) == 0) {
            buf.writeInt((value & 0x7F | 0x80) << 24 | (((value >>> 7) & 0x7F | 0x80) << 16)
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | (value >>> 21));
        } else {
            buf.writeInt((value & 0x7F | 0x80) << 24 | ((value >>> 7) & 0x7F | 0x80) << 16
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | ((value >>> 21) & 0x7F | 0x80));
            buf.writeByte((byte) (value >>> 28));
        }
    }

    private static int readVarInt(final ByteBuf buf) {
        var value = 0;
        var position = 0;

        while (true) {
            final var current = buf.readByte();
            value |= (current & 127) << position++ * 7;

            if (position > 5) {
                throw new RuntimeException("VarInt too big");
            }
            if ((current & 128) != 128) {
                break;
            }
        }
        return value;
    }

}
