package com.tutorialspoint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.xml.soap.Text;

@Controller
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