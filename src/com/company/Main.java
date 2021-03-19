package com.company;

import com.company.repository.IRepository;
import com.company.repository.Repository;

import java.util.Scanner;

public class Main {
    public static IRepository repository = new Repository();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        User currentUser = repository.GetUser(login);

        String password;
        do {
            System.out.println("Введите пароль");
            password = scanner.nextLine();
        }
        while (!currentUser.checkPassword(password));

        System.out.println("Авторизация прошла успешно");
    }
}
