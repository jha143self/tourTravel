package com.rama.hotel.booking.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name = "ROOM_TYPE")
public class RoomType implements Serializable{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomType() {
		super();
	}

	@Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @NotNull
	    @SafeHtml
	    @Column(name = "BASE_PRICE")
	    private int basePrice;

	    @Column(name = "TYPE", length = 15, unique = true, nullable = false)
	    private String type; 

	    @OneToMany(mappedBy = "type")
	    private Set<Room> rooms;

		public RoomType(int id, @NotNull @SafeHtml int basePrice, String type, Set<Room> rooms) {
			super();
			this.id = id;
			this.basePrice = basePrice;
			this.type = type;
			this.rooms = rooms;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getBasePrice() {
			return basePrice;
		}

		public void setBasePrice(int basePrice) {
			this.basePrice = basePrice;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Set<Room> getRooms() {
			return rooms;
		}

		public void setRooms(Set<Room> rooms) {
			this.rooms = rooms;
		}
	    
	    
	
}
