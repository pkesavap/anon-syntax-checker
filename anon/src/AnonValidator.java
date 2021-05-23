import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class AnonValidator {

    AnonValidator() {
        new CommentValidation();
        new UtilityValidation();
        new QuoteValidation();
        new BracketValidation();
        new CommaValidation();
    }
    // TODO Auto-generate stub methods

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("./input.txt"));
        String input = null;
        StringBuilder sb = new StringBuilder();
        while ((input = in.readLine()) != null) {
            sb.append(input);
        }
        //System.out.println(sb.toString());
       // System.err.println(isValidJson(sb.toString()));
        // System.err.println(isValidJson("{:[{\"\":\"\"},],}"));
        //System.err.println(isValidJson("{a{b:c}}"));
        //System.err.println(isValidJson("{a:b,c:{e:f}}"));
        //System.err.println(isValidJson("{{a}}"));
        if(isValidJson(sb.toString())) {
            System.err.println("**************************************");
            System.err.println("###### The parsed ANON is VALID ######");
            System.err.println("**************************************");


        }
        else {
            System.err.println("#####################################");
            System.err.println("#####################################");
            System.out.println("The parsed ANON has failed the validation");

        }

 }


    private static boolean isValidJson(String string) {

        Stack<Character> stack = new Stack<Character>();
        int ilen = string.length();
        int skip=0;
        for (int i = 0; i < ilen; ++i) {
            char c = string.charAt(i);

            if (c == '{') {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);

            } else if (c == '}') {
                if (!BracketValidation.validBracks(stack)) {

                    //System.out.println("Braces validation failed");

                    return false;
                }
            } else if (c == ']') {
                if (!BracketValidation.validSquareBracks(stack)) {

                    //System.out.println("Square Braces validation failed ");

                    return false;
                }
            } else if (Character.isWhitespace(c) == false) {
                if(i>0&&(string.charAt(i-1)=='}'||string.charAt(i-1)==']')) {
                    if(string.charAt(i) == ',') {
                        skip=1;
                    }
                    else {
                        System.out.println("Missing comma");
                        return false;
                    }

                }
                if(skip!=1)
                stack.push(c);

                skip=0;

            }
           // System.out.println("Main " + i + " " + Arrays.toString(stack.toArray()));


        }
        if (stack.isEmpty())
            return true;
        //System.out.println(Arrays.toString(stack.toArray()));
        return false;
    }

}


/*
{
  "heroes": [
    {
      "real_name": "Clint Barton",
      "superhero_name": "Hawkeye",
    },
    {
      // Dr Strange does not have a separate superhero name
      "real_name": "Dr. Strange",
      "superhero_name": "Dr. Strange",
      "famous_dialogues": """Kaecilius: Mister...
Dr. Strange: Doctor
Kaecilius: Mister Doctor?
Dr. Strange: It's Strange.
Kaecilius: Maybe. Who am I to judge?
"""
    },
  ],
}

        return true;
    }
 */

