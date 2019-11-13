package encryptdecrypt;

import encryptdecrypt.crypting.*;

public class EncryptionDecryption {

    public static void main(String[] args) {
        Params params = new Params(Mode.ENC, Algorithm.SHIFT, 0, "", args);

        CryptionFactory factory = new CryptionStore();
        Cryption cryption = factory.chooseCryption(params.getAlgorithm(), params.getMode(), params.getKey());
        String cryptedResult = cryption.getCrypted(params.getData());

        if(params.getOut() == null || !params.writeToFile(cryptedResult)) {
            System.out.println(cryptedResult);
        }
    }

}
