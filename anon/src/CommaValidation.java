import java.util.Arrays;

public class CommaValidation {

        public static boolean commaValidation(String string) {
            if(string.contains("E@F")) {
                string = string.replace("E@F","");
            }
           // System.out.println("REPLACED " + string);
            String values[] = string.split(",");

            //System.out.println("Commas Values"+Arrays.toString(values));
            for(int i=0;i<values.length;i++) {
                if(values[i].length()<1) {
                    System.out.println("Comma Validation Failed");
                    return false;

                }
                }

            return true;
        }


}
