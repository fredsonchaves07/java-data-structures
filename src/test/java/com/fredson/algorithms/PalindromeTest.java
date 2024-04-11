package com.fredson.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {

    @Test
    public void shouldStringIsPalindrome() {
        assertTrue(Palindrome.isPalindrome("Ana"));
        assertTrue(Palindrome.isPalindrome("A babá baba"));
        assertTrue(Palindrome.isPalindrome("Socorram me subi no onibus em Marrocos"));
    }

    @Test
    public void shouldStringNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("Jhon"));
        assertFalse(Palindrome.isPalindrome("O cachorro late"));
    }
}
