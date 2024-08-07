package net.cakemc.networking.codec;

/**
 * The type Codec.
 *
 * @param <From> the type parameter
 * @param <To>   the type parameter
 */
public abstract class Codec<From, To> {

    /**
     * Decode.
     *
     * @param from the from
     */
    public abstract void decode(From from);

    /**
     * Encode to.
     *
     * @param from the from
     * @return the to
     */
    public abstract To encode(From from);

}
