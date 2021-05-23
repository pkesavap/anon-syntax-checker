import java.util.Arrays;
import java.util.Stack;


public class BracketValidation {

    BracketValidation(){

    }

    public static boolean validBracks(Stack<Character> stack) {
        //System.out.println(Arrays.toString(stack.toArray()));
        String jsonTemp="";
        char x ='\0';
        boolean flag=true;
        while(flag) {
            if(stack.isEmpty())
            {
                System.out.println("Unbalanced  Brackets");
                return false;
            }
            x = stack.pop();
            if (x == '{') {
                jsonTemp=jsonTemp+"E@F";
                //System.out.println("pUSHED "+jsonTemp);
                if(validateOthers(jsonTemp)) {
                    return true;
                }
                else {
                    System.out.println("Some validation failed");
                    return false;
                }

            }

            jsonTemp=x+jsonTemp;

        }
        return true;
    }

    public static boolean validSquareBracks(Stack<Character> stack) {
        //System.out.println(Arrays.toString(stack.toArray()));
        String jsonTemp="";
        char x ='\0';
        boolean flag=true;
        while(flag) {
            if(stack.isEmpty())
            {
                System.out.println("UNbalanced Square Brackets");
                return false;
            }
            x = stack.pop();
            if (x == '[') {
                jsonTemp=jsonTemp+"E@F";
               // System.out.println("pUSHED sQUARE "+jsonTemp);
                if(validateOthers(jsonTemp)) {
                    return true;
                }
                else {
                    System.out.println("Some validation failed");
                    return false;
                }
            }

            jsonTemp=x+jsonTemp;

        }
        return true;
    }

    public static boolean validateOthers(String string) {

        boolean vv = CommaValidation.commaValidation(string);
      //  System.out.println(vv);
        //System.out.println("String "+string);
        String keyValue[] = string.split(",");
        int valueKey=0;
      //  System.out.println(Arrays.toString(keyValue));
        for(int i=0;i<keyValue.length;i++) {
            //System.out.println("AKEY VA"+keyValue[i]);
            String key[] = UtilityValidation.split(keyValue[i]);
          // System.out.println("AR VA "+Arrays.toString(key));
           if(UtilityValidation.leftOverCommas(string)&&(UtilityValidation.isEmpty(key[0]) || UtilityValidation.isEmpty(key[1]))) {
               if(key[0].contains("E@F") || key[1].contains("E@F")) {

               } else {
                   System.out.println("Empty Key or Value, without quotes parsed");
                   return false;
               }
            }
            if(CommentValidation.validateBackspace(key[0])!=true|| CommentValidation.validateBackspace(key[1])!=true) {
                System.out.println("Backspace validation failed");
                return false;
            }
            else {
                System.out.println("Comment validation Passed...");
            }


            for(int j=0;j< key.length;j++) {
                //System.out.println("Key "+key[j]);
                if(UtilityValidation.isEmpty(key[j])) {
                    if(j>0&&(key[j].contains("E@F") || key[j-1].contains("E@F"))) {

                    } else {
                        if(UtilityValidation.leftOverCommas(string)) {
                            System.out.println("Quotes validation failed Empty Key/Value detected");
                            return false;
                        }
                    }

                }
                if(QuoteValidation.validateQuotes(key[j],j) == false) {
                    System.out.println("Quotes validation failed");
                    return  false;
                }
                else {
                    System.out.println("Quote Validation passed ...");
                }

            }
        }
        return  true;
    }
}