package org.example;

import org.example.Task1.HttpUtils;
import org.example.Task2.ArticleParser;
import org.example.Task3.TodosParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpUtils httpUtils = new HttpUtils();

        System.out.println("-----------");
        System.out.println("----------- Task1");
       // 1.1
        String userNew = httpUtils.createNewUser();
        System.out.println("------ New user = " + userNew);

        // 1.2
        String userUpdate = httpUtils.updateUser(10);
        System.out.println("------ Update user = " + userUpdate);

        // 1.3
        System.out.println("------ Delete user.id = 10, status = " + httpUtils.deleteUser(11));

        // 1.4
        String userAll = httpUtils.getAllUser();
        System.out.println("------ UserAll = " + userAll);

        // 1.5
        String user = httpUtils.getUser(10);
        System.out.println("------ UserId = 3: " + user);

        // 1.6
        String userName = httpUtils.getUserName("Moriah.Stanton");
        System.out.println("------ UserName = Moriah.Stanton: " + userName);

        System.out.println("-----------");
        System.out.println("----------- Task2");
        // 2
        ArticleParser articleParser = new ArticleParser();
        System.out.println("UserId = 2: ");
        articleParser.PostsComments(2);

        System.out.println("-----------");
        System.out.println("----------- Task3");
        // 3
        TodosParser todosParser = new TodosParser();
        System.out.println("UserId = 2: ");
        todosParser.CompletedFalse(2);

    }

}