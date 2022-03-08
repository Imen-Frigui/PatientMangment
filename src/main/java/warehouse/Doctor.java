package warehouse;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Doctor {
	private String spec;
	private String ID;
	private String Name;
	
	public Doctor() {}
	public Doctor(String spec, String ID, String Name) {
	super();
	this.setID(ID);
	this.setName(Name);
	this.setSpec(spec);
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return Objects.equals(ID, other.ID);
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
}
