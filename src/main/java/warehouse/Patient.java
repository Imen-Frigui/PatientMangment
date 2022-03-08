package warehouse;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Patient extends Medication{
	 private String id;
	 @Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return Objects.equals(id, other.id);
	}
	 private String name;
	 private String illness;
	 private String medName;
	 public Patient() {
		 
	 }
	 public Patient(String id, String name, String illness) {
		 super();
		 this.id = id;
		 this.name = name;
		 this.illness = illness;
		 this.setMedName(super.getNam()); 
	 }
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getIllness() {
			return illness;
		}
		public void setIllness(String illness) {
			this.illness = illness;
		}
		public String getMedName() {
			return medName;
		}
		public void setMedName(String medName) {
			this.medName = medName;
		}
	 
	 
}
