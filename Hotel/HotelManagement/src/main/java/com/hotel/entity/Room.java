package com.hotel.entity;

import jakarta.persistence.*;

@Entity
public class Room {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int roomId;

	    private String roomNumber;
	    private String roomType;
	    private double price;
	    private String status;

	    @ManyToOne
	    @JoinColumn(name = "hotel_id")
	    private Hotel hotel;

	    public Room() {
	    }

	    public Room(String roomNumber, String roomType,
	                double price, String status, Hotel hotel) {

	        this.roomNumber = roomNumber;
	        this.roomType = roomType;
	        this.price = price;
	        this.status = status;
	        this.hotel = hotel;
	    }

		public int getRoomId() {
			return roomId;
		}

		public void setRoomId(int roomId) {
			this.roomId = roomId;
		}

		public String getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}

		public String getRoomType() {
			return roomType;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Hotel getHotel() {
			return hotel;
		}

		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}
	    
}
