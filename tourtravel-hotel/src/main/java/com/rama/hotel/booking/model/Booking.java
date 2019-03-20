package com.rama.hotel.booking.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BOOKING")
@Proxy(lazy = false)
public class Booking implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "USER_ID", nullable = false)
	    private User user;

	    @OneToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "ROOM_ID", nullable = true)
	    private Room room;

	    @Column(name = "PEOPLE", nullable = false)
	    private Integer people;

	    @Column(name = "ARRIVAL_TIME", nullable = false)
	 
	    @DateTimeFormat(pattern = "MM/dd/yyyy")
	    private Date arrivalTime;

	    @Column(name = "DEPARTURE_TIME", nullable = false)
	  
	    @DateTimeFormat(pattern = "MM/dd/yyyy")
	    private Date departureTime;

	    @Column(name = "COMMENT", nullable = true)
	    private String comment;

	    @Column(name = "STATUS", nullable = false)
	    private String status;

	    @Column(name = "ROOM_BOOKED")
	    private String roomBooked;

		public Booking() {
			super();
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public int getPeople() {
			return people;
		}

		public void setPeople(int people) {
			this.people = people;
		}

		public Date getArrivalTime() {
			return arrivalTime;
		}

		public void setArrivalTime(Date arrivalTime) {
			this.arrivalTime = arrivalTime;
		}

		public Date getDepartureTime() {
			return departureTime;
		}

		public void setDepartureTime(Date departureTime) {
			this.departureTime = departureTime;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getRoomBooked() {
			return roomBooked;
		}

		public void setRoomBooked(String roomBooked) {
			this.roomBooked = roomBooked;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
			result = prime * result + ((comment == null) ? 0 : comment.hashCode());
			result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + people;
			result = prime * result + ((room == null) ? 0 : room.hashCode());
			result = prime * result + ((roomBooked == null) ? 0 : roomBooked.hashCode());
			result = prime * result + ((status == null) ? 0 : status.hashCode());
			result = prime * result + ((user == null) ? 0 : user.hashCode());
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
			Booking other = (Booking) obj;
			if (arrivalTime == null) {
				if (other.arrivalTime != null)
					return false;
			} else if (!arrivalTime.equals(other.arrivalTime))
				return false;
			if (comment == null) {
				if (other.comment != null)
					return false;
			} else if (!comment.equals(other.comment))
				return false;
			if (departureTime == null) {
				if (other.departureTime != null)
					return false;
			} else if (!departureTime.equals(other.departureTime))
				return false;
			if (id != other.id)
				return false;
			if (people != other.people)
				return false;
			if (room == null) {
				if (other.room != null)
					return false;
			} else if (!room.equals(other.room))
				return false;
			if (roomBooked == null) {
				if (other.roomBooked != null)
					return false;
			} else if (!roomBooked.equals(other.roomBooked))
				return false;
			if (status == null) {
				if (other.status != null)
					return false;
			} else if (!status.equals(other.status))
				return false;
			if (user == null) {
				if (other.user != null)
					return false;
			} else if (!user.equals(other.user))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Booking [id=" + id + ", user=" + user + ", room=" + room + ", people=" + people + ", arrivalTime="
					+ arrivalTime + ", departureTime=" + departureTime + ", comment=" + comment + ", status=" + status
					+ ", roomBooked=" + roomBooked + "]";
		} 

	
	
}
