package application;



public class BookItem{

	private int idx;
	private String title;
	private String Original;
	private String author;
	private String Age;
	private String rental_state;
	private String rental_day;
	private String return_day;
	private String content;
	private String userId; 
	
	public BookItem(int idx, String title, String Original, String author, String Age, String rental_state,
			String rental_day, String return_day, String content, String userId) {
		this.idx = idx;
		this.title = title;
		this.Original = Original;
		this.author = author;
		this.Age = Age;
		this.rental_state = rental_state;
	
		this.rental_day = rental_day;
		this.return_day = return_day;
		this.content = content;
		this.userId  = userId;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal() {
		return Original;
	}

	public void setOriginal(String Original) {
		this.Original = Original;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String Age) {
		this.Age = Age;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRental_day() {
		return rental_day;
	}

	public void setRental_day(String rental_day) {
		this.rental_day = rental_day;
	}

	public String getReturn_day() {
		return return_day;
	}

	public void setReturn_day(String return_day) {
		this.return_day = return_day;
	}

	public String getRental_state() {
		return rental_state;
	}

	public void setRental_state(String rental_state) {
		this.rental_state = rental_state;
	}
	
	public String getuserId() {
		return userId;
	}
	
	public void setuserId(String userId) {
		this.userId = userId;
	}
}