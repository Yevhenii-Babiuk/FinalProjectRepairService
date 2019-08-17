package dao;

import model.Role;
import model.User;

import java.util.List;

public interface DAOUser extends DAO<User,Integer> {
    public User getEntityBySurname(String surname);
    public List<User> getEntityByRole(Role role);
    public User getEntityByLogin(String login);

}
