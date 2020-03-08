package com.example.codepolyglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class LanguageTools {
    public static String[] languages = {
            "1C",
            "A",
            "ActionScript",
            "Ada",
            "AmbientTalk",
            "Assembly",
            "B",
            "Bash",
            "BASIC",
            "C",
            "C++",
            "COBOL",
            "CoffeeScript",
            "Eiffel",
            "Elixir",
            "Erlang",
            "F",
            "F#",
            "Fortran",
            "Go",
            "Groovy",
            "Haskell",
            "Java",
            "JavaScript",
            "Kotlin",
            "LINQ",
            "Lisp",
            "Lua",
            "MATLAB",
            "Objective-C",
            "Pascal",
            "Perl",
            "PHP",
            "PowerShell",
            "Prolog",
            "Python",
            "Ruby",
            "Rust",
            "Scala",
            "Smalltalk",
            "SQL",
            "Swift",
            "TypeScript",
            "VHDL",
            "Visual Basic",
            "WebAssembly"
    };

    public static ArrayList fillRandomLanguages(String initalLanguage){
        ArrayList randomLanguages=new ArrayList<String>();
        randomLanguages.add(initalLanguage);
        while(randomLanguages.size()<4){
            String language=languages[ThreadLocalRandom.current().nextInt(1, languages.length)];
            if (!randomLanguages.contains(language)) {
                randomLanguages.add(language);
            }
        }
        Collections.shuffle(randomLanguages);
        return randomLanguages;
    }
}
