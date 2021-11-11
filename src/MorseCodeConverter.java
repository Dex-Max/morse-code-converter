import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utility class that converts morse code to English
 * @author Randall Kim
 */
public class MorseCodeConverter {
    private static MorseCodeTree tree = new MorseCodeTree();

    /**
     * Converts morse code in file to a String
     * @param codeFile File that contains code
     * @return converted String
     */
    public static String convertToEnglish(File codeFile){
        try {
            Scanner scanner = new Scanner(codeFile);
            return convertToEnglish(scanner.nextLine());
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Converts morse code to a String
     * @param code String that contains code
     * @return converted String
     */
    public static String convertToEnglish(String code){
        Scanner scanner = new Scanner(code);
        String result = "";

        while(scanner.hasNext()){
            String letterCode = scanner.next();

            if(letterCode.equals("/")){
                result += " ";
            } else {
                String letter = tree.fetch(letterCode);
                result += letter;
            }
        }

        return result;
    }

    /**
     * Gets all nodes of the tree that contains letters
     * @return String containing all nodes
     */
    public static String printTree(){
        ArrayList<String> list = tree.toArrayList();
        String result = "";

        for(String s : list){
            result += (" " + s);
        }

        return result.trim();
    }
}
