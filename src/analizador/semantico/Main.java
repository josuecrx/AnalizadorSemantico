package analizador.semantico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingresa una declaración (ejemplo: 'int x;' o 'x;') o 'exit' para salir:");
            String input = scanner.nextLine();

            // Salir del programa
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                // Procesar la entrada del usuario
                processInput(input, analyzer);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage()); // Imprimir el mensaje de error
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private static void processInput(String input, SemanticAnalyzer analyzer) {
    input = input.trim();

    if (input.matches("^(int|float|String) \\w+;$")) {
        // Declaración de variable
        String[] parts = input.split(" ");
        String varType = parts[0]; // Tipo de variable (int, float, String)
        String varName = parts[1].substring(0, parts[1].length() - 1); // Nombre de variable
        VariableDeclaration varDecl = new VariableDeclaration(varName, varType);
        analyzer.visit(varDecl);
        System.out.println("Variable '" + varName + "' de tipo '" + varType + "' declarada correctamente.");
    } else if (input.endsWith(";")) {
        // Uso de variable
        String varName = input.substring(0, input.length() - 1).trim();
        VariableUsage varUsage = new VariableUsage(varName);
        analyzer.visit(varUsage);
        System.out.println("Variable '" + varName + "' usada correctamente.");
    } else {
        throw new RuntimeException("Error: declaración no válida.");
    }
}

}


