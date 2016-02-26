package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;

import bean.User;
import dao.UserDao;

public class DBTest {
	static Logger logger = Logger.getLogger(DBTest.class);

	@Test
	public void insertTest() {
		UserDao dao = new UserDao();
		dao.user_deleteAll();
		User user = new User("lus", "pass", "name");
		dao.user_insert(user);
		assertThat(user.getUseremail(), is("lus"));
	}
}