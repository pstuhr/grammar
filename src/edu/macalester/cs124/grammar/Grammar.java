package edu.macalester.cs124.grammar;

import java.util.HashMap;
import java.util.Map;


/**
 * A context-free grammar, suitable for generating pleasing nonsense. A grammar contains a set of string symbols,
 * and maps those symbols to substitutions. For example, the symbol “person” might map to a {@link Choice} between
 * two {@link Literal}s, “Alice” and “Bob”.
 */
public class Grammar {
    /**
     * Returns the substitution rule for a given symbol. Creates a new rule if one does not already exist.
     * 
     * Note that every symbol maps to a {@link Choice}, even if the choice contains only one option.
     * This allows the class to support multiple calls to addSubstitution().
     * 
     * @param symbol  The lookup key for the symbol (e.g. “person” in the example at the top of this class)
     */
	private Map<String, Choice> choiceMap = new HashMap<String,Choice>();
	
    public Choice substitutionForSymbol(String symbol) {
    	if (choiceMap.containsKey(symbol)) {
    		return choiceMap.get(symbol);
    	}
    	else {
    		Choice choice = new Choice();
    		choiceMap.put(symbol, choice);
    		return choice;
    	}
    }
    
    /**
     * Adds a new substitution to the choices for the given symbol.
     */
    public void addSubstitution(String symbol, Substitution substitution) {
        substitutionForSymbol(symbol).addChoice(substitution);
    }

    /**
     * Generates nonsense by randomly traversing the grammar.
     * 
     * @param startSymbol  The symbol with which to begin the substitution process.
     * @return A random String generated by the grammar.
     */
    public String generate(String startSymbol) {
        GeneratorContext context = new GeneratorContext();
        substitutionForSymbol(startSymbol).generate(context);
        return context.getResult().toString();
    }
}
