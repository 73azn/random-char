import java.util.Random;
import java.util.random.*;
public class Main {
    public static void main(String[] args) {



        randoName("this program are brute forcing the chars to be same as this string ");



    }
    public static void randoName(String name){

        try {

            long counter = 0;



        Random r = new Random();

        char[] amm = name.toCharArray();
        String temp = "";
        String full = "";
        char c = ' ';

        for (int i = 0 ; i <amm.length;i++){
            if (isArabic(""+amm[i])){

                c = (char)(r.nextInt(40)+'أ');
            }

            else{

                c = (char)(r.nextInt(26)+'a');
            }
            if (amm[i] == ' '){

                temp +=amm[i];
                i+=1;
            }

            temp+=c;

        }

        for (int i = 0 ; i<amm.length&&!full.equals(name) ; ){
            Thread.sleep( 20);
            counter++;

            if (isArabic(""+amm[i])){

                c = (char)(r.nextInt(40)+'أ');
            }

            else{

                c = (char)(r.nextInt(26)+'a');
            }


            System.out.println(full+c+temp.substring(i+1));

            if (amm[i] == ' '){

                full +=amm[i];
                i+=1;
            }

            else if (c == amm[i]){
                full+=c;

                i+=1;
            }




        }
            System.out.println(full);
            System.out.println("times looped: "+counter);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

    }
    private static boolean isArabic(String text){
        String textWithoutSpace = text.trim().replaceAll(" ",""); //to ignore whitepace
        for (int i = 0; i < textWithoutSpace.length();) {
            int c = textWithoutSpace.codePointAt(i);
            //range of arabic chars/symbols is from 0x0600 to 0x06ff
            //the arabic letter 'لا' is special case having the range from 0xFE70 to 0xFEFF
            if (c >= 0x0600 && c <=0x06FF || (c >= 0xFE70 && c<=0xFEFF))
                i += Character.charCount(c);
            else
                return false;

        }
        return true;
    }
    public static boolean isEnglish(String text) {

        boolean onlyEnglish = false;

        for (char character : text.toCharArray()) {

            if (Character.UnicodeBlock.of(character) == Character.UnicodeBlock.BASIC_LATIN
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_1_SUPPLEMENT
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.LATIN_EXTENDED_A
                    || Character.UnicodeBlock.of(character) == Character.UnicodeBlock.GENERAL_PUNCTUATION) {

                onlyEnglish = true;
            } else {

                onlyEnglish = false;
            }
        }

        return onlyEnglish;
    }
}