package edu.macalester.cs124.grammar;

import java.util.ArrayList;
import java.util.List;


/**
 * A substitution rule that performs multiple child substitutions in order.
 */
public class Sequence implements Substitution {
	
	private List<Substitution> seqList = new ArrayList<Substitution>();
    
    /**
     * Adds a new child substitution to the end of this sequence.
     */
    public void add(Substitution sub) {
    	seqList.add(sub);
  }
    
    /**
     * Calls generate() on each children substitution in turn.
     */
    @Override
    public void generate(GeneratorContext context) {
    	for (Substitution sub : seqList) {
    		sub.generate(context);
    	}
    }
}
