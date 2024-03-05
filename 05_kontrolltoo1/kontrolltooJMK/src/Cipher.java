public class Cipher {
    String message;
    int offset;

    public Cipher(String message, int offset) {
        this.message = message;
        this.offset = offset;
    }

    public static String encrypt(String message, int offset){
        StringBuilder ciphertext = new StringBuilder();
        offset = offset % 26; //see tagab ,et saad kasutada suuremaid offsette kui 26
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            //Võtab iga tähe tekstist ja ja muudab selle väärtust offseti järgi
            if (Character.isLetter(ch)) {
                char shiftedChar = (char) (ch + offset);
                if (Character.isLowerCase(ch)) {
                    if (shiftedChar < 'a') {
                        shiftedChar = (char) (shiftedChar + 26); // Viib tähestiku lõppu kui väärtus ei mahu tähestikku
                    } else if (shiftedChar > 'z') {
                        shiftedChar = (char) (shiftedChar - 26); // Viib tähestiku algusesse kui väärtus ei mahu tähestikku
                    }
                } else if (Character.isUpperCase(ch)) {
                    if (shiftedChar < 'A') {
                        shiftedChar = (char) (shiftedChar + 26); // Viib tähestiku lõppu kui väärtus ei mahu tähestikku
                    } else if (shiftedChar > 'Z') {
                        shiftedChar = (char) (shiftedChar - 26); // Viib tähestiku algusesse kui väärtus ei mahu tähestikku
                    }
                }
                ciphertext.append(shiftedChar);
            } else { //kui ei ole täht siis lykkab char nii nagu on
                ciphertext.append(ch);
            }
        }
        return ciphertext.toString();
    }
    //Dekrüpteerib igat tähte ükshaaval nö. lahutades tähtedest offseti (nii nagu varem liitsime(char kood))
    public static String decrypt(String ciphertext, int offset) {
        return encrypt(ciphertext, -offset);
    }
}
//(Töötas ainult offsettiga, mis on 1)
//            Võtab iga tähe tekstist ja ja muudab selle väärtust offseti järgi
//            if (Character.isLetter(ch)) {
//                char shiftedChar = (char) (ch + offset);
//                //see on selleks, et kui tähestikust läheb üle see algaks tähestiku algusest
//                if ((Character.isLowerCase(ch) && shiftedChar > 'z') || (Character.isUpperCase(ch) && shiftedChar > 'Z')) {
//                    shiftedChar = (char) (ch - (26 - offset));
//                }
//                ciphertext.append(shiftedChar);
//            } else { //kui ei ole täht siis lykkab char nii nagu on
//                ciphertext.append(ch);
//            }
