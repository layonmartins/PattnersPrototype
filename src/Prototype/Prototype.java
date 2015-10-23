package Prototype;

/**
 * Interface para padronizar os objetos que seram clonados.
 * @author thunder
 *
 * @param <T>
 */
public interface Prototype<T> {
	T clone();
}
