public class QuoteValidation {

    public static boolean validateQuotes(String string, int value) {
        if(string=="" || string.length()<1) {
            return true;
        }
        string = UtilityValidation.extractFromComment(string);
       // System.out.println("SSS-->"+string+" "+value);

        boolean flag = true;
        int count=0;
        int count2=0;
        int st=-1;
        for(int i=0;i<string.length();i++) {
            if (string.charAt(i) == '\"') {
                if(st == -1) {
                    st = i;
                }
                count++;
            }
        }
        if(count ==0) {
            return true;
        }
        if(count%2 != 0) {
            System.out.println("Quote validation failed at "+string.charAt(st));
            return false;
        }
        int j=string.length()-1;
        for(int i=st;i<string.length();i++) {
            if(i>j-i) {
                break;
            }
            if(string.charAt(i) == '\"' && string.charAt(j-i) == '\"') {
                count2++;

            } else {
                break;
            }
        }
        if(count2>=2&&value==0){
            System.out.println("Quote validation failure "+string.charAt(st));

            return false;
        }
        if(2*count2==count) {
            return true;
        }
       // System.out.println("count2 "+ count2+" count "+count);
        System.out.println("Quote validation failed");
        return false;
    }

}
