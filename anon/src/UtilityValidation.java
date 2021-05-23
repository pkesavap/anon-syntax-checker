import java.util.Arrays;

public class UtilityValidation {

    public static String extractComment(String string) {
        //System.out.println(string);
        int st=0;
        int kcount=0;
        int count = countQuotes(string);
        String comment="";
        for(int i=0;i<string.length();i++) {

            if(string.charAt(i) == '\"') {
                while(count>0) {
                    if(string.charAt(i) == '\"') {
                        //System.out.prinln(string.charAt(i));
                        count--;
                    }
                    //System.out.println(string.charAt(i));

                    comment+=string.charAt(i);
                    i++;
                }
            }


        }
        return string.replace(comment,"");
        //return comment;
    }



    public static String[] split(String string) {
        String [] pair = new String[2];
        String cons = "";
        int count=2;
        int j=0;
        int k=0;
        while(count-->0) {

            cons = "";
            for (int i = k; i <string.length();i++) {
                if(k==0&&string.charAt(i) == ':') {
                    k=i+1;
                    break;
                }
              //  System.out.println("cons "+cons);
                cons+=string.charAt(i);
            }
            pair[j] = cons;
            j++;
        }

        return  pair;

    }

    public static String extractFromComment(String string) {

       // System.out.println("extractionFromComment "+string);
        int st=0;
        int kcount=0;
        int count = countQuotes(string);
        String comment="";
        for(int i=0;i<string.length();i++) {

            if(string.charAt(i) == '\"') {
                while(count>0) {
                    if(string.charAt(i) == '\"') {
                        //System.out.prinln(string.charAt(i));
                        count--;
                    }
                    //System.out.println(string.charAt(i));

                    comment+=string.charAt(i);
                    i++;
                }
            }


        }
        //System.out.println("RESULT "+comment);
        //return string.replace(comment,"");
        return comment;
    }

    public static boolean isEmpty(String string) {
        if(string.contains("E@F")) {
            return false;
        }
        if(string == null || string.isEmpty()) {
            return true;
        }
        return false;

    }

    public static boolean leftOverCommas(String string) {

        if(string.contains("E@F")) {
            string = string.replace("E@F","");
        }
        int count=0;
        for(int i=0;i<string.length();i++) {
            if(string.charAt(i)==',') {
                count++;
            }
        }
        if(string.length() == count) {
            return false;
        }
        return true;



    }

    private static int countQuotes(String string) {

        int count=0;

        for(int i=0;i<string.length();i++) {
            if(string.charAt(i) == '\"') {
                count++;
            }
        }
        return count;

    }
}
