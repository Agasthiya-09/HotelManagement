package com.hotel.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Booking {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int bookingId;

	    private LocalDate checkIn;
	    private LocalDate checkOut;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "room_id")
	    private Room room;

	    public Booking() {
	    }

	    public Booking(LocalDate checkIn,
	                   LocalDate checkOut,
	                   Customer customer,
	                   Room room) {

	        this.checkIn = checkIn;
	        this.checkOut = checkOut;
	        this.customer = customer;
	        this.room = room;
	    }

		public int getBookingId() {
			return bookingId;
		}

		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}

		public LocalDate getCheckIn() {
			return checkIn;
		}

		public void setCheckIn(LocalDate checkIn) {
			this.checkIn = checkIn;
		}

		public LocalDate getCheckOut() {
			return checkOut;
		}

		public void setCheckOut(LocalDate checkOut) {
			this.checkOut = checkOut;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}
	    
}
