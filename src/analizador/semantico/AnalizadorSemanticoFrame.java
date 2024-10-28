package analizador.semantico;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class AnalizadorSemanticoFrame extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton analyzeButton;

    // Conjunto de palabras clave de Java para verificación
    private static final Set<String> javaKeywords = new HashSet<>();

    static {
        // Añadir algunas palabras clave de Java como ejemplo
        javaKeywords.add("for");
        javaKeywords.add("while");
        javaKeywords.add("if");
        javaKeywords.add("else");
        javaKeywords.add("int");
        javaKeywords.add("double");
        javaKeywords.add("return");
        javaKeywords.add("class");
        javaKeywords.add("public");
        javaKeywords.add("static");
        javaKeywords.add("void");
    }

    public AnalizadorSemanticoFrame() {
        initComponents();
    }

    private void initComponents() {
        // Configuración de los componentes
        inputField = new JTextField(20);
        outputArea = new JTextArea(10, 30);
        analyzeButton = new JButton("Analizar");

        analyzeButton.addActionListener(e -> analyzeInput());

        // Diseño del JFrame
        setLayout(new java.awt.BorderLayout());
        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese una expresión:"));
        panel.add(inputField);
        panel.add(analyzeButton);

        add(panel, java.awt.BorderLayout.NORTH);
        add(new JScrollPane(outputArea), java.awt.BorderLayout.CENTER);

        setTitle("Analizador Semántico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centra la ventana
    }

    private void analyzeInput() {
        String input = inputField.getText().trim();

        if (javaKeywords.contains(input)) {
            outputArea.setText("Resultado: La palabra '" + input + "' es una palabra clave en Java.");
        } else if (isMathExpression(input)) {
            outputArea.setText("Resultado: La expresión matemática '" + input + "' es válida.");
        } else {
            outputArea.setText("Resultado: La entrada '" + input + "' no es una palabra clave ni una expresión matemática válida.");
        }
    }

    // Método para verificar si la entrada es una expresión matemática simple
    private boolean isMathExpression(String input) {
        return input.matches("[-+]?\\d+(\\.\\d+)?([*/+-]\\d+(\\.\\d+)?)*");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new AnalizadorSemanticoFrame().setVisible(true));
    }
}


