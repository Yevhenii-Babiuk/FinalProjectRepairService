package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddUserTest {

    @Test
    public void addUserToDatabase() {
        AddUser addUser = new AddUser();
        String json = "{\"name\":\"Роман\",\"surname\":\"Мінський\",\"phone\":\"+380980000305\",\"address\":\"Obolon, Marshala Tymoshenka 2z\",\"login\":\"minsk@gmail.com\",\"password\":\"789456123\",\"role\":null}";
        boolean isExist = addUser.addUserToDatabase(json);
        assertTrue(isExist);
    }
}