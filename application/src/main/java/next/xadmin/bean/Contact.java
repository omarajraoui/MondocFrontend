package next.xadmin.bean;

public class Contact {
	private String firstname;
	private String email;
	private String numero;
	private String message;
	
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(String firstname, String email, String numero, String message) {
		super();
		this.firstname = firstname;
		this.email = email;
		this.numero = numero;
		this.message = message;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
