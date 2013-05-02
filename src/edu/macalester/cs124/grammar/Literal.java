package edu.macalester.cs124.grammar;

/**
 * A substitution that always generates the same string.
 */
public class Literal implements Substitution {
    
    /**
     * @param value The output of this generator.
     */
	
	private String value;
	
    public Literal(String value) {
    	this.value = value;
    }
    
    /**
     * Appends this literal's value to the context's result.
     */
    @Override
    public void generate(GeneratorContext context) {
    	context.getResult().append(value);
    }
}




//   Substitution pope = new Literal("POPE");
// ...
//pope.generate(context);   // <-- appends "POPE" to the result
//pope.generate(context);   // <-- appends "POPE" to the result
//pope.generate(context);   // <-- appends "POPE" to the result

