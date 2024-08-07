package net.cakemc.networking;

import net.cakemc.networking.handler.HandlerDistributor;
import net.cakemc.networking.properties.ConnectionProperties;

import java.util.concurrent.Future;

/**
 * The type Abstract network client.
 */
public abstract class AbstractNetworkClient extends NetworkEndPoint {

    /**
     * The Distributor.
     */
    protected final HandlerDistributor distributor;
    private final ConnectionProperties properties;

    private final long id;
    private final int port;
    private final String host;
    private final boolean noNativeTransport;

    /**
     * Instantiates a new Abstract network client.
     *
     * @param port the port
     */
    public AbstractNetworkClient(int port) {
        this(generateId(), port, "127.0.0.1", false);
    }

    /**
     * Instantiates a new Abstract network client.
     *
     * @param port the port
     * @param host the host
     */
    public AbstractNetworkClient(int port, String host) {
        this(generateId(), port, host, false);
    }

    /**
     * Instantiates a new Abstract network client.
     *
     * @param id   the id
     * @param port the port
     * @param host the host
     */
    public AbstractNetworkClient(long id, int port, String host) {
        this(id, port, host, false);
    }

    /**
     * Instantiates a new Abstract network client.
     *
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public AbstractNetworkClient(int port, String host, boolean noNativeTransport) {
        this(generateId(), port, host, noNativeTransport);
    }

    /**
     * Instantiates a new Abstract network client.
     *
     * @param id                the id
     * @param port              the port
     * @param host              the host
     * @param noNativeTransport the no native transport
     */
    public AbstractNetworkClient(long id, int port, String host, boolean noNativeTransport) {
        this.id = id;
        this.port = port;
        this.host = host;
        this.noNativeTransport = noNativeTransport;

        this.properties = new ConnectionProperties();
        this.distributor = new HandlerDistributor();
    }

    /**
     * Connect future.
     *
     * @return the future
     */
    public abstract Future<Void> connect();

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Gets host.
     *
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Is no native transport boolean.
     *
     * @return the boolean
     */
    public boolean isNoNativeTransport() {
        return noNativeTransport;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public ConnectionProperties getProperties() {
        return properties;
    }

    /**
     * Gets distributor.
     *
     * @return the distributor
     */
    public HandlerDistributor getDistributor() {
        return distributor;
    }
}
