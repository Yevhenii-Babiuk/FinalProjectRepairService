package DAO;

import Model.Role;
import Model.User;

public interface DAOUser extends DAO<User,Integer>{
    public User getEntityBySurame(String surname);
    public User getEntityByRole(Role role);
    public User getEntityByLogin(String login);

}
