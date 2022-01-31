package next.xadmin.bean;

public class Patient {
	
	private int id;
	private String firstname;
	private String lastname;
	private String docname;
	private String speciality;
	private String rapport;
	
	
	public Patient(String firstname, String lastname, String docname, String speciality, String rapport) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.docname = docname;
		this.speciality = speciality;
		this.rapport = rapport;
	}
	public Patient(int id, String firstname, String lastname, String docname, String speciality, String rapport) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.docname = docname;
		this.speciality = speciality;
		this.rapport = rapport;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDocname() {
		return docname;
	}
	public void setDocname(String docname) {
		this.docname = docname;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	
}
