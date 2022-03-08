package warehouse;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Appointement extends Doctor{
	private String date;
	private String doc;
	private String patient;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(date, doc);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointement other = (Appointement) obj;
		return Objects.equals(date, other.date) && Objects.equals(doc, other.doc);
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public Appointement() {}
	public Appointement(String date, String doc, String patient) {
		super();
		this.date=date;
		this.doc=doc;
		this.patient=patient;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}

 
}
