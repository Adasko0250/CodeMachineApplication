package rot13;

public class Rot13Cipher {

    private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String phrase;

    public Rot13Cipher(String text) {
        this.phrase = text;
    }

    public Rot13Cipher() {
        phrase = "";
    }

    public String encode() {
        String code = "";

        char[] letters = phrase.toCharArray();
        for (char letter : letters) {
            boolean isLower = Character.isLowerCase(letter);
            Character _char = Character.toUpperCase(letter);
            int val = ALPHABET.indexOf(_char);
            int newVal = (val + 13) % 26;
            String newLetter = String.valueOf(ALPHABET.charAt(newVal));
            code += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();
        }

        return code;
    }

    public String decode() {
        String code = "";

        char[] letters = phrase.toCharArray();
        for (char letter : letters) {
            boolean isLower = Character.isLowerCase(letter);
            Character _char = Character.toUpperCase(letter);
            int val = ALPHABET.indexOf(_char);
            int newVal = (val + 13) % 26;
            String newLetter = String.valueOf(ALPHABET.charAt(newVal));
            code += (isLower) ? newLetter.toLowerCase() : newLetter.toUpperCase();
        }

        return code;
    }
}
