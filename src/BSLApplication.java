import java.util.Set;

//TODO 2: Create the BSLApplication class, which is a function application.
class BSLApplication extends BSLExpression {
  private String bslFuncName;
  private ILoExpr iLoExpr;

  BSLApplication(String bslFuncName, ILoExpr iLoExpr) {
    this.bslFuncName = bslFuncName;
    this.iLoExpr = iLoExpr;
  }

  @Override
  public boolean isFunctionNameInDefinedFunctions(Set<String> definedFunctions) {
    if (!definedFunctions.contains(bslFuncName))
      return false;
    return iLoExpr.check(definedFunctions);
  }
}
