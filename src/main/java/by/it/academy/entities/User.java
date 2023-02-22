package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String surname;
    private int age;
    private String login;
    private String password;
    private UserType userType;

    public User (String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User (String login, String password){
        this.login = login;
        this.password = password;
    }

}
