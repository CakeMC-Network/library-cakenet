package net.cakemc.networking.utils;

/**
 * The interface Factory.
 *
 * @param <T> the type parameter
 */
public interface Factory<T> {

    /**
     * New instance t.
     *
     * @return the t
     */
    public T newInstance();

}
