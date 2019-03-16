
//TODO 2: Create the BSLApplication class, which is a function application.
class BSLApplication extends BSLExpression {
  String bslFuncName;
  ILoExpr iLoExpr;

  public BSLApplication(String bslFuncName, ILoExpr iLoExpr) {
    this.bslFuncName = bslFuncName;
    this.iLoExpr = iLoExpr;
  }

  @Override
  public String getFuncName() {
    return bslFuncName;
  }
}
