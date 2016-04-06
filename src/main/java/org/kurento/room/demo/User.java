package org.kurento.room.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String noHP;
	private Integer dept;
	private Integer gid;
	private String email;
	@Lob
	private String image;
	private String imageType;
	private int privileges;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getPrivileges() {
		return privileges;
	}	
	
	public String getImage() {
		return image;
	}
	
	public String getImageType() {
		return imageType;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
 	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public void setNoHP(String nohp){
		this.noHP = nohp;
	}

	public String getNoHP(){
		return noHP;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setGid(Integer gid){
		this.gid = gid;
	}

	public Integer getGid(){
		return gid;
	}

	public void setDept(Integer dept){
		this.dept = dept;
	}
	
	public Integer getDept(){
		return dept;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

}
