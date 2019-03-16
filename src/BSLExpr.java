// The following is code to represent an approximation of a subsection of Beginning Student Language
// https://docs.racket-lang.org/htdp-langs/beginner.html

// an expression in BSL
interface BSLExpr {
  String getFuncName();
}

abstract class BSLExpression implements BSLExpr {
  @Override
  public String getFuncName() {
    return null;
  }
}

// a number
class BSLInt extends BSLExpression {
  int num;

  BSLInt(int num) {
    this.num = num;
  }
}

// a boolean
class BSLBool extends BSLExpression {
  boolean bool;

  BSLBool(boolean bool) {
    this.bool = bool;
  }
}

// a string
class BSLString extends BSLExpression {
  String str;

  BSLString(String str) {
    this.str = str;
  }
}

// a variable (or name)
class BSLVariable extends BSLExpression {
  String variable;

  BSLVariable(String variable) {
    this.variable = variable;
  }

}

