package controller;

/**
 * Adattatore che permette il passaggio deli vari input al core.
 * @param <T> generico.
 */
public interface InputPort<T> {
    T getInput();
}
