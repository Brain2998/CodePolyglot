package com.example.codepolyglot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GithubTools {

    private static String apiURL="https://api.github.com";

    private static ObjectMapper mapper = new ObjectMapper();

    private static String getRandomID(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 100000000));
    }

    public static JsonNode getRandomRepo() throws IOException {
        URL url=new URL(apiURL+"/repositories?since="+getRandomID());
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        JsonNode response = mapper.readTree(conn.getInputStream());
        return response;
    }

    public static String getRepoLanguage(String languageUrl) throws IOException{
        URL url=new URL(languageUrl);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        JsonNode response = mapper.readTree(conn.getInputStream());
        return response.fieldNames().next();
    }

    public static String getFileByLanguage(String contentUrl, String language) throws IOException {
        String fileExtension = LanguageTools.languageToExtension.get(language);
        //get list of files in repository
        URL url=new URL(contentUrl);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        JsonNode response = mapper.readTree(conn.getInputStream());

        HashMap<String, String> pathToFiles=new HashMap<String, String>();
        for (JsonNode node: response) {
            pathToFiles.put(node.get("name").textValue(), node.get("path").textValue());
        }

        AtomicReference<String> filePath=new AtomicReference<>();
        pathToFiles.forEach((file, path) -> {
            if (file.endsWith(fileExtension))
               filePath.set(path);
        });
        return filePath.get();
    }

}
