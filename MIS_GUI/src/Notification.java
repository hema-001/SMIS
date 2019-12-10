import java.util.Date;

public class Notification {

	private int id;
	private String title;
	private String content;
	private Date issue_date;
	private String author;
	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(int id, String title, String content,Date issue_date, String author) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.issue_date = issue_date;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
