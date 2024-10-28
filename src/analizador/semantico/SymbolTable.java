package analizador.semantico;

import java.util.HashMap;
import java.util.Map;

class SymbolTable {
    private Map<String, String> symbols = new HashMap<>();

    public void define(String name, String type) {
        symbols.put(name, type);
    }

    public boolean exists(String name) {
        return symbols.containsKey(name);
    }
}

