import DAO.UserDAOImplement;
import Model.User;


public class Domain {
    public static void main(String[] args) {
        UserDAOImplement userDao =new UserDAOImplement();

        User user1 =userDao.getEntityByKey(3);
        user1.setName("Vitalii");
        user1.setAddress("Kiyv, Nizhinska 29 street");
        user1.setSurname("Chmoryk");
        user1.setPhone("+380935467890");
        user1.setLogin("vitalia_ch");
        user1.setPassword("88888888");
        user1.setRole("client");
        userDao.update(user1);

        System.out.println(userDao.getAll());
    }
}
