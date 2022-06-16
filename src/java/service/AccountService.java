/**
 * This class authenticate the user with their username and password;
 * Returns a user object if authentication is successful
 * For now, Abe and Barb are the only 2 hard-coded users
 */
package service;

import Models.User;

public class AccountService {

    public User login(String username, String password) {
        if ((username.equals("abe") || username.equals("barb")) && password.equals("password")) {
            return new User(username, null);
        }
        return null;
    }
}