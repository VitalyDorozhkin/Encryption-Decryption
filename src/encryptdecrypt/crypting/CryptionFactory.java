package encryptdecrypt.crypting;

import encryptdecrypt.Algorithm;
import encryptdecrypt.Mode;

public abstract class  CryptionFactory {

    abstract Cryption createCryption(Algorithm algorithm, Mode mode, int key);

    public Cryption chooseCryption(Algorithm algorithm, Mode mode, int key){
        Cryption cryption = createCryption(algorithm, mode, key);
        if (cryption == null) {
            System.out.println("Sorry, we are not able to create this kind of cryption\n");
            return null;
        }
        return cryption;
    }
}
