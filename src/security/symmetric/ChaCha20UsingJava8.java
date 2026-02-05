package security.symmetric;

import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

import java.security.SecureRandom;

public class ChaCha20UsingJava8 {
        public static void main(String[] args) {

            byte[] key = new byte[32];   // 256-bit key
            byte[] nonce = new byte[8];  // 64-bit nonce (BC default)

            SecureRandom random = new SecureRandom();
            random.nextBytes(key);
            random.nextBytes(nonce);

            ChaChaEngine engine = new ChaChaEngine(20);
            engine.init(true, new ParametersWithIV(new KeyParameter(key), nonce));

            byte[] plaintext = "Hello ChaCha20".getBytes();
            byte[] ciphertext = new byte[plaintext.length];

            engine.processBytes(plaintext, 0, plaintext.length, ciphertext, 0);

            // Decrypt (same operation)
            ChaChaEngine decryptEngine = new ChaChaEngine(20);
            decryptEngine.init(false, new ParametersWithIV(new KeyParameter(key), nonce));

            byte[] decrypted = new byte[ciphertext.length];
            decryptEngine.processBytes(ciphertext, 0, ciphertext.length, decrypted, 0);

            System.out.println(new String(decrypted));
        }
    }