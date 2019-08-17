package service;

import dao.UserDAOImplement;
import model.User;
import org.json.JSONObject;

public class EditUser {
    public void editUser(String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        String surname = object.getString("surname");
        String phone = object.getString("phone");
        String address = object.getString("address");
        String login = object.getString("login");
        String password = null;
        try {
            password = object.getString("password");
        } catch (org.json.JSONException e) {
            password = null;
        }

        String role = object.getString("role");
        User user = new UserDAOImplement().getEntityByLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        if (password != null) {
            user.setPassword(password);
        }
        user.setAddress(address);
        user.setLogin(login);
        if (role != null) {
            user.setRole(role);
        }
        new UserDAOImplement().update(user);
    }
}
