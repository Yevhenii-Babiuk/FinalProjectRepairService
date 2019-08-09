package dao;

import model.Role;
import model.User;

public interface DAOUser extends DAO<User,Integer> {
    public User getEntityBySurname(String surname);
    public User getEntityByRole(Role role);
    public User getEntityByLogin(String login);

}
