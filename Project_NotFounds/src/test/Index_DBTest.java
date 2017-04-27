package test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;

import bean.Clip;
import dao.ClipDao;

public class Index_DBTest {
	static Logger logger = Logger.getLogger(Index_DBTest.class);
/*
	@Test
	public void SHA() {
		String base = "password123";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < 10; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			// ì¶œë ¥
			System.out.println(hexString.toString());

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	// bcrypt test ...
	@Test
	public void BCrypts() {
		// password sample
		String password = "!@#$password1234";

		// create hash , passwordHashed is 60byte. gensalt default value 10
		String passwordHashed = BCrypt.hashpw(password, BCrypt.gensalt());
		// if password hash value equals passwordHashed true / else false
		boolean isValidPassword = BCrypt.checkpw(password, passwordHashed);

		System.out.println(passwordHashed);

	}*/

	
	@Test
	public void insertTest() {
		Clip clip = new Clip("Á¦¸ñ","ing");
		ClipDao dao = new ClipDao();
		dao.insert(clip, "lusiue");
		
		//dao.selectList("lusiue");
	}

}
