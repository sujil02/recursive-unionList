/**
 * This generic interface represents all the operations to be supported by a list of objects of type
 * T.
 */
public interface ListADT<T> {

  <R extends ListADT> R add(T a);

}
