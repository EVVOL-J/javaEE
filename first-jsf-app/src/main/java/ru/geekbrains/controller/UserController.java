package ru.geekbrains.controller;

import ru.geekbrains.persist.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserController implements Serializable {

    User user = new User("Вася", "Пупкин", "Pupok@mail.ru", "+7(800)555-35-35");

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String goToUser() {
        return "/user.xhtml?faces-redirect-true";
    }

    public String editUser() {
        return "/user_form.xhtml?faces-redirect-true";
    }
}
