package app.service;

import app.model.Users;

import java.util.List;

public interface UsersService {

    void add (Users user);
    void delete (Users user);
    List<Users> getAllUsers();
    void update (Users user);
    Users showUser(int id);

}
