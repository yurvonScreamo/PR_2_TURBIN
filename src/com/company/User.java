package com.company;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

public class User {
    private final String login;
    private final String password;

    public User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }
    public String getLogin()
    {
        return login;
    }
    public boolean checkPassword(@NotNull String password)
    {
        return password.equals(this.password);
    }
}
