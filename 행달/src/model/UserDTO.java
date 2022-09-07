package model;

		// DTO : Data Transfer Object
public class UserDTO {
	
	private String id;
	private String pw;
	private String name;
	private int save;
	
	
	public UserDTO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	   
	
	public UserDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}
	
	
	
	
	
	
	
	
	
}
