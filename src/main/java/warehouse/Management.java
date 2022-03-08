package warehouse;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;

@Path("/mangement")
public class Management {
	static List<Patient> patients = new ArrayList<Patient>();
	static List<Medication> medications = new ArrayList<Medication>();
	static List<Doctor> doctors = new ArrayList<Doctor>();
	static List<Appointement> appointements = new ArrayList<Appointement>();
	@PUT
	@Consumes("application/xml")
	@Path("/patient")
	public String addPatient(Patient patient) {    
		if(patients.isEmpty()) 
			{patients.add(patient);
			return "Patient added";}
		else 
		   	{
				if(patients.contains(patient)) 
					{ return "Imppossible to add"; }
				else {patients.add(patient);
					return "added"; }
				}
		}
	@PUT
	@Consumes("application/xml")
	@Path("/med")
	public String addItem(Medication medication) {
		String res="";
		char ch = medication.getRef().toUpperCase().charAt(0);
		if(medications.isEmpty()) {
			if(medications.add(medication)) {
				res=res+"Item Added";
			} else {
				res=res+"Couldn't Add the Item";
			}
		}else {
			if (medications.contains(medication)) {
				res="Item Already Exists";
			}else {
				
				if(ch=='A') {
					if(medications.add(medication)) {
						res=res+"Item Added to Pain medicine  ";
					} else {
						res=res+"Couldn't Add the Item";
					}
				}
				else if(ch=='B') {
					if(medications.add(medication)) {
						res=res+"Item Added to Nerve medicine  ";
					} else {
						res=res+"Couldn't Add the Item";
					}
				}
				else if (ch=='C') {
					if(medications.add(medication)) {
						res=res+"Item Added to dental medicine  ";
					} else {
						res=res+"Couldn't Add the Item";
					}
				}
				else {
					if(medications.add(medication)) {
						res=res+"Item Added to  general medicine  ";
					} else {
						res=res+"Couldn't Add the Item";
					}
				}
			}
		}
		return res;
	}
	@PUT
	@Consumes("application/xml")
	@Path("/doc")
	public String addDoc(Doctor doctor) {    
		if(doctors.isEmpty()) 
			{doctors.add(doctor);
			return "New Doctor has been added to the system";}
		else 
		   	{
				if(doctors.contains(doctor)) 
					{ return "Can't Use this ID it already exists"; }
				else {doctors.add(doctor);
					return "New Doctor has been added to the system in this filed"+doctor.getSpec(); }
				}
		}
	

	@PUT
	@Consumes("application/xml")
	@Path("/appt")
	public String addAppointement(Appointement appointement) {    
		if(appointements.isEmpty()) 
			{appointements.add(appointement);
			return "Appointement added at "+appointement.getDate()+" with "+appointement.getDoc();}
		else 
				if(appointements.contains(appointement))
					{ return "Imppossible to add"; }
				else {appointements.add(appointement);
					return "Appointement added at "+appointement.getDate()+" with "+appointement.getDoc(); }
	}
	@GET
	@Produces("application/xml")
	@Path("/doc")
	public  List<Doctor> listerDoctors()
	{
		return doctors;
		}
	@GET
	@Produces("application/xml")
	@Path("/med")
	public  List<Medication> listerMedications()
	{
		return medications;
		}
	@GET
	@Produces("application/xml")
	@Path("/patient")
	public  List<Patient> listerPatient()
	{
		return patients;
		}
	@GET
	@Produces("application/xml")
	@Path("/appt")
	public  List<Appointement> listerAppointements()
	{
		return appointements;
		}

	@GET
	@Produces("application/xml")
	@Path("/doc/{ID}")
	public Doctor FindDoctor(@PathParam("ID")String ID)
	{
		Doctor doctor = null ;
		for(Doctor i: doctors)
		{ if(i.getID().equals(ID))
			doctor=i;
			
		}
		return doctor;
		}
	@GET
	@Produces("application/xml")
	@Path("/med/{ref}")
	public Medication FindMdication(@PathParam("ref")String ref)
	{
		Medication medication= null ;
		for(Medication i: medications)
		{ if(i.getRef().equals(ref))
			medication=i;
			
		}
		return medication;
		}
	@GET
	@Produces("application/xml")
	@Path("/patient/{id}")
	public Patient FindPatient(@PathParam("id")String id)
	{
		Patient patient = null ;
		for(Patient i: patients)
		{ if(i.getId().equals(id))
			patient=i;
		}
		return patient;
		}

	@GET
	@Produces("application/xml")
	@Path("/appt/{date}")
	public Appointement FindAppointementDate(@PathParam("date")String date)
	{
		Appointement appointement = null ;
		for(Appointement i: appointements)
		{ if(i.getDate().equals(date))
			appointement=i;
			
		}
		return appointement;
		}
	 @POST
	 @Consumes("application/xml")
	 @Path("/patient/{name}")
	 public String updatePatient(@PathParam("name")String name, Patient patient) {
		for (Patient i: patients) {
			if(i.getName().equals(name))
			{ 
				i.setName(patient.getName());
				i.setIllness(patient.getIllness());
				return "Patient information update";
			}
		}
		  
		return" update impossible";
	}
	 @POST
	 @Consumes("application/xml")
	 @Path("/med/{name}")
	 public String updateMedication(@PathParam("name")String name, Medication medication) {
		for (Medication i: medications) {
			if(i.getNam().equals(name))
			{ 
				i.setNam(medication.getNam());
				return "Medication name update";
			}
		}
		  
		return" update impossible";
		
		
	}
	 @POST
	 @Consumes("application/xml")
	 @Path("/doc/{Name}")
	 public String updateDoctor(@PathParam("Name")String Name, Doctor doctor) {
		for (Doctor i: doctors) {
			if(i.getName().equals(Name))
			{ 
				i.setName(doctor.getName());
				return "Doctor name update";
			}
		}
		  
		return" update impossible";		
	}
	 @POST
	 @Consumes("application/xml")
	 @Path("/appt/{date}")
	 public String UpdateAppointement(@PathParam("date")String date, Appointement appointement) {
		for (Appointement i: appointements) {
			if(i.getDate().equals(date))
			{ 
				i.setDate(appointement.getDate());
				return " appointement update";
			}
		}
		  
		return" update impossible";		
	}
	}
	 








