package security.asymmetric;

import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class ECDHEncDec {
    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
        kpg.initialize(256);

        KeyPair alice = kpg.generateKeyPair();
        KeyPair bob = kpg.generateKeyPair();

        KeyAgreement kaAlice = KeyAgreement.getInstance("ECDH");
        kaAlice.init(alice.getPrivate());
        kaAlice.doPhase(bob.getPublic(), true);
        byte[] secretAlice = kaAlice.generateSecret();

        KeyAgreement kaBob = KeyAgreement.getInstance("ECDH");
        kaBob.init(bob.getPrivate());
        kaBob.doPhase(alice.getPublic(), true);
        byte[] secretBob = kaBob.generateSecret();

        System.out.println("Shared secret equal: " +
                Arrays.equals(secretAlice, secretBob));
    }
}
