package ma.ifootback.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Pitch")
public class Pitch {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String address;
	private String format;
	private Float price;
	private String city;
	private String heure_open;
	private String heure_close;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "picture_id")
    private Picture picture;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

	
	public Pitch() {
		super();
	}

	public Pitch(String name, String address, String format, Float price, String city, Picture pictures,
			User user, Location location) {
		super();
		this.name = name;
		this.address = address;
		this.format = format;
		this.price = price;
		this.city = city;
		this.picture = pictures;
		this.user = user;
		this.location = location;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture pictures) {
		this.picture = pictures;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHeure_open() {
		return heure_open;
	}

	public void setHeure_open(String heure_open) {
		this.heure_open = heure_open;
	}

	public String getHeure_close() {
		return heure_close;
	}

	public void setHeure_close(String heure_close) {
		this.heure_close = heure_close;
	}
	
	
}