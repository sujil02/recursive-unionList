import tester.Tester;

/**
 * TODO 4: Create an ExamplesBSL class, and define the field myProgram.
 */
class ExamplesBSL {

  /**
   * Creates a program as per the problem statement.
   *
   * @return an object of type problem havin a list of definitions and a list of expressions.
   */
  private Program helperToCreateExamplesBSL() {
    BSLDefinition bslDefinitionZero = new BSLConstant(new BSLVariable("Zero"), new BSLInt(0));
    ILoVar iLoVar = new ConsLoVar(new BSLVariable("a"), new MtLoVar()).add(new BSLVariable("b"));
    BSLFunc bslFuncTru = new BSLFunction(new BSLVariable("tru"), iLoVar, new BSLString("a"));
    BSLFunc bslFuncFals = new BSLFunction(new BSLVariable("fals"), iLoVar, new BSLString("b"));
    ILoVar iLoVar2 = new ConsLoVar(new BSLVariable("x"), new MtLoVar()).add(new BSLVariable("y"));
    BSLDefinition bslDefinitionstruct = new BSLStruct(new BSLVariable("posn"), iLoVar2);
    ILoDef bslDefs = new ConsLoDef(bslDefinitionZero, new MtLoDef()).add(bslFuncTru)
            .add(bslFuncFals).add(bslDefinitionstruct);
    ILoExpr iLoExpr = new ConsLoExpr(new BSLInt(2), new MtLoExpr()).add(new BSLString("b"));
    BSLApplication bslApplicationTru = new BSLApplication("tru", iLoExpr);
    ILoExpr iLoExprMakePosn = new ConsLoExpr(new BSLString("x"), new MtLoExpr()).add(new BSLString("y"));
    BSLApplication bslApplicationMakePosn = new BSLApplication("make-posn", iLoExprMakePosn);
    ILoExpr iLoExprPosnx = new ConsLoExpr(bslApplicationMakePosn, new MtLoExpr());
    BSLApplication bslApplicationPosnx = new BSLApplication("posn-x", iLoExprPosnx);
    ILoExpr iLoExprfals = new ConsLoExpr(bslApplicationPosnx, new MtLoExpr());
    BSLApplication bslApplicationfals = new BSLApplication("fals", iLoExprfals);
    ILoExpr bslExprs = new ConsLoExpr(bslApplicationTru, new MtLoExpr()).add(bslApplicationfals);
    return new Program(bslDefs, bslExprs);
  }

  /**
   * Extra helper method to create extra program type variables having extra BSLStruct
   * variable.
   *
   * @return an object of type problem havin a list of definitions and a list of expressions.
   */
  private Program helperToCreateExamplesBSL2() {
    BSLDefinition bslDefinitionZero = new BSLConstant(new BSLVariable("Zero"), new BSLInt(0));
    ILoVar iLoVar = new ConsLoVar(new BSLVariable("a"), new MtLoVar()).add(new BSLVariable("b"));
    BSLFunc bslFuncTru = new BSLFunction(new BSLVariable("tru"), iLoVar, new BSLString("a"));
    BSLFunc bslFuncFals = new BSLFunction(new BSLVariable("fals"), iLoVar, new BSLString("b"));
    ILoVar iLoVar2 = new ConsLoVar(new BSLVariable("x"), new MtLoVar()).add(new BSLVariable("y"))
            .add(new BSLVariable("5"));
    BSLDefinition bslDefinitionstruct = new BSLStruct(new BSLVariable("posn"), iLoVar2);
    ILoDef bslDefs = new ConsLoDef(bslDefinitionZero, new MtLoDef()).add(bslFuncTru)
            .add(bslFuncFals).add(bslDefinitionstruct);
    ILoExpr iLoExpr = new ConsLoExpr(new BSLInt(2), new MtLoExpr()).add(new BSLString("b"));
    BSLApplication bslApplicationTru = new BSLApplication("tru", iLoExpr);
    ILoExpr iLoExprMakePosn = new ConsLoExpr(new BSLString("x"), new MtLoExpr()).add(new BSLString("y"));
    BSLApplication bslApplicationMakePosn = new BSLApplication("make-posn", iLoExprMakePosn);
    ILoExpr iLoExprPosnx = new ConsLoExpr(bslApplicationMakePosn, new MtLoExpr());
    BSLApplication bslApplicationPosnx = new BSLApplication("posn-xy", iLoExprPosnx);
    ILoExpr iLoExprfals = new ConsLoExpr(bslApplicationPosnx, new MtLoExpr());
    BSLApplication bslApplicationfals = new BSLApplication("fals", iLoExprfals);
    ILoExpr bslExprs = new ConsLoExpr(bslApplicationTru, new MtLoExpr()).add(bslApplicationfals);
    return new Program(bslDefs, bslExprs);
  }

  /**
   * Extra helper method to create new type variables having extra BSLFunction variable.
   *
   * @return an object of type problem havin a list of definitions and a list of expressions.
   */
  private Program helperToCreateExamplesBSL3() {
    BSLDefinition bslDefinitionZero = new BSLConstant(new BSLVariable("Zero"), new BSLInt(0));
    ILoVar iLoVar = new ConsLoVar(new BSLVariable("a"), new MtLoVar()).add(new BSLVariable("b"));
    BSLFunc bslFuncTru = new BSLFunction(new BSLVariable("tru"), iLoVar, new BSLString("a"));
    BSLFunc bslFuncFals = new BSLFunction(new BSLVariable("fals"), iLoVar, new BSLString("b"));
    BSLFunc bslFuncAlpha = new BSLFunction(new BSLVariable("alpha"), iLoVar, new BSLString("a" + "b"));
    BSLFunc bslFuncBeta = new BSLFunction(new BSLVariable("beta"), iLoVar, new BSLString("b" + "a"));
    ILoVar iLoVar2 = new ConsLoVar(new BSLVariable("x"), new MtLoVar()).add(new BSLVariable("y"))
            .add(new BSLVariable("5"));
    BSLDefinition bslDefinitionstruct = new BSLStruct(new BSLVariable("posn"), iLoVar2);
    ILoDef bslDefs = new ConsLoDef(bslDefinitionZero, new MtLoDef()).add(bslFuncTru)
            .add(bslFuncFals).add(bslDefinitionstruct).add(bslFuncAlpha).add(bslFuncBeta);
    ILoExpr iLoExpr = new ConsLoExpr(new BSLInt(2), new MtLoExpr()).add(new BSLString("b"));
    BSLApplication bslApplicationTru = new BSLApplication("alpha", iLoExpr);
    ILoExpr bslExprs = new ConsLoExpr(bslApplicationTru, new MtLoExpr());
    return new Program(bslDefs, bslExprs);
  }

  /**
   * TODO: 5. Run real tests here.
   *
   * @param t Object of tester class
   * @return response if the test is passed or not.
   */
  boolean testIsAllFunctionsDefined(Tester t) {

    ExamplesBSL examplesBSL = new ExamplesBSL();
    Program myProgram = examplesBSL.helperToCreateExamplesBSL();
    Program myProgram2 = examplesBSL.helperToCreateExamplesBSL2();
    Program myProgram3 = examplesBSL.helperToCreateExamplesBSL3();
    return t.checkExpect(myProgram.allFunctionsDefined(), true) &&
            t.checkExpect(myProgram2.allFunctionsDefined(), false) &&
            t.checkExpect(myProgram3.allFunctionsDefined(), true);
  }


  boolean testDefinedFunctionsCount(Tester t) {

    ExamplesBSL examplesBSL = new ExamplesBSL();
    Program myProgram = examplesBSL.helperToCreateExamplesBSL();
    Program myProgram2 = examplesBSL.helperToCreateExamplesBSL2();
    Program myProgram3 = examplesBSL.helperToCreateExamplesBSL3();
    return t.checkExpect(myProgram.computeDefinedFunctions().size(), 7) &&
            t.checkExpect(myProgram2.computeDefinedFunctions().size(), 8) &&
            t.checkExpect(myProgram3.computeDefinedFunctions().size(), 10);
  }

}
