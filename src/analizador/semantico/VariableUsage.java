package analizador.semantico;

class VariableUsage extends ASTNode {
    private String name;

    public VariableUsage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

