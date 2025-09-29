package controller;

/**
 * Adattatore che permette il passaggio dell'input al core.
 * @param <T> generico.
 */
public interface InputPort<T> {
    T getInput();
}
