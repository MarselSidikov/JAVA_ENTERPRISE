import ru.kpfu.itis.models.User;
import org.junit.*;
import ru.kpfu.itis.repository.UserDao;
import ru.kpfu.itis.repository.UserDaoImpl;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 27.10.2017
 *
 * @author Kuznetsov Maxim
 * @version v1.0
 */
public class UserDaoImplTest {
    private static UserDao userDao;

    @BeforeClass
    public static void before() throws Exception {
        userDao = new UserDaoImpl();
    }

    @AfterClass
    public static void after() throws Exception {
        User userSave = userDao.findByLogin("Save_test");
        if (userSave != null) {
            userDao.delete(userSave);
        }
        User userUpd = userDao.findByLogin("Update_test");
        if (userUpd != null) {
            userDao.delete(userUpd);
        }

    }

    @Test
    public void findByLogin() throws Exception {
        User user = userDao.findByLogin("the#_freak");
        assertNotNull(user);
        assertNotNull(user.getId());
        assertTrue(user.getId().equals(1L));
    }

    @Test
    public void save() throws Exception {
        User user = User.builder()
                .name("Test")
                .gender(true)
                .login("Save_test")
                .password("qwerty123")
                .build();
        userDao.save(user);
        assertNotNull(user);
        assertNotNull(user.getId());
    }

    @Test
    public void find() throws Exception {
        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getLogin());
        assertTrue(user.getLogin().equals("the#_freak"));
    }

    @Test
    public void findAll() throws Exception {
        List<User> users = userDao.findAll();
        assertNotNull(users);
        assertTrue(users.size() > 0);
        assertNotNull(users.get(0));
    }

    @Test
    public void update() throws Exception {
        User user = User.builder()
                .name("Test")
                .gender(true)
                .login("Update_test")
                .password("qwerty")
                .build();
        userDao.save(user);
        user.setGender(false);
        userDao.update(user);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(false, user.getGender());
    }

    @Test
    public void delete() throws Exception {
        User user = User.builder()
                .name("Test")
                .gender(true)
                .login("Delete_test")
                .password("qwerty321")
                .build();
        userDao.save(user);
        userDao.delete(user);
        User deletedUser = userDao.findByLogin("Delete_test");
        assertNull(deletedUser);
    }
}