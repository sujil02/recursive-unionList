/**
 * This generic interface represents all the operations to be supported by a list of objects of type
 * T.
 */
public interface ListADT<T> {
  /**
   * Add an object to this list
   *
   * @param a the object to be added to the list
   */
  <R extends ListADT> R add(T a);

}
