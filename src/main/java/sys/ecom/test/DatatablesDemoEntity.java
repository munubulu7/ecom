package sys.ecom.test;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Debashis Paul on 6/3/2017.
 */
@Entity
@Table(name = "datatables_demo", schema = "ecom", catalog = "")
public class DatatablesDemoEntity {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "first_name")
	private String firstName;
	@Basic
	@Column(name = "last_name")
	private String lastName;
	@Basic
	@Column(name = "position")
	private String position;
	@Basic
	@Column(name = "email")
	private String email;
	@Basic
	@Column(name = "office")
	private String office;
	@Basic
	@Column(name = "start_date")
	private Timestamp startDate;
	@Basic
	@Column(name = "age")
	private Integer age;
	@Basic
	@Column(name = "salary")
	private Integer salary;
	@Basic
	@Column(name = "seq")
	private Integer seq;
	@Basic
	@Column(name = "extn")
	private String extn;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getExtn() {
		return extn;
	}

	public void setExtn(String extn) {
		this.extn = extn;
	}
}
