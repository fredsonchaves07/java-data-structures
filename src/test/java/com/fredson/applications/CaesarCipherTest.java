package com.fredson.applications;

import com.fredson.applications.caesarCipher.CaesarCipher;
import org.junit.Test;

public class CaesarCipherTest {

    @Test
    public void shouldEncryptMessage() {
        String message = "Java e uma linguagem de programacao";
        String messageEncrypted = CaesarCipher.encrypt(message);
        System.out.println(messageEncrypted);
    }
}
