package org.example.Task3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class TodosParser {
    public void CompletedFalse(int userId) throws IOException, InterruptedException {

        String url = "https://jsonplaceholder.typicode.com/users/" + userId + "/todos";

        String response = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .get()
                .body()
                .text();

        Type typeToken = TypeToken
                .getParameterized(List.class, TodosItem.class)
                .getType();

        List<TodosItem> todosItems = new Gson().fromJson(response, typeToken);

        List<TodosItem> todosItemsFalse =
         todosItems.stream()
                 .filter(node -> node.getCompleted().equals("false"))
                 .toList();

         for(TodosItem todosItem:todosItemsFalse) {

               GsonBuilder builder = new GsonBuilder();
               builder.setPrettyPrinting();
               Gson gson = builder.create();

               String jsonString = gson.toJson(todosItem);
               System.out.println(jsonString);

        }
    }
}
