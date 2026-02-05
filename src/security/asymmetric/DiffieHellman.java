package security.asymmetric;

import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class DiffieHellman {

    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048);

        KeyPair a = kpg.generateKeyPair();
        KeyPair b = kpg.generateKeyPair();

        KeyAgreement kaA = KeyAgreement.getInstance("DH");
        kaA.init(a.getPrivate());
        kaA.doPhase(b.getPublic(), true);
        byte[] secretA = kaA.generateSecret();

        KeyAgreement kaB = KeyAgreement.getInstance("DH");
        kaB.init(b.getPrivate());
        kaB.doPhase(a.getPublic(), true);
        byte[] secretB = kaB.generateSecret();

        System.out.println("Shared secret equal: " +
                Arrays.equals(secretA, secretB));
    }
}