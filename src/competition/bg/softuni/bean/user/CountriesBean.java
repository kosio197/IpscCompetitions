package competition.bg.softuni.bean.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "countriesBean")
@ApplicationScoped
public class CountriesBean {
	private List<String> countries;
	private String defaultCountry;
	
	@PostConstruct
	public void init() {
		countries = new ArrayList<String>();
		
		countries.add("Argentina");
		countries.add("USA");
		countries.add("Bulgaria");
		
		defaultCountry = "Bulgaria";
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public String getDefaultCountry() {
		return defaultCountry;
	}

	public void setDefaultCountry(String defaultCountry) {
		this.defaultCountry = defaultCountry;
	}
}
