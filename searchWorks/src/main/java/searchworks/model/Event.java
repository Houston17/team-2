package searchworks.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn; 


@Entity
@Table(name="events")
public class Event {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String address;
	
	@ManyToMany
	@JoinTable(
		      name="eventvolunteer",
		      joinColumns=@JoinColumn(name="EVENT_ID", referencedColumnName="ID"),
		      inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
	private List<Person> volunteers;
	
	@Column
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

	public List<Person> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(List<Person> volunteers) {
		this.volunteers = volunteers;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", address=" + address + ", volunteers=" + volunteers + ", date="
				+ date + "]";
	}

	
	
	
}
