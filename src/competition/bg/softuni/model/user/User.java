package competition.bg.softuni.model.user;

public class User {
	private String username;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String country;
	private String cathegory;
	private String defaultDevision;
	
	public User() {
		defaultDevision="PRD";
		cathegory="PRD";
	}
	
	public User(String firstName, String lastName, String email, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCathegory() {
		return cathegory;
	}

	public void setCathegory(String cathegory) {
		this.cathegory = cathegory;
	}

	public String getDefaultDevision() {
		return defaultDevision;
	}

	public void setDefaultDevision(String defaultDevision) {
		this.defaultDevision = defaultDevision;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
