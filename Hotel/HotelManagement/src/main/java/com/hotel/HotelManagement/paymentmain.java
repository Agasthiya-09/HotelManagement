package com.hotel.HotelManagement;

import java.time.LocalDate;
import java.util.List;

import com.hotel.dao.BookingDAO;
import com.hotel.dao.CustomerDAO;
import com.hotel.dao.HotelDAO;
import com.hotel.dao.PaymentDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.entity.Booking;
import com.hotel.entity.Customer;
import com.hotel.entity.Hotel;
import com.hotel.entity.Payment;
import com.hotel.entity.Room;

public class paymentmain {

	public static void main(String[] args) {
		/*// -------------------------
        // CUSTOMER
        // -------------------------

        Customer customer = new Customer(
                "Arun",
                "arun@gmail.com",
                "9876543210",
                "Chennai"
        );

        CustomerDAO customerDAO =
                new CustomerDAO();

        customerDAO.addCustomer(customer);


        // -------------------------
        // HOTEL
        // -------------------------

        Hotel hotel = new Hotel(
                "Green Park Hotel",
                "Chennai",
                "0441234567"
        );

        HotelDAO hotelDAO =
                new HotelDAO();

        hotelDAO.addHotel(hotel);


        // -------------------------
        // ROOM
        // -------------------------

        Room room = new Room(
                "101",
                "Deluxe",
                3500,
                "Booked",
                hotel
        );

        RoomDAO roomDAO =
                new RoomDAO();

        roomDAO.addRoom(room);


        // -------------------------
        // BOOKING
        // -------------------------

        Booking booking = new Booking(
                LocalDate.of(2026, 10, 10),
                LocalDate.of(2026, 10, 12),
                customer,
                room
        );

        BookingDAO bookingDAO =
                new BookingDAO();

        bookingDAO.addBooking(booking);


        // -------------------------
        // PAYMENT
        // -------------------------

        Payment payment = new Payment(
                7000,
                LocalDate.now(),
                "UPI",
                booking
        );

        PaymentDAO paymentDAO =
                new PaymentDAO();

        paymentDAO.addPayment(payment);


        System.out.println(
                "Payment ID: "
                + payment.getPaymentId());
        */
		//read payment
		PaymentDAO paymentDAO =new PaymentDAO();
		/*Payment result =
		        paymentDAO.getPayment(1);

		if (result != null) {

		    System.out.println(
		            "Payment ID: "
		            + result.getPaymentId());

		    System.out.println(
		            "Amount: "
		            + result.getAmount());

		    System.out.println(
		            "Payment Method: "
		            + result.getPaymentMethod());

		    System.out.println(
		            "Payment Date: "
		            + result.getPaymentDate());

		    System.out.println(
		            "Booking ID: "
		            + result.getBooking().getBookingId());
		}*/
		//read all payments
		/*List<Payment> payments =
		        paymentDAO.getAllPayments();

		for (Payment p : payments) {

		    System.out.println(
		            "Payment ID: "
		            + p.getPaymentId());

		    System.out.println(
		            "Amount: "
		            + p.getAmount());

		    System.out.println(
		            "Method: "
		            + p.getPaymentMethod());

		    System.out.println(
		            "Date: "
		            + p.getPaymentDate());

		    System.out.println("----------------");
		}*/
		//update
		/*Payment payment =paymentDAO.getPayment(1);
		payment.setPaymentMethod("Cash");
		paymentDAO.updatePayment(payment);*/
		paymentDAO.deletePayment(1);
	}

}
