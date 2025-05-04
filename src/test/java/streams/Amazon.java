package streams;

import com.google.common.base.Function;

import java.util.*;

public class Amazon {


        public static void main(String []args){
            // System.out.println("Hello World");

            String sentence = "geeks for geeks";

            System.out.println(
                    printAlphabet(sentence)
//                    sortString.apply("geeksforgeeks")
            );


        }

        private static String printAlphabet(String str){
            String firstLetters = "";
            String [] words = str.split(" ");

            // for (int i = 0; i<words.length; i++ ){
            //     firstLetters += words[i].charAt(0);
            // }

            // for (String s : words) {
            //     firstLetters += s.charAt(0);
            // }

//            for (String s : words) {
//                firstLetters += getFirstChar.apply(s).toString();
//            }

            for (String s : words){
                firstLetters += sortString.apply(s);
            }

            return firstLetters;
        }

        static Function<String , Character > getFirstChar = words -> words.charAt(0);

        static Function <String, String> sortString = str -> {
          char [] ch = str.toCharArray();
          Arrays.sort(ch);
          return new String(ch);
        };
}
