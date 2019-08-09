package service;

import dao.UserDAOImplement;
import model.Role;
import model.User;
import com.google.gson.Gson;

public class AddUser {

    public boolean addUserToDatabase(String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);

        UserDAOImplement userDao = new UserDAOImplement();
        if (userDao.getEntityByLogin(user.getLogin()) != null) {
            return false;
        } else {
            if (user.getRole() == null) {
                user.setRole(Role.CLIENT);
            }
            userDao.add(user);
            return true;
        }
    }

}
