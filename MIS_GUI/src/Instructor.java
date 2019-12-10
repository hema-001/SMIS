
public class Instructor {

	private Long id;
	private String name;
	private String date_of_birth;
	private String gender;
	private String college;
	private String phone;
	private String address;
	private String password;
	private String degree;
	private String email;
	
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(Long id, String name, String date_of_birth, String gender, String college, String phone,
			String address, String password, String degree, String email) {
		super();
		this.id = id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.college = college;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.degree = degree;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
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

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
