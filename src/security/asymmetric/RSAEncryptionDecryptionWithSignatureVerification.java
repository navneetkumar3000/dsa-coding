package security.asymmetric;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class RSAEncryptionDecryptionWithSignatureVerification {
    public static void main(String[] args) throws Exception {

        // 1. Generate Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // 2. Encrypt
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encrypted = cipher.doFinal("Hello RSA".getBytes());

        // 3. Decrypt
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));

        // 4. Sign
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update("Hello RSA".getBytes());
        byte[] sign = signature.sign();

        // 5. Verify
        signature.initVerify(keyPair.getPublic());
        signature.update("Hello RSA".getBytes());
        System.out.println("Signature valid: " + signature.verify(sign));
    }
}
