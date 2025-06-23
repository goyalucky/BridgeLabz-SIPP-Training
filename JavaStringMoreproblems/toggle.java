package Assignments.JavaStringMoreproblems;

public class toggle {
    public static void main(String[] args) {
         String s = "Lucky";
        String ans = toggle(s);
        System.out.println(ans);
    }
     public static String toggle(String s){
      StringBuilder result = new StringBuilder();
      for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);

        if(Character.isLowerCase(ch)){
            result.append(Character.toUpperCase(ch));
        }
       else if(Character.isUpperCase(ch)){
            result.append(Character.toLowerCase(ch));
        }
        else{
            result.append(ch);
        }
      }
      return result.toString();
    }
}