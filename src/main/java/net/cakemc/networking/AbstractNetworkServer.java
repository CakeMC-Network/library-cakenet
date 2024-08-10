package net.cakemc.networking;

import net.cakemc.networking.handler.HandlerDistributor;

/**
 * The type Abstract network server.
 */
public abstract class AbstractNetworkServer extends NetworkEndPoint {

	/**
	 * The Distributor.
	 */
	protected final HandlerDistributor distributor;

	/**
	 * The Id.
	 */
	protected final long id;
	/**
	 * The Port.
	 */
	protected final int port;
	/**
	 * The Host.
	 */
	protected final String host;
	/**
	 * The No native transport.
	 */
	protected final boolean noNativeTransport;

	/**
	 * Instantiates a new Abstract network server.
	 *
	 * @param port the port
	 */
	public AbstractNetworkServer(int port) {
		this(generateId(), port, "127.0.0.1", false);
	}

	/**
	 * Instantiates a new Abstract network server.
	 *
	 * @param port the port
	 * @param host the host
	 */
	public AbstractNetworkServer(int port, String host) {
		this(generateId(), port, host, false);
	}

	/**
	 * Instantiates a new Abstract network server.
	 *
	 * @param id   the id
	 * @param port the port
	 * @param host the host
	 */
	public AbstractNetworkServer(long id, int port, String host) {
		this(id, port, host, false);
	}

	/**
	 * Instantiates a new Abstract network server.
	 *
	 * @param port              the port
	 * @param host              the host
	 * @param noNativeTransport the no native transport
	 */
	public AbstractNetworkServer(int port, String host, boolean noNativeTransport) {
		this(generateId(), port, host, noNativeTransport);
	}

	/**
	 * Instantiates a new Abstract network server.
	 *
	 * @param id                the id
	 * @param port              the port
	 * @param host              the host
	 * @param noNativeTransport the no native transport
	 */
	public AbstractNetworkServer(long id, int port, String host, boolean noNativeTransport) {
		this.id = id;
		this.port = port;
		this.host = host;

		this.noNativeTransport = noNativeTransport;
		this.distributor = new HandlerDistributor();
	}

	/**
	 * Start.
	 */
	public abstract void start();

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
	 * Gets distributor.
	 *
	 * @return the distributor
	 */
	public HandlerDistributor getDistributor() {
		return distributor;
	}
}
