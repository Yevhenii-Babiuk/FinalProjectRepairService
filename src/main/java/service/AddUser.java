package service;

import dao.EmployeeDAOImplement;
import dao.UserDAOImplement;
import model.Employee;
import model.Role;
import model.User;
import com.google.gson.Gson;
import org.json.JSONObject;

import java.sql.Date;
import java.util.Calendar;

/**
 * Realizing adding new user to DB
 */
public class AddUser {

    public boolean addUserToDatabase(String json) {
        JSONObject object = new JSONObject(json);
        String name = object.getString("name");
        String surname = object.getString("surname");
        String phone = "+"+object.getString("phone");
        String address = object.getString("address");
        String login = object.getString("login");
        String password = object.getString("password");
        String role = object.get("role").toString();
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setPassword(password);
        user.setAddress(address);
        user.setLogin(login);
        user.setRole(role);

        UserDAOImplement userDao = new UserDAOImplement();
        if (userDao.getEntityByLogin(user.getLogin()) != null) {
            return false;
        } else if (user.getRole() == null || user.getRole().equals(Role.CLIENT)) {
            user.setRole(Role.CLIENT);
            userDao.add(user);
            return true;
        } else {
            userDao.add(user);
            Employee employee = new Employee();
            int id = userDao.getEntityByLogin(user.getLogin()).getId();
            EmployeeDAOImplement employeeDao = new EmployeeDAOImplement();
            employee.setUserId(id);
            employee.setStartDate( new Date(Calendar.getInstance().getTime().getTime()));
            employeeDao.add(employee);
            return true;
        }
    }
}
