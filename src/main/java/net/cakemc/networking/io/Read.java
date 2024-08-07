package net.cakemc.networking.io;

/**
 * The interface Read.
 *
 * @param <T> the type parameter
 * @param <V> the type parameter
 */
public interface Read<T, V> {
    /**
     * Read v.
     *
     * @param source the source
     * @return the v
     */
    V read(T source);
}
