package net.cakemc.networking.io;

/**
 * The interface Write.
 *
 * @param <T> the type parameter
 */
public interface Write<T> {
    /**
     * Write.
     *
     * @param t the t
     */
    void write(T t);
}
