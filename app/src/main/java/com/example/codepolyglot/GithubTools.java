package com.example.codepolyglot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GithubTools {

    private static String apiURL="https://api.github.com";

    private static String getRandomID(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 100000000));
    }

    public static JsonNode getRandomRepo() throws IOException {
        URL url=new URL(apiURL+"/repositories?since="+getRandomID());
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(conn.getInputStream());
        return response;
    }

    public static String getRepoLanguage(String repoLanguageUrl) throws IOException{
        URL url=new URL(repoLanguageUrl);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(conn.getInputStream());
        return response.fieldNames().next();
    }

}
