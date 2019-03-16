import java.util.Set;

public interface ILoDef {
  ILoDef add(BSLDefinition a);

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
  BSLDefinition first;
  ILoDef rest;

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