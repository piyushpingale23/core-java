import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Practice {

    public static void main(String[] args) {

       String s = "piyush ingale";
       List<Character> duplicateCharList = new ArrayList<>();

       for (int i = 0; i < s.length(); i++) {

           if (s.contains(String.valueOf(s.charAt(i)))) {
               duplicateCharList.add(s.charAt(i));
           }
       }

        System.out.println(duplicateCharList);


    }

}
