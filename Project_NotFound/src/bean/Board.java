package bean;

import java.util.Date;

public class Board {
	private int num;
	private String subject;
	private String writer;
	private String contents;
	private String bookname;
	private String author;
	private String publisher;
	private String publication_date;
	private String book_img;
	private String description;
	private String date;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Board(String subject, String writer, String contents, String bookname, String author,
			String publisher, String publication_date, String book_img, String description) {
		super();
		this.subject = subject;
		this.writer = writer;
		this.contents = contents;
		this.bookname = bookname;
		this.author = author;
		this.publisher = publisher;
		this.publication_date = publication_date;
		this.book_img = book_img;
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public String getBook_img() {
		return book_img;
	}

	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
