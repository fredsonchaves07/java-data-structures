package com.fredson.applications;

import com.fredson.applications.caesarCipher.CaesarCipher;
import org.junit.Test;

public class CaesarCipherTest {

    @Test
    public void shouldGetEncryptMessage() {
        String message = "Java � uma linguagem de programa��o";
        String messageEncrypted = CaesarCipher.encrypt(message);
        System.out.println(messageEncrypted);
    }

    @Test
    public void shouldGetDecryptedMessage() {
        String message = "NEZE I YQE PMRKYEKIQ HI TVSKVEQEGES";
        String decruptedMessage = CaesarCipher.decrypt(message);
        System.out.println(decruptedMessage);
    }
}
