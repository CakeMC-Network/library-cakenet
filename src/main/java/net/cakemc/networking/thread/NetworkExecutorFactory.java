package net.cakemc.networking.thread;

import net.cakemc.networking.utils.Factory;

import java.util.concurrent.*;

/**
 * The type Network executor factory.
 */
public class NetworkExecutorFactory implements Factory<ExecutorService> {

    private final ThreadFactory threadFactory;

    /**
     * Instantiates a new Network executor factory.
     */
    public NetworkExecutorFactory() {
        this(new NetworkThreadFactory());
    }

    /**
     * Instantiates a new Network executor factory.
     *
     * @param threadFactory the thread factory
     */
    public NetworkExecutorFactory(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override
    public ExecutorService newInstance() {
        if (threadFactory != null)
            return new ThreadPoolExecutor(0, 8,
                    3L, TimeUnit.SECONDS, new SynchronousQueue<>(), threadFactory);

        return Executors.newCachedThreadPool();
    }

    /**
     * Gets thread factory.
     *
     * @return the thread factory
     */
    public ThreadFactory getThreadFactory() {
        return threadFactory;
    }

}
