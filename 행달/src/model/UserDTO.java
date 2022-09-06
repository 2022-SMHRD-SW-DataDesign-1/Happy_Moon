package model;

		// DTO : Data Transfer Object
		// Member Table data�� �ְ� �޴� �뵵! - ��ü, Ŭ����
public class UserDTO {
	// main X 
	
	// �ʵ� �ʿ�(�Ӽ�)
	private String id;
	private String pw;
	private String name;
	private String save;
	
	
	public UserDTO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	   
	
	public UserDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	// ��Ŭ��  -> source -> generate getters and setters
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

	public String getAge() {
		return save;
	}

	public void setAge(String save) {
		this.save = save;
	}
	
	
	
	
	
}
