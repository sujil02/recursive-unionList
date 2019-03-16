import java.util.ArrayList;

/**
 * TODO 1: Create BSLFunction class. Where A function definition has a name, a list of variables,
 * and a body, which is an expression.
 */
interface BSLFunc extends BSLDefinition {
}

class BSLFunction implements BSLFunc {
  private BSLVariable name;
  private ILoVar iLoVar;
  private BSLExpr bslExpr;

  BSLFunction(BSLVariable name, ILoVar iLoVar, BSLExpr bslExpr) {
    this.name = name;
    this.iLoVar = iLoVar;
    this.bslExpr = bslExpr;
  }

  @Override
  public ArrayList<String> getDefinedFunctionNames() {
    ArrayList<String> definedFunctionNames = new ArrayList<>();
    definedFunctionNames.add(name.variable);
    return definedFunctionNames;
  }
}

