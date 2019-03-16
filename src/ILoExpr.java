import java.util.Set;

public interface ILoExpr extends GenericListADTNode<BSLExpr> {
  ILoExpr add(BSLExpr a);

  public boolean check(Set<String> definedFunctions);
}

// an empty list of expressions
class MtLoExpr implements ILoExpr {

  @Override
  public ILoExpr add(BSLExpr a) {
    return new ConsLoExpr(a, this);
  }

  @Override
  public boolean check(Set<String> definedFunctions) {
    return true;
  }
}

// a non-empty list of expressions
class ConsLoExpr implements ILoExpr {
  BSLExpr first;
  ILoExpr rest;

  ConsLoExpr(BSLExpr first, ILoExpr rest) {
    this.first = first;
    this.rest = rest;
  }

  public ILoExpr add(BSLExpr a) {
    rest = rest.add(a);
    return this;
  }

  @Override
  public boolean check(Set<String> definedFunctions) {
    if (!definedFunctions.contains(first.getFuncName())) {
      return false;
    }
    return rest.check(definedFunctions);
  }

}
