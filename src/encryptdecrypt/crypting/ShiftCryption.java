package encryptdecrypt.crypting;

import encryptdecrypt.Mode;

public class           ShiftCryption extends Cryption {

    ShiftCryption(Mode mode, int key) {
        this.key = key;
        if(mode == Mode.DEC)
            this.key *= -1;
    }

    @Override
    public String getCrypted(String str) {
        char[] res = new char[str.length()];
        int i = 0;
        while(i < str.length()){
            res[i] = getShiftNChar(str.charAt(i));
            i++;
        }
        return new String(res);
    }

    private char getShiftNChar(char c)
    {
        char a = Character.isLowerCase(c) ? 'a' : 'A';
        if(!Character.isLetter(c)) {
            return c;
        }
        int d = (c - a + this.key) % 26;
        if(d < 0)
            d+=26;

        return (char)(a + d);
    }
}
