package security;

import javax.crypto.SecretKey;

public class AESTestingEncryption {
    public static void main(String[] args) throws Exception {

        SecretKey key = AESEncryptionDecryption.generateKey();

        String text = "Hello Secure World";
        String encrypted = AESEncryptionDecryption.encryption(text, key);
        String decrypted = AESEncryptionDecryption.decryption(encrypted, key);

        System.out.println("Original  : " + text);
        System.out.println("Encrypted : " + encrypted);
        System.out.println("Decrypted : " + decrypted);
    }
    /* AES --> Encryption --> Decryption
    1: Create a Secret Key
       -->generateKey() --> return SecretKey
       -->KeyGenerator.getInstance(ALGORITHM) --> KeyGenerator
       -->keyGenerator.init(128)
       -->finally return keyGenerator.generateKey()
    2: Create Encryption methods pass arguments as plainText, secretKey
       -->Cipher.getInstance(ALGORITHM) --> Cipher
       -->cipher.init(Cipher.ENCRYPT_MODE, secretKey)
       -->convert plainText to bytes --> cipher.doFinal(plainText.getBytes()) --> bytes[] encrypt
       --> finally return encrypted data --> Base64.getEncoder().encodingToString(encrypt)
    3: Create Decryption methods pass arguments cipherText, secretKey
       -->Cipher.getInstance(ALGORITHM) --> Cipher
       -->cipher.init(Cipher.DECRYPT_MODE, secretKey)
       -->convert cipherText to bytes --> Base64.getDecoder().decode(cipherText) --> bytes[] decrypt
       --> finally return original plainText --> new String(cipher.doFinal(decrypt))
       =============================================================================
       Plain Text ──(Secret Key)──▶ Cipher Text
       Cipher Text ──(Same Key)──▶ Plain Text
       =============================================================================
     */
}
