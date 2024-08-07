package net.cakemc.networking.impl;

import net.cakemc.networking.AbstractNetworkClient;

import java.util.concurrent.Future;

/**
 * The type Default network client.
 */
public class DefaultNetworkClient extends AbstractNetworkClient {

    /**
     * Instantiates a new Default network client.
     *
     * @param port the port
     */
    public DefaultNetworkClient(int port) {
        super(port);
    }

    /**
     * Instantiates a new Default network client.
     *
     * @param port the port
     * @param host the host
     */
    public DefaultNetworkClient(int port, String host) {
        super(port, host);
    }

    /**
     * Instantiates a new Default network client.
     *
     * @param id   the id
     * @param port the port
     * @param host the host
     */
    public DefaultNetworkClient(long id, int port, String host) {
        super(id, port, host);
    }

    /**
     * Instantiates a new Default network client.
     *
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public DefaultNetworkClient(int port, String host, boolean noNativeTransport) {
        super(port, host, noNativeTransport);
    }

    /**
     * Instantiates a new Default network client.
     *
     * @param id                the id
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public DefaultNetworkClient(long id, int port, String host, boolean noNativeTransport) {
        super(id, port, host, noNativeTransport);
    }

    @Override
    public Future<Void> connect() {

        return null;
    }
}
