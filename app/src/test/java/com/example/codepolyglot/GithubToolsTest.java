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
}