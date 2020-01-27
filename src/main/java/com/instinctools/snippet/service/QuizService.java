package com.instinctools.snippet.service;

import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public String getToken() {
        return String.valueOf(getStartByte() + getKeyLength());
    }


    /** The getStartByte method should return the largest three-digit value from the numbers.txt file. */
    public int getStartByte() {
        return -1;
    }

    /** The getKeyLength method should return the number of words starting with vowel in all interrogative sentences from the text.txt file. */
    public int getKeyLength() {
        return -1;
    }
}
