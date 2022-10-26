package com.fredson.applications.caesarCipher;

import java.text.Normalizer;

public class CaesarCipher {

    private static final char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
    'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final int ALPHABETSIZE = ALPHABET.length;

    private static final int ROTATION = 4;

    private static final char[] ENCRYPT = new char[ALPHABETSIZE];

    private static final char[] DECRYPT = new char[ALPHABETSIZE];

    public static String encrypt(String message) {
        setRotationEncryptAndDecrypt();
        char[] messageEncrypted = removeStringAccent(message).toUpperCase().toCharArray();
        for (int i = 0; i < messageEncrypted.length; i ++) {
            if (messageEncrypted[i] == ' ' ) continue;
            messageEncrypted[i] = ENCRYPT[messageEncrypted[i] - 'A'];
        }
        return new String(messageEncrypted);
    }

    public static String decrypt(String message) {
        setRotationEncryptAndDecrypt();
        char[] messageDecrypted = message.toUpperCase().toCharArray();
        for (int i = 0; i < messageDecrypted.length; i ++) {
            if (messageDecrypted[i] == ' ' ) continue;
            messageDecrypted[i] = DECRYPT[messageDecrypted[i] - 'A'];
        }
        return new String(messageDecrypted);
    }

    private static void setRotationEncryptAndDecrypt() {
        for (int i = 0; i < ALPHABETSIZE; i ++) ENCRYPT[i] = ALPHABET[(i + ROTATION) % ALPHABETSIZE];
        for (int i = 0; i < ALPHABETSIZE; i ++) DECRYPT[ENCRYPT[i] - 'A'] = ALPHABET[i];
    }

    private static String removeStringAccent(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
