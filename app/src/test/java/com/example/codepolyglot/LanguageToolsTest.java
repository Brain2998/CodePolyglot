package com.example.codepolyglot;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LanguageToolsTest {
    @Test
    public void fillRandomLanguages(){
        ArrayList<String> list1=LanguageTools.fillRandomLanguages("Java");
        ArrayList<String> list2=LanguageTools.fillRandomLanguages("Java");
        assertNotEquals(list1, list2);
    }
}
