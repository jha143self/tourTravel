package com.rama.hotel.booking.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "APP_USER")
@Proxy(lazy = false)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    @Column(name = "USERNAME", unique = true, nullable = false)
	    private String username;

	    @Column(name = "PASSWORD", nullable = false)
	    private String password;

	    @Column(name = "FIRST_NAME", nullable = false)
	    private String firstName;

	    @Column(name = "LAST_NAME", nullable = false)
	    private String lastName;

	    @Column(name = "EMAIL", unique = true, nullable = false)
	    private String email;

	    @Column(name = "TOKEN")
	    private String token;

	/*
	 * @JoinTable(name = "APP_USER_USER_PROFILE",
	 * joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
	 * inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	 */
	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "APP_USER_USER_PROFILE",
	    joinColumns = {@JoinColumn(name = "USER_ID")},
	    inverseJoinColumns = {@JoinColumn(name = "USER_PROFILE_ID")})
	    private Set<UserProfile> userProfiles;
	   

	    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	    private List<Booking> bookings;

	    
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((bookings == null) ? 0 : bookings.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((token == null) ? 0 : token.hashCode());
			result = prime * result + ((userProfiles == null) ? 0 : userProfiles.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (bookings == null) {
				if (other.bookings != null)
					return false;
			} else if (!bookings.equals(other.bookings))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (token == null) {
				if (other.token != null)
					return false;
			} else if (!token.equals(other.token))
				return false;
			if (userProfiles == null) {
				if (other.userProfiles != null)
					return false;
			} else if (!userProfiles.equals(other.userProfiles))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		public User(Integer id, String username, String password, String firstName, String lastName, String email,
				String token, Set<UserProfile> userProfiles, List<Booking> bookings) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.token = token;
			this.userProfiles = userProfiles;
			this.bookings = bookings;
		}

		public User() {
			// TODO Auto-generated constructor stub
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public Set<UserProfile> getUserProfiles() {
			return userProfiles;
		}

		public void setUserProfiles(Set<UserProfile> userProfiles) {
			this.userProfiles = userProfiles;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}

	    
	    
	    
	
	
	
	
}
