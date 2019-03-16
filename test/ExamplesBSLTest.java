import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExamplesBSLTest {

  @Test
  public void test() {
    ExamplesBSL examplesBSL = new ExamplesBSL();
    Program myProgram = examplesBSL.helperToCreateExamplesBSL();
    Program myProgram2 = examplesBSL.helperToCreateExamplesBSL2();
    assertTrue(myProgram.allFunctionsDefined());
    assertFalse(myProgram2.allFunctionsDefined());
  }

  @Test
  public void testAllcomputeDefinedFunctions() {
  }
}