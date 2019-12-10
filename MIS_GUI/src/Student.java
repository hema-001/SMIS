public class Student {

	private long ID;
	private String name;
	private String DOB;
	private String gender;
	private String passport;
	private String nationality;
	private String college;
	private String major;
	private String phone;
	private String address;
	private String password;
	private String email;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long iD, String name, String dOB, String gender, String passport, String nationality, String college,
			String major, String phone, String address, String password, String email) {
		super();
		this.ID = iD;
		this.name = name;
		this.DOB = dOB;
		this.gender = gender;
		this.passport = passport;
		this.nationality = nationality;
		this.college = college;
		this.major = major;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.email = email;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
