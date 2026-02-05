package security.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class ECDSAEncryptionDecryption {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(256);
        KeyPair keyPair = kpg.generateKeyPair();

        Signature sig = Signature.getInstance("SHA256withECDSA");

        // Sign
        sig.initSign(keyPair.getPrivate());
        sig.update("Hello ECDSA".getBytes());
        byte[] signature = sig.sign();

        // Verify
        sig.initVerify(keyPair.getPublic());
        sig.update("Hello ECDSA".getBytes());
        System.out.println("Signature valid: " + sig.verify(signature));
    }
}
