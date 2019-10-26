package rot13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rot13CipherTest {
    private static final String SAMPLE_PHRASE = "sample";
    private Rot13Cipher cipherRot13NoArg;
    private Rot13Cipher cipherRot13Phrase;

    @BeforeEach
    void setUp(){
        cipherRot13NoArg = new Rot13Cipher();
        cipherRot13Phrase = new Rot13Cipher(SAMPLE_PHRASE);
    }
    @DisplayName("Correct cipher instance with no args")
    @Test
    public void testIsRot13Exist(){
        Rot13Cipher rot13 = cipherRot13NoArg;
        assertNotNull(rot13);
    }
    @DisplayName("Correct cipher instance with phrase")
    @Test
    public void testPassStringToConstructor() {
        Rot13Cipher rot13 = cipherRot13Phrase;
        assertNotNull(rot13);
    }
    @Test
    public void testEncrypWhenNoTextThenEmptyString() {
        Rot13Cipher rot13 = cipherRot13NoArg;
        String encoded = rot13.encode();

        assertNotNull(encoded);
        assertEquals("", encoded);
    }

    @Test
    public void testEncrypWhenTextThenSameLenghtOfString() {
        Rot13Cipher rot13 = cipherRot13Phrase;
        String encoded = rot13.encode();

        assertNotNull(encoded);
        assertEquals(SAMPLE_PHRASE.length(), encoded.length());
    }
    @Test
    public void testSimpleEncodeMixedCase() {
        Rot13Cipher rot13 = new Rot13Cipher("abc");
        String code = "nop";
        String encoded = rot13.encode();
        assertEquals(code, encoded);

        rot13 = new Rot13Cipher("XYz");
        code = "KLm";
        encoded = rot13.encode();
        assertEquals(code, encoded);
    }
    @Test
    public void testDecrypWhenNoTextThenEmptyString() {
        Rot13Cipher cipher = cipherRot13NoArg;
        String decoded = cipher.decode();

        assertNotNull(decoded);
        assertEquals("", decoded);
    }
    @Test
    public void testSimpleDecodeMixedCase() {
        Rot13Cipher rot13 = new Rot13Cipher("noP");
        String code = "abC";
        String encoded = rot13.decode();
        assertEquals(code, encoded);

        rot13 = new Rot13Cipher("ABc");
        code = "NOp";
        encoded = rot13.decode();
        assertEquals(code, encoded);

        rot13 = new Rot13Cipher("ABza");
        code = "NOmn";
        encoded = rot13.decode();
        assertEquals(code, encoded);
    }

}