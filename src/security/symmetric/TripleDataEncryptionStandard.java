package security.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class TripleDataEncryptionStandard {
    public static void main(String[] args) throws Exception {

        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        keyGen.init(168);
        SecretKey key = keyGen.generateKey();

        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");

        //Encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal("Hello 3DES".getBytes());
        System.out.println("Encryption : " + Base64.getEncoder().encodeToString(encrypted));

        //Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Original Input : " + new String(decrypted));
    }
}