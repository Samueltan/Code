package com.tutorialspoint.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.soap.Text;

public class TextEditor {
    @Autowired
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
//        System.out.println("Inside TextEditor constructor.");
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}