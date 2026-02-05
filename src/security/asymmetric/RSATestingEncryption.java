package security.asymmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class RSATestingEncryption {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        KeyPair keyPair = RSAEncryptionDecryption.generateKeyPair();
        String text = "Hello Secure World";
        String encrypt = RSAEncryptionDecryption.encrypt(text, keyPair.getPublic());
        String decrypt = RSAEncryptionDecryption.decrypt(encrypt, keyPair.getPrivate());
        System.out.println(text);
        System.out.println("Public Key : " + keyPair.getPublic() + " Private Kay : " + keyPair.getPrivate());
        System.out.println(encrypt);
        System.out.println(decrypt);
    }
}
