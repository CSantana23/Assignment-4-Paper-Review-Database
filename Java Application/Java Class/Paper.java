package db.columns;

public class Paper {
	private int id;
	private String title;
	private String absstract;
	private String fileName;
	private String authorId;
	private String reviewerId;
	
	
	
	public Paper(String title, String absstract, String fileName, String authorId, String reviewerId) {
		super();
		this.title = title;
		this.absstract = absstract;
		this.fileName = fileName;
		this.authorId = authorId;
		this.reviewerId = reviewerId;
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
	
	public String getabsstract() {
		return absstract;
	}
	
	public void setAbsstract(String absstract) {
		this.absstract = absstract;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getAuthorId() {
		return authorId;
	}
	
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}
}
