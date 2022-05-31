import com.gemini.generic.QuanticAPIBase;

import java.text.DateFormat;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testingvariable extends QuanticAPIBase {


    public static void main(String[] args) {


        String var2 = "pawansingh#unique-4##alpha-3##curr-ddMMyyyyhhmm#@gmail.com#unique-2##alpha-2##epoch-6#";
        char search = '#';             // Character to search is 'a'.

        int count=0;
        for(int i=0; i<var2.length(); i++)
        {
            if(var2.charAt(i) == search)
                count++;
        }

        //System.out.println("The Character '"+search+"' appears "+count+" times.");
    int number=count/2;
    for (int k=0;k<number;k++)
    {
        String s=  koi(var2);
        var2=s;
    }
        System.out.println(var2);

    }
    public static String koi(String var2){
        //String var2 = "pawansingh#unique-4#@gmail.com";
        // String var2="pawansingh#alpha-4##CURR-ddMMyyyyhh#gmail.com";
        // String var2="Pawansingh#alpha-4#@gmail.com";
        //String var2="pawan#EPOCH-3#@gmail.com
        //int first = variable.indexOf("#");
        //int second = variable.indexOf("#", first + 1);
        //    System.out.println(first);

        int firss = var2.indexOf("#");
        int secc = var2.indexOf("#", firss + 1);

        //  System.out.println(second);
        //String firstpart = variable.substring(0, first);
        //String Lastpart = variable.substring(second + 1);

        String firsttpart = var2.substring(0, firss);
        String Lastprt = var2.substring(secc + 1);


        // System.out.println(firstpart);
        //System.out.println(Lastpart + 1);
        // String Butter = variable.substring(first + 1, second);

        String bur = var2.substring(firss + 1, secc);
        //System.out.println(Butter);

        //   String[] arrays = Butter.split("-", 3);
        String[] arrays = bur.split("-", 3);
        //if (arrays[1].equals(String))
        // String po=arrays[1];
        // System.out.println(po);

        //int n = Integer.parseInt(arrays[1]);
//int n=Integer.parseInt(arrr[1]);

        // System.out.println(n);

        String user = arrays[0];
        String up = user.toUpperCase();
        //  System.out.println(user);

        //  boolean he = up.contains("UNIQUE");


        if (up.contains("UNIQUE")) {
            int n = Integer.parseInt(arrays[1]);
            if (n < 10) {
                int number = hola(n);
                var2 = firsttpart + number + Lastprt;
               // System.out.println(var2);
                return var2;
            } else {
                long currentTimestamp = System.currentTimeMillis();
                Long number = kase(currentTimestamp, n);
                var2 = firsttpart + number + Lastprt;
                //System.out.println(var2);
                return var2;
            }
        }



        else if (up.contains("CURR")) {
            String topi = arrays[1];
           String p= datetime(topi, firsttpart, Lastprt);
            return p;
        }

        else if (up.contains("ALPHA")) {
            int n = Integer.parseInt(arrays[1]);
            String popo = getAlphaNumericString(n);
           return firsttpart + popo + Lastprt;
           // System.out.println(firsttpart + popo + Lastprt);


        }
        else if (up.contains("EPOCH"))
        {
            int n=20;
            long currentTimestamp = System.currentTimeMillis();
            Long number = kase(currentTimestamp, n);
            var2 = firsttpart + number + Lastprt;
            //System.out.println(var2);
            return var2;
        }


              return null;}

    public static int hola(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);


    }

    public static long kase(long num, int n) {
        long first = (long) (num / Math.pow(10, Math.floor(Math.log10(num)) - n + 1));
        return first;
    }

    public static String datetime(String a, String firstpart, String lastpsrt) {

        //SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyy");
        //Date date = new Date();
        //System.out.println(formatter.format(date));


        DateFormat dateFormat = new SimpleDateFormat(a);
        Date dates = new Date();
        String s = dateFormat.format(dates);
        return firstpart + s + lastpsrt;
     //   System.out.println(firstpart + s + lastpsrt);


    }


    /////////////////////////////////

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    //
}

