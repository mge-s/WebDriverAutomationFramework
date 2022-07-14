package service;

import model.User;

public class UserCreator {
    public static final String USER_NAME = "user.name";
    public static final String USER_PASSWORD = "user.password";

    public static User getUser() {
        return new User(TestDataReader.getTestData(USER_NAME), TestDataReader.getTestData(USER_PASSWORD));
    }

}
