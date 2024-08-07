package net.cakemc.networking.handler;

/**
 * The type Abstract network handler.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractNetworkHandler<T> {

    /**
     * Handle.
     *
     * @param element the element
     */
    public abstract void handle(T element);

}
