package encryptdecrypt.crypting;

import encryptdecrypt.Algorithm;
import encryptdecrypt.Mode;

public class CryptionStore extends CryptionFactory {
    @Override
    Cryption createCryption(Algorithm algorithm, Mode mode, int key) {

        switch (algorithm) {
            case SHIFT:
                return new ShiftCryption(mode, key);
            case UNICODE:
                return new UnicodeCryption(mode, key);
            default:
                return null;
        }
    }
}