
public class str {
    public static void CompressString(String st){
        // String newStr = ""; // without String Builder
        StringBuilder newStr = new StringBuilder(""); // With String Builder
        // aaabbbccdd
        for(int i=0; i<st.length(); i++){
            Integer count = 1;
            while(i<st.length()-1 && st.charAt(i) == st.charAt(i+1)){
                count++;
                i++;
            }
            // newStr += st.charAt(i);
            newStr.append(st.charAt(i));
            if(count > 1){
                // newStr += count.toString();
                newStr.append(count.toString());
            }
        }
        System.out.println("New Compress String is : "+ newStr);
    }
    public static void ToUpperCase(String st){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(st.charAt(0));
        sb.append(ch);

        for(int i = 1; i<st.length(); i++){
            if(st.charAt(i) == ' ' && i<st.length()-1){
                sb.append(st.charAt(i));
                i++;
                sb.append(Character.toUpperCase(st.charAt(i)));
            }else{
                sb.append(st.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static void LargestData(){
        String fruits[] = {"apple", "banan", "mango"};

        String largest = fruits[0];
        for(int i = 0; i< fruits.length; i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
        System.out.println("Largest String is : "+ largest);
    }
    public static void ShortestPath(String st){
        int x= 0, y = 0;
        for(int i = 0; i< st.length(); i++){
            char dir = st.charAt(i);
            if(dir == 'N'){
                y--;
            }else if(dir == 'S'){
                y++;
            }else if(dir =='W'){
                x++;
            }else if(dir == 'E'){
                x--;
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        double sd = Math.sqrt(x2+y2);
        System.out.println("Shortest distance is : "+ sd);
    }
    public static boolean Palindrom(String st){
        int n = st.length();
        for(int i = 0; i<n/2;i++){
            if(st.charAt(i) != st.charAt(n-1-i)){
                System.out.println("This is not a palindrom number.");
                return false;
            }
        }
        return true;
    }
    public static void substring(String st, int si, int ei){
        String substr = null;
        for(int i = si; i<=ei;i++){
            substr += st.charAt(i);
        }
        System.out.println("Substring is : "+substr);
    }

    public static void main(String[] args) {
        String st = "margram";
        String st1 = "efgh";

        System.out.println(st.charAt(1));
        
        if(Palindrom(st) == true){
            System.out.println("This is PALINDROM NUMBER");
        }
        System.out.println(st.substring(0,5));
        substring(st, 1, 3);

        String st2 = "WNEENESENNN";
        ShortestPath(st2);

        LargestData();

        // String builder

        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a'; ch<= 'z'; ch++){
            sb.append(ch);
        }
        System.out.println(sb.toString());
        System.out.println(sb.length());

        // convert all first letter to uppercase
        String st3 = "my name is md tarikul hassan mallick";
        ToUpperCase(st3);


        // Compress String
        String str4 = "aaabbcddde";
        CompressString(str4);

    }
}
