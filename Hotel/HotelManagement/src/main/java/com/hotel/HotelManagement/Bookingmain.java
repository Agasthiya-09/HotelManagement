package com.hotel.HotelManagement;

import java.time.LocalDate;
import java.util.List;

import com.hotel.dao.BookingDAO;
import com.hotel.dao.CustomerDAO;
import com.hotel.dao.HotelDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.entity.Booking;
import com.hotel.entity.Customer;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;

public class Bookingmain {

	public static void main(String[] args) {
		 /*// -------------------------
        // CREATE CUSTOMER
        // -------------------------

        Customer customer = new Customer(
                "Arun",
                "arun@gmail.com",
                "9876543210",
                "Chennai"
        );

        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.addCustomer(customer);


        // -------------------------
        // CREATE HOTEL
        // -------------------------

        Hotel hotel = new Hotel(
                "Green Park Hotel",
                "Chennai",
                "0441234567"
        );

        HotelDAO hotelDAO = new HotelDAO();

        hotelDAO.addHotel(hotel);


        // -------------------------
        // CREATE ROOM
        // -------------------------

        Room room = new Room(
                "101",
                "Deluxe",
                3500,
                "Available",
                hotel
        );

        RoomDAO roomDAO = new RoomDAO();

        roomDAO.addRoom(room);


        // -------------------------
        // CREATE BOOKING
        // -------------------------

        Booking booking = new Booking(
                LocalDate.of(2026, 10, 10),
                LocalDate.of(2026, 10, 12),
                customer,
                room
        );

        BookingDAO bookingDAO = new BookingDAO();

        bookingDAO.addBooking(booking);


        System.out.println(
                "Booking ID: "
                + booking.getBookingId());
	*/
	//read booking
		BookingDAO bookingDAO = new BookingDAO();
		/*Booking result =
		        bookingDAO.getBooking(1);

		if (result != null) {

		    System.out.println(
		            "Booking ID: "
		            + result.getBookingId());

		    System.out.println(
		            "Check In: "
		            + result.getCheckIn());

		    System.out.println(
		            "Check Out: "
		            + result.getCheckOut());

		    System.out.println(
		            "Customer: "
		            + result.getCustomer().getName());

		    System.out.println(
		            "Room: "
		            + result.getRoom().getRoomNumber());
		}*/
		//read all bookings
		/*List<Booking> bookings =
		        bookingDAO.getAllBookings();

		for (Booking b : bookings) {

		    System.out.println(
		            "Booking ID: "
		            + b.getBookingId());

		    System.out.println(
		            "Customer: "
		            + b.getCustomer().getName());

		    System.out.println(
		            "Room: "
		            + b.getRoom().getRoomNumber());

		    System.out.println(
		            "Check In: "
		            + b.getCheckIn());

		    System.out.println(
		            "Check Out: "
		            + b.getCheckOut());

		    System.out.println("--------------------");
		}*/
		//update
		/*Booking booking =
		        bookingDAO.getBooking(1);
		booking.setCheckOut(
		        LocalDate.of(2026, 10, 15)
		);
		bookingDAO.updateBooking(booking);*/
		bookingDAO.deleteBooking(1);
	}

}
