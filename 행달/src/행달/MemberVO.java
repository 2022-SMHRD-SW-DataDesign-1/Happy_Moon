package วเดÞ;

public class MemberVO {
private String name;
private String id;
private String pw;
private Chap_story save_data;



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
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



public Chap_story getSave_data() {
	return save_data;
}



public void setSave_data(Chap_story save_data) {
	this.save_data = save_data;
}



public MemberVO(String name, String id, String pw, Chap_story save_data) {
	super();
	this.name = name;
	this.id = id;
	this.pw = pw;
	this.save_data = save_data;
}



}
