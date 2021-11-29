
import java.util.*;

public class RandStringGen {
// JAVA Program to generate random alphabets
//import java.util.*;

//    class GFG
//    {
//
        static int MAX = 26;

        // Returns a String of random alphabets of
// length n.
        static String printRandomString(int n)
        {
            char []alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
                    'h', 'i', 'j', 'k', 'l', 'm', 'n',
                    'o', 'p', 'q', 'r', 's', 't', 'u',
                    'v', 'w', 'x', 'y', 'z' };

            String res = "";
            for (int i = 0; i < n; i++)
                res = res + alphabet[(int) (Math.random() * 10 % MAX)];

            return res;
        }

        // Driver code
        public static void main(String[] args)
        {
            int n = 85;

            for(int x =0; x<850; x++)
                System.out.println(printRandomString(n));
        }
    }

// This code is contributed by Rajput-Ji





