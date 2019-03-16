import java.util.ArrayList;

import tester.Tester;

/**
 * TODO 4: Create an ExamplesBSL class, and define the field myProgram.
 */
public class ExamplesBSL {

  Program helperToCreateExamplesBSL() {
    ArrayList<BSLDefinition> bslDefinitions = new ArrayList<>();
    BSLDefinition bslDefinitionZero = new BSLConstant(new BSLVariable("Zero"), new BSLInt(0));
    ILoVar iLoVar = new ConsLoVar(new BSLVariable("a"), new MtLoVar()).add(new BSLVariable("b"));
    BSLFunc bslFuncTru = new BSLFunction(new BSLVariable("tru"), iLoVar, new BSLString("a"));
    BSLFunc bslFuncFals = new BSLFunction(new BSLVariable("fals"), iLoVar, new BSLString("b"));
    ILoVar iLoVar2 = new ConsLoVar(new BSLVariable("x"), new MtLoVar()).add(new BSLVariable("y"));
    BSLDefinition bslDefinitionstruct = new BSLStruct(new BSLVariable("posn"), iLoVar2);
    bslDefinitions.add(bslDefinitionZero);
    bslDefinitions.add(bslFuncTru);
    bslDefinitions.add(bslFuncFals);
    bslDefinitions.add(bslDefinitionstruct);
    ILoDef bslDefs = new ConsLoDef(bslDefinitionZero, new MtLoDef()).add(bslFuncTru).add(bslFuncFals).add(bslDefinitionstruct);
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
   * TODO: 5. Run real tests here.
   *
   * @param t Object of tester class
   * @return response if the test is passed or not.
   */
  boolean testAllFunctionsDefined(Tester t) {

    ExamplesBSL examplesJSON = new ExamplesBSL();
    Program myProgram = examplesJSON.helperToCreateExamplesBSL();
    return t.checkExpect(myProgram.allFunctionsDefined(), true);
  }

}
