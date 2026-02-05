package security.asymmetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class Ed25519 {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = kpg.generateKeyPair();

        Signature sig = Signature.getInstance("Ed25519");

        // Sign
        sig.initSign(keyPair.getPrivate());
        sig.update("Hello Ed25519".getBytes());
        byte[] signature = sig.sign();

        // Verify
        sig.initVerify(keyPair.getPublic());
        sig.update("Hello Ed25519".getBytes());
        System.out.println("Signature valid: " + sig.verify(signature));
    }
}