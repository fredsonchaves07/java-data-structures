package com.fredson.datastructures.algorithms;

import com.fredson.algorithms.Palindrome;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
