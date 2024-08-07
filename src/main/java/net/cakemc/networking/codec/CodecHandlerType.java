package net.cakemc.networking.codec;

/**
 * The enum Codec handler type.
 */
public enum CodecHandlerType {

    /**
     * Framing handler codec handler type.
     */
    FRAMING_HANDLER,
    /**
     * Compression handler codec handler type.
     */
    COMPRESSION_HANDLER,
    /**
     * Packet handler codec handler type.
     */
    PACKET_HANDLER,
    /**
     * Boss handler codec handler type.
     */
    BOSS_HANDLER,

    /**
     * State handler codec handler type.
     */
    STATE_HANDLER,

    /**
     * Initializer codec handler type.
     */
    INITIALIZER,

}
