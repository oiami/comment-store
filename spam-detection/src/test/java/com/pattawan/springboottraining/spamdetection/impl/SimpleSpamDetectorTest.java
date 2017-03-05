package com.pattawan.springboottraining.spamdetection.impl;

import com.pattawan.springboottraining.spamdetection.SpamDetector;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class SimpleSpamDetectorTest {

    @Test
    public void testSpamTrue() throws Exception {
        SpamDetector spamDetector = new SimpleSpamDetector("src/test/resources/words.spam");

        assertTrue(spamDetector.containsSpam("I LOVE VIAGRA"));
        assertTrue(spamDetector.containsSpam("Horst Fuck"));
        assertTrue(spamDetector.containsSpam("Hort@horst-porn.com"));
    }

    @Test
    public void testSpamFalse() throws Exception {
        SpamDetector spamDetector = new SimpleSpamDetector("src/test/resources/words.spam");

        assertFalse(spamDetector.containsSpam("I LOVE Dogs"));
        assertFalse(spamDetector.containsSpam("I LOVE Robots"));
        assertFalse(spamDetector.containsSpam("I LOVE Cats"));
    }
}