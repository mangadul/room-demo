package org.kurento.room.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String password;
	private Integer admin;
	@Lob
	private String image;
	private String imageType;
		
	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public Integer getAdmin() {
		return admin;
	}
	
	public String getImage() {
		return image;
	}
	
	public String getImageType() {
		return imageType;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		Md5PasswordEncoder encoderMD5 = new Md5PasswordEncoder();
		String securePass = encoderMD5.encodePassword(password, null);		
		this.password = securePass;
	}
	
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
}