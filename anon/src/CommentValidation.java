public class CommentValidation {

     static boolean validateBackspace(String string) {

        if(string.contains("/") == false) {
            return true;
        }
        string = UtilityValidation.extractComment(string);

        int count=0;
        int st=-1;
        for(int i=0;i<string.length();i++) {
            if(string.charAt(i) == '/') {
                if(st == -1) {
                    st=i;
                }
                count++;

            }
            //System.out.println("extracted comment"+string+" "+count);

        }
         if(count<2) {
             if(st != -1) {
                 System.out.println("Comment validation failed at " + string.charAt(st) + " in" + string.substring(0, st + 1) + "<-");
                 return false;
             }
         }

        return true;
    }
}
