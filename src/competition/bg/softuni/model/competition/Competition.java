package competition.bg.softuni.model.competition;

import java.util.Date;

public class Competition {
	private String name;
	private int level;
	private String address;
	private String club;
	private String discipline;
	private Date matchDate;
	private int minRounds;
	private int stagesCount;
	private double fee;
	private String feeCurrency;
	
	public Competition(String name, int level, String address, String club, String discipline, Date matchDate,
			int minRounds, int stagesCount, double fee, String feeCurrency) {
		this.name = name;
		this.level = level;
		this.address = address;
		this.club = club;
		this.discipline = discipline;
		this.matchDate = matchDate;
		this.minRounds = minRounds;
		this.stagesCount = stagesCount;
		this.fee = fee;
		this.feeCurrency = feeCurrency;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getClub() {
		return club;
	}
	
	public void setClub(String club) {
		this.club = club;
	}
	
	public String getDiscipline() {
		return discipline;
	}
	
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	
	public Date getMatchDate() {
		return matchDate;
	}
	
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	
	public int getMinRounds() {
		return minRounds;
	}
	
	public void setMinRounds(int minRounds) {
		this.minRounds = minRounds;
	}
	
	public int getStagesCount() {
		return stagesCount;
	}
	
	public void setStagesCount(int stagesCount) {
		this.stagesCount = stagesCount;
	}
	
	public double getFee() {
		return fee;
	}
	
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public String getFeeCurrency() {
		return feeCurrency;
	}
	
	public void setFeeCurrency(String feeCurrency) {
		this.feeCurrency = feeCurrency;
	} 
}
