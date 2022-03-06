import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SqueakyClean {
    public static void main(String[] args) {
        String string = " a car ";
        char[] stringToChar = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringToChar.length; i++) {
            if (stringToChar[i] == ' ') {
                sb.append('_');
            } else {
                sb.append(stringToChar[i]);
            }
        }

        System.out.println(sb.toString());
    }
    static String clean(String identifier) {
        //take input of string and convert into characters
        //then covert empty spaces into underscores and build back into string
        char[] stringToChar = identifier.toCharArray();
        StringBuilder sb = new StringBuilder();
        String regex = "\\p{InGreek}";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < stringToChar.length; i++) {
            Matcher matcher = pattern.matcher(String.valueOf(stringToChar[i]));
            if (stringToChar[i] == ' ') {
                sb.append('_');
            } else if (stringToChar[i] == '\0') {
                sb.append("CTRL");
            } else if (stringToChar[i] == '-') {
                sb.append(Character.toUpperCase(stringToChar[i+1]));
                i++;
            } else if (matcher.find() && Character.isLowerCase(stringToChar[i])) {
                sb.append("");
            } else if (stringToChar[i] == '\uD83D' || stringToChar[i] == '\uDE00') {
                sb.append("");
            } else if (!Character.isLetter(stringToChar[i])) {
                sb.append("");
            } else {
                    sb.append(stringToChar[i]);
                }
            } return sb.toString();
        }


}
