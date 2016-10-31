package competition.bg.softuni.model.user;

public class Competitor {
	private User user;
	private String devision;
	
	public Competitor(User user, String devision) {
		this.user = user;
		this.devision = devision;
	}
	
	public String getDevision() {
		return devision;
	}
	
	public void setDevision(String devision) {
		this.devision = devision;
	}
		
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
