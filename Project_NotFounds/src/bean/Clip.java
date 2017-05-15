package bean;

import java.util.Date;

public class Clip {
	private String book_name;
	private String state;
	
	public Clip() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Clip(String book_name,  String state) {
		super();
		this.book_name = book_name;
		this.state = state;
	}


	public String getBook_name() {
		return book_name;
	}
	
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
}
