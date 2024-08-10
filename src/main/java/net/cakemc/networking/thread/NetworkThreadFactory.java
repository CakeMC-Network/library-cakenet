package net.cakemc.networking.thread;

import java.util.concurrent.ThreadFactory;

/**
 * The type Network thread factory.
 */
public class NetworkThreadFactory implements ThreadFactory {

	private int counter;

	private final boolean demonThreads;
	private final int priority;

	/**
	 * Instantiates a new Network thread factory.
	 */
	public NetworkThreadFactory() {
		this(false, Thread.NORM_PRIORITY);
	}

	/**
	 * Instantiates a new Network thread factory.
	 *
	 * @param demonThreads the demon threads
	 * @param priority     the priority
	 */
	public NetworkThreadFactory(boolean demonThreads, int priority) {
		this.demonThreads = demonThreads;
		this.priority = priority;
	}

	@Override
	public Thread newThread(Runnable runnable) {
		Thread thread = new Thread(runnable);

		thread.setDaemon(this.demonThreads);
		thread.setName("cake_net-%s".formatted(++counter));
		thread.setPriority(priority);

		return thread;
	}

	/**
	 * Gets counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

}
