import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//TODO 3: Create the class Program, which has a list of definitions and a list of expressions
public class Program {
  ArrayList<BSLDefinition> bslDefinitions;
  ILoExpr bslExprs;

  public Program(ArrayList<BSLDefinition> bslDefinitions, ILoExpr bslExprs) {
    this.bslDefinitions = bslDefinitions;
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
    for (BSLDefinition a : bslDefinitions) {
      hash_Set.addAll(a.getDefinedFunctionNames());
    }
    return hash_Set;
  }
}
