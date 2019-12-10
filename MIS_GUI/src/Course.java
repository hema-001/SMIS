
public class Course {
	
	private Long id;
	private String name;
	private String teacher;
	private String semester;
	private String day;
	private String period;
	private String credits;
	private String room;
	
	public Course(Long id, String name, String teacher, String semester, String day, String period, String credits,
			String room) {
		super();
		this.id = id;
		this.name = name;
		this.teacher = teacher;
		this.semester = semester;
		this.day = day;
		this.period = period;
		this.credits = credits;
		this.room = room;
	}

	public Course() {

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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCredits() {
		return credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	
	

}
