package net.cakemc.lib.cakenet.handler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * The type Handler distributor.
 */
public class HandlerDistributor {

	private final List<HandlerEntry<?>> handlers = new CopyOnWriteArrayList<>();

	/**
	 * Register handler.
	 *
	 * @param <T>     the type parameter
	 * @param type    the type
	 * @param handler the handler
	 */
	public <T> void registerHandler(HandlerType type, AbstractNetworkHandler<T> handler) {
		handlers.add(new HandlerEntry<T>(type, handler));
	}

	/**
	 * Unregister all.
	 *
	 * @param type the type
	 */
	public void unregisterAll(HandlerType type) {
		handlers.removeIf(handlerEntry -> handlerEntry.type == type);
	}

	/**
	 * Call.
	 *
	 * @param <T>         the type parameter
	 * @param handlerType the handler type
	 * @param value       the value
	 */
	public <T> void call(HandlerType handlerType, T value) {
		this.handlers.stream().filter(handlerEntry -> handlerEntry.type == handlerType &&
		                                              value.getClass().equals(handlerEntry.type.getHandlerType()))
		             .map(handlerEntry -> (AbstractNetworkHandler<T>) handlerEntry.handler)
		             .forEachOrdered(handler -> handler.handle(value));
	}

	/**
	 * The type Handler entry.
	 *
	 * @param <T> the type parameter
	 */
	public static final class HandlerEntry<T> {
		private final HandlerType type;
		private final AbstractNetworkHandler<T> handler;

		/**
		 * Instantiates a new Handler entry.
		 *
		 * @param type    the type
		 * @param handler the handler
		 */
		public HandlerEntry(HandlerType type, AbstractNetworkHandler<T> handler) {
			this.type = type;
			this.handler = handler;
		}

		/**
		 * Gets handler.
		 *
		 * @return the handler
		 */
		public AbstractNetworkHandler<T> getHandler() {
			return handler;
		}

		/**
		 * Gets type.
		 *
		 * @return the type
		 */
		public HandlerType getType() {
			return type;
		}
	}

}
