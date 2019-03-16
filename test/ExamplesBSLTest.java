import org.junit.Test;

import static org.junit.Assert.*;

public class ExamplesBSLTest {

  @Test
  public void test() {
    ExamplesBSL examplesJSON = new ExamplesBSL();
    Program example = examplesJSON.helperToCreateExamplesBSL();
    assertTrue(example.allFunctionsDefined());

  }
}