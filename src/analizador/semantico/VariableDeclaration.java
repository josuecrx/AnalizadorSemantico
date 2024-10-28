package analizador.semantico;

class VariableDeclaration extends ASTNode {
    private String name;
    private String type; // Nuevo campo para el tipo

    public VariableDeclaration(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type; // Método para obtener el tipo
    }
}


