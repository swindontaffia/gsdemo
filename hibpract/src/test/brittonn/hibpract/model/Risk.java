package test.brittonn.hibpract.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Risk {

	private String name;

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
