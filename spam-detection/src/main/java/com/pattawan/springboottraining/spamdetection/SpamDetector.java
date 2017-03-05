package com.pattawan.springboottraining.spamdetection;

/**
 * Interface for detecting spam comment
 */
public interface SpamDetector {

    boolean containsSpam(String value);

}
