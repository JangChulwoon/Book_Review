package bean;

public class User {
	private String useremail;
	private String userpd;
	private String username;

	public User(String useremail, String userpd, String username) {
		super();
		this.useremail = useremail;
		this.userpd = userpd;
		this.username = username;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpd() {
		return userpd;
	}

	public void setUserpd(String userpd) {
		this.userpd = userpd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
