package application;

import javafx.beans.property.SimpleStringProperty;


public class rentalTable { 

	private SimpleStringProperty title;
	private SimpleStringProperty Original;
	private SimpleStringProperty author;
	private SimpleStringProperty Age;
	private SimpleStringProperty rental_day;
	private SimpleStringProperty return_day;	
	private SimpleStringProperty rental_state;
	
	public rentalTable(String title, String Original, String author,
			String Age, String rental_day, String return_day, String rental_state) {
		
		this.title = new SimpleStringProperty(title);
		this.Original = new SimpleStringProperty(Original);
		this.author = new SimpleStringProperty(author);
		this.Age = new SimpleStringProperty(Age);
		this.rental_day = new SimpleStringProperty(rental_day);
		this.return_day = new SimpleStringProperty(return_day);
		this.rental_state = new SimpleStringProperty(rental_state);
		
	}


	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title.set(title);
	}

	public String getOriginal() {
		return Original.get();
	}

	public void setOriginal(String Original) {
		this.Original.set(Original);
	}

	public String getAuthor() {
		return author.get();
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public String getAge() {
		return Age.get();
	}

	public void setAge(String Age) {
		this.Age.set(Age);
	}

	public void setRental_state(String rental_state) {
		this.rental_state.set(rental_state);
	}	
	

	
}
