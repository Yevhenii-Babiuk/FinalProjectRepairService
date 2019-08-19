package service;

import dao.*;
import model.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EditUserTest {
    private static UserDAOImplement userDao = new UserDAOImplement();
    private  static User user= null;
    @BeforeClass
    public static void addAllEntityForOrder(){
        user = new User();
        user.setId(3000);
        user.setRole(Role.CLIENT);
        user.setLogin("test_user@test.com");
        user.setAddress("Repair service address");
        user.setPhone("+380000000001");
        user.setSurname("Test1");
        user.setName("Test1");
        user.setPassword("00000000");
        userDao.add(user);

    }

    @AfterClass
    public static void deleteAllEntity(){
        User user = new User();
        user.setId(3000);
        userDao.delete(user);
    }

    @Test
    public void editUser() {
        EditUser editUser = new EditUser();
        String json = "{\"name\":\"Test2\",\"surname\":\"Test2\",\"phone\":\"+380000000001\",\"address\":\"Repair service address\",\"login\":\"test_user@test.com\",\"password\":\"78746546\",\"role\":\"client\"}";
        editUser.editUser(json);
        assertNotEquals(user, userDao.getEntityByLogin("test_user@test.com"));
    }
}