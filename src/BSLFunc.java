import java.util.ArrayList;

//TODO 1: Create BSLFunction class
public interface BSLFunc extends BSLDefinition {
}

class BSLFunction implements BSLFunc {
  BSLVariable name;
  ILoVar iLoVar;
  BSLExpr bslExpr;

  public BSLFunction(BSLVariable name, ILoVar iLoVar, BSLExpr bslExpr) {
    this.name = name;
    this.iLoVar = iLoVar;
    this.bslExpr = bslExpr;
  }

  @Override
  public ArrayList<String> getDefinedFunctionNames() {
    ArrayList<String> definedFunctionNames = new ArrayList<String>();
    definedFunctionNames.add(name.variable);
    return definedFunctionNames;
  }
}

