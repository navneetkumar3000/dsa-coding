package security.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class ChaCha20UsingJava11 {
    public static void main(String[] args) throws Exception {

        KeyGenerator keyGen = KeyGenerator.getInstance("ChaCha20");
        SecretKey key = keyGen.generateKey();

        byte[] nonce = new byte[12];
        new SecureRandom().nextBytes(nonce);
        //Commented Line works with Jdk11+

//        ChaCha20ParameterSpec paramSpec =
//                new ChaCha20ParameterSpec(nonce, 1);

        Cipher cipher = Cipher.getInstance("ChaCha20");

//        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        byte[] encrypted = cipher.doFinal("Hello ChaCha20".getBytes());

//        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        byte[] decrypted = cipher.doFinal(encrypted);

        System.out.println(new String(decrypted));
    }
}
