package ma.ifootback.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "password", nullable = true)
	private String password;
	@Column(name = "phone")
	private String phone;
	@Column(name = "date_of_birth")
	private Date date_of_birth;
	@Column(name = "city")
	private String city;
	@Column(name = "country")
	private String country;
	@Column(name = "created_at")
	private Date Created_at;
	@Column(name = "SM_provider", nullable = true)
	private String social_media_provider;
	@Column(name = "SM_userid", nullable = true)
	private String social_media_userid;
	@Column(name = "role")
	private int role;
	
	public User() {}
	public User(String name, String email, String password, String phone, Date date_of_birth, String city,
			String country, Date created_at, String social_media_provider, String social_media_userid) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.date_of_birth = date_of_birth;
		this.city = city;
		this.country = country;
		Created_at = created_at;
		this.social_media_provider = social_media_provider;
		this.social_media_userid = social_media_userid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCreated_at() {
		return Created_at;
	}
	public void setCreated_at(Date created_at) {
		Created_at = created_at;
	}
	public String getSocial_media_provider() {
		return social_media_provider;
	}
	public void setSocial_media_provider(String social_media_provider) {
		this.social_media_provider = social_media_provider;
	}
	public String getSocial_media_userid() {
		return social_media_userid;
	}
	public void setSocial_media_userid(String social_media_userid) {
		this.social_media_userid = social_media_userid;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
}
