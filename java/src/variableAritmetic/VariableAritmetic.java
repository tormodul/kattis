package variableAritmetic;


import java.util.*;

public class VariableAritmetic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> variables = new HashMap<>();

        boolean done = false;
        
        
        while (!done) {
            String line = in.nextLine();
            String[] lines = line.split(" ");

            if (line.equals("0")) {
                done = true;
            } else if (lines.length > 1 && lines[1].charAt(0) == '=') {
                // Store the variable and the value in the variables map
                variables.put(lines[0], Integer.parseInt(lines[2]));
            } else if (lines.length > 1 && lines[1].charAt(0) == '+') {
                
            }



        }
        

        
    }
}
