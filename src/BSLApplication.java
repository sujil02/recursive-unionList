import java.util.Set;

//TODO 2: Create the BSLApplication class, which is a function application.
class BSLApplication extends BSLExpression {
  String bslFuncName;
  ILoExpr iLoExpr;

  public BSLApplication(String bslFuncName, ILoExpr iLoExpr) {
    this.bslFuncName = bslFuncName;
    this.iLoExpr = iLoExpr;
  }

  @Override
  public boolean getFuncName(Set<String> definedFunctions) {
    if (!definedFunctions.contains(bslFuncName))
      return false;
    return iLoExpr.check(definedFunctions);
  }
}
