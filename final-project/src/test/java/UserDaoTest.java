import com.ragheb.config.DBTestConfig;
import com.ragheb.dao.impl.DaoFactory;
import com.ragheb.dao.impl.UserDao;
import com.ragheb.domain.User;
import com.ragheb.enums.UserRole;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDaoTest {
    private final DBTestConfig testConfig = new DBTestConfig();
    private final DaoFactory daoFactory = DaoFactory.INSTANCE;
    private UserDao userDao;
    private Connection connection;

    /**
     * This method will run before each single test in the class
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        connection = testConfig.getConnection();
        daoFactory.setConnection(connection);
        userDao = daoFactory.getUserDao();
    }

    /**
     * This method will run after each single test in the class
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        connection = null;
        userDao = null;
    }

    @Test
    public void testInsertItem() throws Exception {
        User newUser = new User("caveline0", "jgoodday0@ddoidid.com", "mpally0", "49340 Summit Trail", false,
                UserRole.USER);
        userDao.insertItem(newUser);

        List<User> users = userDao.getAllItems();
        int actualUsersSize = users.size();
        int expectedUsersSize = 101;

        assertEquals(expectedUsersSize, actualUsersSize);
    }

    @Test
    public void testGetAllItems() throws Exception {
        List<User> users = userDao.getAllItems();
        int actualUsersSize = users.size();
        int expectedUsersSize = 100;

        assertEquals(expectedUsersSize, actualUsersSize);
    }

    @Test
    public void testGetItemById() throws Exception {
        User expectedUser = new User(1, "caveline0", "mpally0", "jgoodday0@cnet.com", "49340 Summit Trail", false,
                UserRole.USER);
        User actualUser = userDao.getItemById(1);

        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testUpdateItem() throws Exception {
        User expectedUser = new User(1, "caveline0", "updated@cnet.com", "mpally0", "49340 Summit Trail", true,
                UserRole.USER);

        int actualUpdateStatus = userDao.updateItem(expectedUser);
        int expectedUpdateStatus = 1;

        assertEquals(expectedUpdateStatus, actualUpdateStatus);
    }

    @Test
    public void testDeleteItem() throws Exception {

        // creating a new user and then deleted to avoid deleting a user which his id
        // used as foreign key in another table
        User newUser = new User("caveline0", "jgoodday0@ddoidid.com", "mpally0", "49340 Summit Trail", false,
                UserRole.USER);

        userDao.insertItem(newUser);

        int actualDeleteStatus = userDao.deleteItem(101);
        int expectedDeleteStatus = 1;

        List<User> users = userDao.getAllItems();
        int actualUsersSize = users.size();
        int expectedUsersSize = 100;

        assertEquals(expectedUsersSize, actualUsersSize);
        assertEquals(expectedDeleteStatus, actualDeleteStatus);
    }
}
