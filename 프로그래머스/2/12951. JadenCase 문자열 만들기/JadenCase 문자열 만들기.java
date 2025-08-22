class Solution {
    public String solution(String s) {
        String answer = "";
        
        s = s.toLowerCase();
        boolean isFirst = true;
        
        for(int i=0; i<s.length(); i++)
        {
           char c = s.charAt(i);

           if(Character.isDigit(c))
           {
               answer+= Character.toString(c);
               isFirst = false;
               continue;
           }

           if(c == ' ')
           {
               answer+=Character.toString(c);
               isFirst = true;
               continue;
           }

           if(isFirst)
           {
               answer+=Character.toString(c).toUpperCase();    
               isFirst=false;
           }else{
               answer+=Character.toString(c);
           }
                              
        }
        
        return answer;
    }
}