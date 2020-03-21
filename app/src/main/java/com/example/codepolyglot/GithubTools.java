package com.example.codepolyglot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;

public class GithubTools {

    private static String apiURL="https://api.github.com";


    private static String getRandomID(){
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 100000000));
    }

    private static JsonNode jsonFromGet(String inputUrl) throws IOException{
        URL url=new URL(inputUrl);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.getResponseCode();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(conn.getInputStream());
        return  response;
    }

    public static JsonNode getRandomRepo() throws IOException {
        return jsonFromGet(apiURL+"/repositories?since="+getRandomID());
    }

    public static String getRepoLanguage(String languageUrl) throws IOException{
        return jsonFromGet(languageUrl).fieldNames().next();
    }

    public static String getFileByLanguage(String repoContentUrl, String language) throws IOException {
        String fileExtension = LanguageTools.languageToExtension.get(language);
        //get list of files in repository
        JsonNode response=jsonFromGet(repoContentUrl);

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

    public static String getFileContent(String fileUrl) throws IOException {
        JsonNode response = jsonFromGet((fileUrl));
        String encodedContent=response.get("content").asText().replace("\n", "");
        String decodedContent=new String(Base64.getDecoder().decode(encodedContent));
        return decodedContent;
    }
}
