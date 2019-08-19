package dao;

import model.Role;
import model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDAOImplementTest {
    private UserDAOImplement userDao = new UserDAOImplement();
    private User user = new User();

    @Before
    public void setUserBeforeEachTest(){
        UserDAOImplement userDao = new UserDAOImplement();
        user.setId(3000);
        user.setRole(Role.ADMIN);
        user.setLogin("test_user@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000000");
        user.setSurname("Test");
        user.setName("Test");
        user.setPassword("00000000");
        userDao.add(user);
    }

    @After
    public void deleteBeforeNextTest() {
        user.setId(3000);
        userDao.delete(user);
    }

    @Test
    public void getAll() {
        List<User> users = userDao.getAll();
        assertEquals(user, users.get(users.size()-1));
    }

    @Test
    public void add() {
        userDao.delete(user);
        user.setId(3000);
        user.setRole(Role.ADMIN);
        user.setLogin("test_user@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380111111111");
        user.setSurname("Test");
        user.setName("Test");
        user.setPassword("88888888");
        userDao.add(user);
        assertEquals(user, userDao.getEntityByKey(3000));
    }

    @Test
    public void update() {
        user.setRole(Role.MASTER);
        userDao.update(user);
        assertEquals(user, userDao.getEntityByKey(3000));
    }

    @Test
    public void delete() {
        userDao.delete(user);
        assertNull(userDao.getEntityByKey(3000));
    }

    @Test
    public void getEntityByKey() {
        assertEquals(user, userDao.getEntityByKey(3000));
    }

    @Test
    public void getEntityBySurname() {
        assertEquals(user, userDao.getEntityBySurname("Test"));
    }

    @Test
    public void getEntityByRole() {
        List<User> users = userDao.getEntityByRole(Role.ADMIN);
        assertEquals(user, users.get(users.size()-1));
    }

    @Test
    public void getEntityByLogin() {
        assertEquals(user, userDao.getEntityByLogin("test_user@test.com"));
    }
}