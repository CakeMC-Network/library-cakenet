package net.cakemc.networking.impl;

import net.cakemc.networking.AbstractNetworkServer;

/**
 * The type Default network server.
 */
public class DefaultNetworkServer extends AbstractNetworkServer {

    /**
     * Instantiates a new Default network server.
     *
     * @param port the port
     */
    public DefaultNetworkServer(int port) {
        super(port);
    }

    /**
     * Instantiates a new Default network server.
     *
     * @param port the port
     * @param host the host
     */
    public DefaultNetworkServer(int port, String host) {
        super(port, host);
    }

    /**
     * Instantiates a new Default network server.
     *
     * @param id   the id
     * @param port the port
     * @param host the host
     */
    public DefaultNetworkServer(long id, int port, String host) {
        super(id, port, host);
    }

    /**
     * Instantiates a new Default network server.
     *
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public DefaultNetworkServer(int port, String host, boolean noNativeTransport) {
        super(port, host, noNativeTransport);
    }

    /**
     * Instantiates a new Default network server.
     *
     * @param id                the id
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public DefaultNetworkServer(long id, int port, String host, boolean noNativeTransport) {
        super(id, port, host, noNativeTransport);
    }

    @Override
    public void start() {

    }
}
