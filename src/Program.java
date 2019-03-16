import java.util.HashSet;
import java.util.Set;

//TODO 3: Create the class Program, which has a list of definitions and a list of expressions
public class Program {
  ILoDef bslDefs;
  ILoExpr bslExprs;

  public Program(ILoDef bslDefs, ILoExpr bslExprs) {
    this.bslDefs = bslDefs;
    this.bslExprs = bslExprs;
  }

  boolean allFunctionsDefined() {
    Set<String> hash_Set = computeDefinedFunctions();
    return computeIsAllFunctionsDefined(hash_Set);
  }

  private boolean computeIsAllFunctionsDefined(Set<String> hash_set) {
    return bslExprs.check(hash_set);
  }

  private Set<String> computeDefinedFunctions() {
    Set<String> hash_Set = new HashSet<>();
    return bslDefs.addDefinedFunctionNames(hash_Set);
  }
}
