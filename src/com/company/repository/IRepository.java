package com.company.repository;

import com.company.User;
import java.util.List;

public interface IRepository {
    public List<User> GetAllUser();
    public User GetUser(String login);
    public User CreateUser(String login, String password);
    public User ChangePassword(String login, String password);
}

