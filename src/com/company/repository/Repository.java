package com.company.repository;

import com.google.gson.*;
import com.company.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Repository implements IRepository {

    @Override
    public ArrayList<User> GetAllUser() {
        JsonArray jsonUsers = new JsonArray();
        ArrayList<User> users = new ArrayList<>();
        try {
            jsonUsers = getUsersJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (JsonElement jsonUser : jsonUsers)
            users.add(new User(
                    jsonUser.getAsJsonObject().get("login").getAsString(),
                    jsonUser.getAsJsonObject().get("password").getAsString()
            ));
        return users;
    }

    @Override
    public User GetUser(String login) {
        JsonArray jsonUsers = new JsonArray();
        try {
            jsonUsers = getUsersJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (JsonElement jsonUser : jsonUsers)
        {
            JsonObject userObj = jsonUser.getAsJsonObject();
            if(userObj.get("login").getAsString().equals(login))
                return new User(
                        userObj.get("login").getAsString(),
                        userObj.get("password").getAsString()
                    );
        }
        return null;
    }

    @Override
    public User CreateUser(String login, String password) {
        return null;
    }

    @Override
    public User ChangePassword(String login, String password) {
        return null;
    }

    private JsonArray getUsersJson() throws IOException {
        JsonArray users = new JsonArray();
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/com/company/repository/Users.json"));

            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            users = parser.get("users").getAsJsonArray();

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
