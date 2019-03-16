// a list of variables
interface ILoVar extends ListADT<BSLVariable> {

  BSLVariable get(int index) throws IllegalArgumentException;
}

// an empty list of variables
class MtLoVar implements ILoVar {


  @Override
  public ILoVar add(BSLVariable a) {
    return new ConsLoVar(a, this);
  }

  @Override
  public BSLVariable get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("End Reached");
  }
}

// a non-empty list of variables
class ConsLoVar implements ILoVar {
  private BSLVariable first;
  private ILoVar rest;

  ConsLoVar(BSLVariable first, ILoVar rest) {
    this.first = first;
    this.rest = rest;
  }


  @Override
  public ILoVar add(BSLVariable a) {
    rest = rest.add(a);
    return this;
  }

  @Override
  public BSLVariable get(int index) throws IllegalArgumentException {
    if (index == 0) {
      return first;
    }
    return rest.get(index - 1);
  }
}