package com.rama.hotel.booking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ROOM")
@Proxy(lazy = false)
public class Room implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private int price;

    @NotNull
    @Column(name = "CAPACITY", nullable = false)
    private int capacity;

    @Column(name = "DESCRIPTION", nullable = true)
    private String description; 

    @NotNull
    @Column(name = "BATH", nullable = false)
    private Boolean bath;
    	
    @NotNull
    @Column(name = "BED", nullable = false)
    private int bed;

    @NotNull
    @Column(name = "INTERNET", nullable = false)
    private Boolean internet;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE", nullable = false)
    private RoomType type;

    @OneToOne(mappedBy = "room", fetch = FetchType.EAGER)
    private Booking booking;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private List<RoomImages> images;

    
    
    
	public Room(int id, String name, @NotNull int price, @NotNull int capacity, String description,
			@NotNull Boolean bath, @NotNull int bed, @NotNull Boolean internet, String status, RoomType type,
			Booking booking, List<RoomImages> images) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.capacity = capacity;
		this.description = description;
		this.bath = bath;
		this.bed = bed;
		this.internet = internet;
		this.status = status;
		this.type = type;
		this.booking = booking;
		this.images = images;
	}

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getBath() {
		return bath;
	}

	public void setBath(Boolean bath) {
		this.bath = bath;
	}

	public int getBed() {
		return bed;
	}

	public void setBed(int bed) {
		this.bed = bed;
	}

	public Boolean getInternet() {
		return internet;
	}

	public void setInternet(Boolean internet) {
		this.internet = internet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<RoomImages> getImages() {
		return images;
	}

	public void setImages(List<RoomImages> images) {
		this.images = images;
	}

   
    
    
}
