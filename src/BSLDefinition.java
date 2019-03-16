import java.util.ArrayList;

// a definition in BSL
interface BSLDefinition {

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
    ArrayList<String> definedFunctionNames = new ArrayList<String>();
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

