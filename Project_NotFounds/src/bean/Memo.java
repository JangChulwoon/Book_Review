package bean;

public class Memo {
	private int num;
	private String id;
	private String context;
	private String date;

	public Memo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Memo(int num, String id, String context) {
		super();
		this.num = num;
		this.id = id;
		this.context = context;
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
