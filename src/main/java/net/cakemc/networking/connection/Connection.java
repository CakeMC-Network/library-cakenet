package net.cakemc.networking.connection;

import io.netty.channel.Channel;
import net.cakemc.networking.codec.Packet;

/**
 * The interface Connection.
 */
public interface Connection {

    /**
     * Close.
     */
    public void close();

    /**
     * Send.
     *
     * @param packet the packet
     */
    public void send(Packet<?> packet);

    /**
     * Gets channel.
     *
     * @return the channel
     */
    Channel getChannel();
}
