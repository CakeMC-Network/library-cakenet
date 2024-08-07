package net.cakemc.networking.connection;

import io.netty.channel.Channel;
import io.netty.channel.DefaultChannelPromise;
import net.cakemc.networking.codec.Packet;

/**
 * The type Active connection.
 */
public class ActiveConnection implements Connection {

    private final Channel channel;

    /**
     * Instantiates a new Active connection.
     *
     * @param channel the channel
     */
    public ActiveConnection(Channel channel) {
        this.channel = channel;

        if (!channel.isActive())
            throw new IllegalStateException("tried to initialized a active connection with an inactive channel!");
    }

    @Override
    public void close() {
        this.channel.close();
    }

    @Override
    public void send(Packet<?> packet) {
        this.channel.writeAndFlush(packet, new DefaultChannelPromise(channel)).addListener(future -> {
            if (!future.isSuccess() && future.exceptionNow() != null) {
                throw new RuntimeException(future.exceptionNow());
            }
        });
    }

    @Override
    public Channel getChannel() {
        return channel;
    }
}
