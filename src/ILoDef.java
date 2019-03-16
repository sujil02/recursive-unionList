import java.util.Set;

public interface ILoDef extends ListADT<BSLDefinition> {
  ILoDef add(BSLDefinition a);

  /**
   * This method add defined function names to the set which is then use to validate the
   * expression.
   *
   * @param hash_set defined function name present in the code so far.
   * @return updated hash_set.
   */
  Set<String> addDefinedFunctionNames(Set<String> hash_set);
}

// an empty list of expressions
class MtLoDef implements ILoDef {

  @Override
  public ILoDef add(BSLDefinition a) {
    return new ConsLoDef(a, this);
  }

  @Override
  public Set<String> addDefinedFunctionNames(Set<String> hash_set) {
    return null;
  }
}

// a non-empty list of definitions.
class ConsLoDef implements ILoDef {
  private BSLDefinition first;
  private ILoDef rest;

  ConsLoDef(BSLDefinition first, ILoDef rest) {
    this.first = first;
    this.rest = rest;
  }

  public ILoDef add(BSLDefinition a) {
    rest = rest.add(a);
    return this;
  }

  @Override
  public Set<String> addDefinedFunctionNames(Set<String> hash_set) {
    hash_set.addAll(first.getDefinedFunctionNames());
    rest.addDefinedFunctionNames(hash_set);
    return hash_set;
  }

}