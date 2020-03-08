package com.example.codepolyglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class LanguageTools {

    public static HashMap<String, String> languageToExtension= new HashMap<String, String>(){{
            put("ActionScript",".as");
            put("Ada", ".adb");
            put("AmbientTalk",".at");
            put("Assembly", ".asm");
            put("B", ".b");
            put("Bash",".sh");
            put("C", ".c");
            put("C++", ".cpp");
            put("Clojure", ".clj");
            put("COBOL", ".cbl");
            put("CoffeeScript", ".coffee");
            put("Eiffel", ".e");
            put("Elixir", ".ex");
            put("Erlang", ".erl");
            put("F#", ".fs");
            put("Fortran", ".f");
            put("Go", ".go");
            put("Groovy", ".groovy");
            put("Haskell", ".hs");
            put("Java", ".java");
            put("JavaScript", ".js");
            put("Kotlin", ".kt");
            put("Common Lisp", ".lisp");
            put("Lua", ".lua");
            put("Objective-C", ".m");
            put("Pascal", ".pas");
            put("Perl", ".pl");
            put("PHP", ".php");
            put("PowerShell", ".ps1");
            put("Prolog", ".pl");
            put("Python", ".py");
            put("Ruby", ".rb");
            put("Scala", ".scala");
            put("SQL", ".sql");
            put("Swift", ".swift");
            put("TypeScript", ".ts");
            put("VisualBasic", ".vb");
            put("WebAssembly", ".wasm");
    }};

    public static String[] languages= languageToExtension.keySet().toArray(new String[languageToExtension.size()]);

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
