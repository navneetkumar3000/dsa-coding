package security.asymmetric;

import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class X25519 {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("X25519");

        KeyPair a = kpg.generateKeyPair();
        KeyPair b = kpg.generateKeyPair();

        KeyAgreement kaA = KeyAgreement.getInstance("X25519");
        kaA.init(a.getPrivate());
        kaA.doPhase(b.getPublic(), true);
        byte[] secretA = kaA.generateSecret();

        KeyAgreement kaB = KeyAgreement.getInstance("X25519");
        kaB.init(b.getPrivate());
        kaB.doPhase(a.getPublic(), true);
        byte[] secretB = kaB.generateSecret();

        System.out.println("Shared secret equal: " +
                Arrays.equals(secretA, secretB));
    }
}