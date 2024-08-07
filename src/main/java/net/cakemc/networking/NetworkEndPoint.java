package net.cakemc.networking;

import net.cakemc.networking.cluster.ClusterNetworkId;
import net.cakemc.networking.thread.NetworkExecutorFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The type Network end point.
 */
public abstract class NetworkEndPoint {
    /**
     * The constant clusterId.
     */
    public static final ClusterNetworkId clusterId = new ClusterNetworkId();

    private static final Random RANDOM = ThreadLocalRandom.current();

    private final NetworkExecutorFactory executorFactory = new NetworkExecutorFactory();
    private final ExecutorService sharedService = executorFactory.newInstance();

    /**
     * Generate id long.
     *
     * @return the long
     */
    public static long generateId() {
        return clusterId.nextId();
    }

    /**
     * Gets shared service.
     *
     * @return the shared service
     */
    public ExecutorService getSharedService() {
        return sharedService;
    }

    /**
     * Gets executor factory.
     *
     * @return the executor factory
     */
    public NetworkExecutorFactory getExecutorFactory() {
        return executorFactory;
    }

}
