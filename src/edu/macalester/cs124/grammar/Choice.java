package edu.macalester.cs124.grammar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A multiple choice substitution. When generating content, objects of this class select one of
 * their choices.
 */
public class Choice implements Substitution {
	
	private List<Substitution> choiceList = new ArrayList<Substitution>();
    
    /**
     * Adds the given substitutions to the existing list of choices.
     */
    public void addChoice(Substitution substitution) {
    	choiceList.add(substitution);
    }
    
    /**
     * Randomly selects one of the choices, and calls its generate() method.
     * Raises an exception if addChoice() has never been called and there are no choices.
     */
    @Override
    public void generate(GeneratorContext context) {
    	Random random = context.getRandom();
    	int numb = random.nextInt(choiceList.size());
    	choiceList.get(numb).generate(context);
    }
}
