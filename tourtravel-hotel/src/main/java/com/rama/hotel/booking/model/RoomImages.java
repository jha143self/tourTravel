package com.rama.hotel.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "ROOM_IMAGE")
@Proxy(lazy = false)
public class RoomImages {

	
	  @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @NotNull
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "ROOM", nullable = false)
	    private Room room;

	    @Column(name = "NAME", nullable = false)
	    private String name;

	    @Column(name = "URL", nullable = false)
	    private String url;

	    
	    
	    
		public RoomImages(int id, @NotNull Room room, String name, String url) {
			super();
			this.id = id;
			this.room = room;
			this.name = name;
			this.url = url;
		}

		public RoomImages() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((room == null) ? 0 : room.hashCode());
			result = prime * result + ((url == null) ? 0 : url.hashCode());
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
			RoomImages other = (RoomImages) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (room == null) {
				if (other.room != null)
					return false;
			} else if (!room.equals(other.room))
				return false;
			if (url == null) {
				if (other.url != null)
					return false;
			} else if (!url.equals(other.url))
				return false;
			return true;
		}
	    
	    
	
}
