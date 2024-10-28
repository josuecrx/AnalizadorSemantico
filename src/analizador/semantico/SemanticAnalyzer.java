package analizador.semantico;

class SemanticAnalyzer {
    private SymbolTable symbolTable = new SymbolTable();

    public void visit(VariableDeclaration varDecl) {
        String varName = varDecl.getName();
        if (symbolTable.exists(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' ya está definida.");
        }
        symbolTable.define(varName, varDecl.getType()); // Guardar el tipo de variable
    }

    public void visit(VariableUsage varUsage) {
        String varName = varUsage.getName();
        if (!symbolTable.exists(varName)) {
            throw new RuntimeException("Error: Variable '" + varName + "' no está definida.");
        }
    }
}


