package competition.bg.softuni.model.user;

public class Competitor {
	private User user;
	private String cathegory;
	private String devision;
	
	public Competitor(User user, String cathegory, String devision) {
		this.user = user;
		this.cathegory = cathegory;
		this.devision = devision;
	}
	
	public String getDevision() {
		return devision;
	}
	
	public void setDevision(String devision) {
		this.devision = devision;
	}
	
	public String getCathegory() {
		return cathegory;
	}
	
	public void setCathegory(String cathegory) {
		this.cathegory = cathegory;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
