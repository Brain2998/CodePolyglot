package com.example.codepolyglot;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GithubToolsTest {
    @Test
    public void randomRepository() throws IOException {
        JsonNode rep1=GithubTools.getRandomRepo();
        JsonNode rep2=GithubTools.getRandomRepo();
        assertNotEquals(rep1, rep2);
    }
    @Test
    public void repoLanguage() throws  IOException{
        String language=GithubTools.getRepoLanguage("https://api.github.com/repos/Tyler-Anderson/quad-tree/languages");
        assertEquals(language, "CoffeeScript");
    }
    @Test
    public void fileLanguage() throws IOException {
        String file=GithubTools.getFileByLanguage("https://api.github.com/repos/joecridge/binsync/contents/", "Bash");
        assertEquals(file, "binsync.sh");
    }
    @Test
    public void fileContent() throws IOException {
        String content=GithubTools.getFileContent("https://api.github.com/repos/joecridge/binsync/contents/binsync.sh");
        assertTrue(content.startsWith("#!/usr/bin/env"));
    }
}
