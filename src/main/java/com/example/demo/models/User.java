package com.example.demo.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@Entity(name="users")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(name="user_locations",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locations;
    
    
    public User(String fname,String lname,String email, String phone_number,String password){
        this.first_name = fname;
        this.last_name = lname;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
    }


    public User() {}

    
    

    // SETTERS //
    public String getFirstName() {
        return this.first_name;
    }
    
    @JsonProperty(value="first_name")
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return this.last_name;
    }

    @JsonProperty(value="last_name")
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	@Override
	public String toString() {
		return "User [firstName=" + first_name + ", lastName=" + last_name + ", email=" + email + ", phone_number="
				+ phone_number + ", password=" + password + "]";
	}
    
    
}

   
