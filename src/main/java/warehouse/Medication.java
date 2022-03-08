package warehouse;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Medication {
	private String ref;
	protected String name;
	
	public Medication() {}
	public Medication(String ref, String name) {
		super();
		this.ref=ref;
		this.name=name;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref=ref;
	}
	public String getNam() {
		return name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ref);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medication other = (Medication) obj;
		return Objects.equals(ref, other.ref);
	}
	public void setNam(String name) {
		this.name=name;
	}
	
	

}
