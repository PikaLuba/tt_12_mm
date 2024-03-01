package org.example.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.jsoup.*;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ArticleParser {

    public void PostsComments(int userId) throws IOException, InterruptedException {

    String url = "https://jsonplaceholder.typicode.com/users/" + userId + "/posts";

    String response = Jsoup
            .connect(url)
            .ignoreContentType(true)
            .get()
            .body()
            .text();

    Type typeToken =  TypeToken
            .getParameterized(List.class, PostsItem.class)
            .getType();

        List<PostsItem> postsItems = new Gson().fromJson(response, typeToken);

        Integer postsId = postsItems.stream()
                .map(it -> it.getId())
        .mapToInt(Integer::intValue).max().getAsInt();

        //System.out.println("PostId = " + postsId);

        String url1 = "https://jsonplaceholder.typicode.com/posts/" + postsId + "/comments";
        String response1 = Jsoup
                .connect(url1)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken1 =  TypeToken
                .getParameterized(List.class, CommensItem.class)
                .getType();

        List<CommensItem> commensItems = new Gson().fromJson(response1, typeToken1);

        String path2 = "./files/user-" + userId + "-post-" + postsId + "-comments.json";
        File file2 = new File(path2);

        String fileName = path2;

        Path path = Paths.get(fileName);

        try (Writer writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonElement tree = gson.toJsonTree(commensItems);
            gson.toJson(tree, writer);
            System.out.println(path2 + " - created");
        }
    }
}
