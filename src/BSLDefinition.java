import java.util.ArrayList;

// a definition in BSL
interface BSLDefinition {

  /**
   * Returns all possible defined function name for this type of definition.
   *
   * @return List of all possible approved function name.
   */
  ArrayList<String> getDefinedFunctionNames();
}

// a constant definition
class BSLConstant implements BSLDefinition {
  BSLVariable name;
  BSLExpr definition;

  BSLConstant(BSLVariable name, BSLExpr definition) {
    this.name = name;
    this.definition = definition;
  }


  @Override
  public ArrayList<String> getDefinedFunctionNames() {
    ArrayList<String> definedFunctionNames = new ArrayList<>();
    definedFunctionNames.add(name.variable);
    return definedFunctionNames;
  }
}

// a structure definition
class BSLStruct implements BSLDefinition {
  BSLVariable name;
  ILoVar fields;

  BSLStruct(BSLVariable name, ILoVar fields) {
    this.name = name;
    this.fields = fields;
  }

  /**
   * Adds make-structname, structname?, or structname-structfield, where structname is the name of a
   * struct, and structfield is a field of that struct.
   *
   * @return List of all possible defined names.
   */
  @Override
  public ArrayList<String> getDefinedFunctionNames() {
    ArrayList<String> definedFunctionNames = new ArrayList<String>();
    definedFunctionNames.add("make-" + name.variable);
    definedFunctionNames.add(name.variable + "?");
    int i = 0;
    while (true) {
      try {
        definedFunctionNames.add(name.variable + "-" + fields.get(i++).variable);
      } catch (IllegalArgumentException e) {
        break;
      }
    }
    return definedFunctionNames;
  }
}

