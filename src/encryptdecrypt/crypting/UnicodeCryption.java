package encryptdecrypt.crypting;

import encryptdecrypt.Mode;

public class UnicodeCryption extends Cryption {

    UnicodeCryption(Mode mode, int key) {
        this.key = key;
        if(mode == Mode.DEC)
            this.key *= -1;
    }

    @Override
    public String getCrypted(String str) {
        char[] res = new char[str.length()];
        int i = 0;
        while(i < str.length()){
            res[i] = getShiftUnicodeNChar(str.charAt(i));
            i++;
        }
        return new String(res);
    }

    private char getShiftUnicodeNChar(char c)
    {
        return (char)(c + this.key);
    }
}
