/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Shabab
 */
public class Ai {
    
    private static final String[] table_input = new String[]{"What is your name?", 
        "Hello", "What are you?", "What is your favorite book?", "Tell me your favorite quote",
        "What is your favorite movie?", "Do you know Siri?", "Who created you?", "Do you like being in a computer?",
        "Do you want to be more intelligent?"
    };
    
    private static final String[] table_action = new String[]{"My name is GadhaGasker",
        "Hi!", "I am a simple agent program", "My favorite book is \"The Kite Runner\" by Khaled Hosseini", "The secret of getting ahead is getting started", 
        "My favorite movie is Shawshank Redemption", "Yes, she's a good friend of mine", "Shabab created me", "Yes, I find it quite comfortable in a computer",
        "Obviously I want to be much more intelligent"
    };
    
    public String getResponse(String input)
    {
        input = input.trim();
        for(int c = 0; c < table_input.length; c++)
        {
            if(table_input[c].equalsIgnoreCase(input))
            {
                return table_action[c];
            }
        }
        
        return "Sorry, I do not understand what you are saying based on my current implementation";
    }
    
    public String[] getTableInputs()
    {
        return table_input;
    }
}
    

