public class test {
    public static void main(String[] args) {
        String originalText = "\"I Love Algorithms\"";
        int offset = -546541;
        String cipher = CaesarCipher.encryptCaesarCipher(originalText, offset);
        System.out.println("Original Text: " + originalText);
        System.out.println("Cipher Text: " + cipher);
        String decipher = CaesarCipher.encryptCaesarCipher(cipher, -offset);
        System.out.println("Decipher Text: " + decipher);
        
        E_Frame E=new E_Frame();
    }
}
