package com.hotel.HotelManagement;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.hotel.dao.CustomerDAO;
import com.hotel.entity.Customer;
import com.hotel.dao.HotelDAO;
import com.hotel.entity.Hotel;
import com.hotel.dao.RoomDAO;
import com.hotel.entity.Room;
import com.hotel.dao.BookingDAO;
import com.hotel.entity.Booking;
import com.hotel.dao.PaymentDAO;
import com.hotel.entity.Payment;

public class CustomerManagement {

	static Scanner scanner = new Scanner(System.in);
    static CustomerDAO customerDAO = new CustomerDAO();
    static HotelDAO hotelDAO = new HotelDAO();
    static RoomDAO roomDAO = new RoomDAO();
    static BookingDAO bookingDAO = new BookingDAO();
    static PaymentDAO paymentDAO = new PaymentDAO();
	public static void main(String[] args) {
		while (true) {

            
            System.out.println("     HOTEL MANAGEMENT SYSTEM");
           
            System.out.println("1. Customer Management");
            System.out.println("2. Hotel Management");
            System.out.println("3. Room Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Payment Management");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    customerMenu();
                    break;

                case 2:
                	hotelMenu();
                    break;

                case 3:
                	roomMenu();
                    break;

                case 4:
                	bookingMenu();
                    break;

                case 5:
                	paymentMenu();
                    break;

                case 6:
                    System.out.println("Thank you for using Hotel Management System!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    
    // CUSTOMER MENU
    

    public static void customerMenu() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("       CUSTOMER MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. View All Customers");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Back");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addCustomer();
                    break;

                case 2:
                    viewCustomer();
                    break;

                case 3:
                    viewAllCustomers();
                    break;

                case 4:
                    updateCustomer();
                    break;

                case 5:
                    deleteCustomer();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    
    // ADD CUSTOMER
    

    public static void addCustomer() {

        System.out.println("\n----- Add Customer -----");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {

            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        if (!email.contains("@")) {

            System.out.println("Invalid email address!");
            return;
        }

        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        if (!phone.matches("\\d{10}")) {

            System.out.println(
                    "Phone number must contain exactly 10 digits!"
            );

            return;
        }

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(
                name,
                email,
                phone,
                address
        );

        customerDAO.addCustomer(customer);

        System.out.println("Customer added successfully!");
        System.out.println("Customer ID: " + customer.getCustomerId());
    }

    
    // VIEW CUSTOMER
   

    public static void viewCustomer() {

        System.out.println("\n----- View Customer -----");

        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerDAO.getCustomer(id);

        if (customer != null) {

            System.out.println("\nCustomer Details");
            System.out.println("-------------------------");
            System.out.println("ID      : " + customer.getCustomerId());
            System.out.println("Name    : " + customer.getName());
            System.out.println("Email   : " + customer.getEmail());
            System.out.println("Phone   : " + customer.getPhone());
            System.out.println("Address : " + customer.getAddress());

        } else {
            System.out.println("Customer not found!");
        }
    }

    
    // VIEW ALL CUSTOMERS
    

    public static void viewAllCustomers() {

        System.out.println("\n----- All Customers -----");

        List<Customer> customers = customerDAO.getAllCustomers();

        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }

        for (Customer customer : customers) {

            System.out.println("-------------------------");
            System.out.println("ID      : " + customer.getCustomerId());
            System.out.println("Name    : " + customer.getName());
            System.out.println("Email   : " + customer.getEmail());
            System.out.println("Phone   : " + customer.getPhone());
            System.out.println("Address : " + customer.getAddress());
        }
    }

    
    // UPDATE CUSTOMER
    

    public static void updateCustomer() {

        System.out.println("\n----- Update Customer -----");

        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerDAO.getCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter New Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter New Address: ");
        String address = scanner.nextLine();

        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);

        customerDAO.updateCustomer(customer);

        System.out.println("Customer updated successfully!");
    }

    
    // DELETE CUSTOMER
    

    public static void deleteCustomer() {

        System.out.println("\n----- Delete Customer -----");

        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerDAO.getCustomer(id);

        if (customer == null) {
            System.out.println("Customer not found!");
            return;
        }

        customerDAO.deleteCustomer(id);

        System.out.println("Customer deleted successfully!");}
     
     // HOTEL MENU
     

     public static void hotelMenu() {

         while (true) {

             System.out.println("\n=================================");
             System.out.println("          HOTEL MANAGEMENT");
             System.out.println("=================================");
             System.out.println("1. Add Hotel");
             System.out.println("2. View Hotel");
             System.out.println("3. View All Hotels");
             System.out.println("4. Update Hotel");
             System.out.println("5. Delete Hotel");
             System.out.println("6. Back");

             System.out.print("Enter your choice: ");
             int choice = Integer.parseInt(scanner.nextLine());

             switch (choice) {

                 case 1:
                     addHotel();
                     break;

                 case 2:
                     viewHotel();
                     break;

                 case 3:
                     viewAllHotels();
                     break;

                 case 4:
                     updateHotel();
                     break;

                 case 5:
                     deleteHotel();
                     break;

                 case 6:
                     return;

                 default:
                     System.out.println("Invalid choice!");
             }
         }
     }
  
  // ADD HOTEL
  

  public static void addHotel() {

      System.out.println("\n----- Add Hotel -----");

      System.out.print("Enter Hotel Name: ");
      String name = scanner.nextLine();

      System.out.print("Enter Location: ");
      String location = scanner.nextLine();

      System.out.print("Enter Phone: ");
      String phone = scanner.nextLine();

      Hotel hotel = new Hotel(
              name,
              location,
              phone
      );

      hotelDAO.addHotel(hotel);

      System.out.println("Hotel added successfully!");
      System.out.println("Hotel ID: " + hotel.getHotelId());
  }

//VIEW HOTEL


public static void viewHotel() {

   System.out.println("\n----- View Hotel -----");

   System.out.print("Enter Hotel ID: ");
   int id = Integer.parseInt(scanner.nextLine());

   Hotel hotel = hotelDAO.getHotel(id);

   if (hotel != null) {

       System.out.println("\nHotel Details");
       System.out.println("-------------------------");
       System.out.println("ID       : " + hotel.getHotelId());
       System.out.println("Name     : " + hotel.getName());
       System.out.println("Location : " + hotel.getLocation());
       System.out.println("Phone    : " + hotel.getPhone());

   } else {

       System.out.println("Hotel not found!");
   }
}

//VIEW ALL HOTELS


public static void viewAllHotels() {

 System.out.println("\n----- All Hotels -----");

 List<Hotel> hotels = hotelDAO.getAllHotels();

 if (hotels == null || hotels.isEmpty()) {

     System.out.println("No hotels found!");
     return;
 }

 for (Hotel hotel : hotels) {

     System.out.println("-------------------------");
     System.out.println("ID       : " + hotel.getHotelId());
     System.out.println("Name     : " + hotel.getName());
     System.out.println("Location : " + hotel.getLocation());
     System.out.println("Phone    : " + hotel.getPhone());
 }
}
     

//UPDATE HOTEL


public static void updateHotel() {

 System.out.println("\n----- Update Hotel -----");

 System.out.print("Enter Hotel ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Hotel hotel = hotelDAO.getHotel(id);

 if (hotel == null) {

     System.out.println("Hotel not found!");
     return;
 }

 System.out.print("Enter New Hotel Name: ");
 String name = scanner.nextLine();

 System.out.print("Enter New Location: ");
 String location = scanner.nextLine();

 System.out.print("Enter New Phone: ");
 String phone = scanner.nextLine();

 hotel.setName(name);
 hotel.setLocation(location);
 hotel.setPhone(phone);

 hotelDAO.updateHotel(hotel);

 System.out.println("Hotel updated successfully!");
}

//DELETE HOTEL


public static void deleteHotel() {

 System.out.println("\n----- Delete Hotel -----");

 System.out.print("Enter Hotel ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Hotel hotel = hotelDAO.getHotel(id);

 if (hotel == null) {

     System.out.println("Hotel not found!");
     return;
 }

 hotelDAO.deleteHotel(id);

 System.out.println("Hotel deleted successfully!");
}

//ROOM MENU


public static void roomMenu() {

 while (true) {

     System.out.println("\n=================================");
     System.out.println("          ROOM MANAGEMENT");
     System.out.println("=================================");
     System.out.println("1. Add Room");
     System.out.println("2. View Room");
     System.out.println("3. View All Rooms");
     System.out.println("4. Update Room");
     System.out.println("5. Delete Room");
     System.out.println("6. Back");

     System.out.print("Enter your choice: ");
     int choice = Integer.parseInt(scanner.nextLine());

     switch (choice) {

         case 1:
             addRoom();
             break;

         case 2:
             viewRoom();
             break;

         case 3:
             viewAllRooms();
             break;

         case 4:
             updateRoom();
             break;

         case 5:
             deleteRoom();
             break;

         case 6:
             return;

         default:
             System.out.println("Invalid choice!");
     }
 }
}

//ADD ROOM


public static void addRoom() {

 System.out.println("\n----- Add Room -----");

 System.out.print("Enter Hotel ID: ");
 int hotelId = Integer.parseInt(scanner.nextLine());

 Hotel hotel = hotelDAO.getHotel(hotelId);

 if (hotel == null) {
     System.out.println("Hotel not found!");
     return;
 }

 System.out.print("Enter Room Number: ");
 String roomNumber = scanner.nextLine();
 if (roomNumber.trim().isEmpty()) {

	    System.out.println("Room number cannot be empty!");
	    return;
	}
 
 System.out.print("Enter Room Type: ");
 String roomType = scanner.nextLine();

 System.out.print("Enter Room Price: ");
 double price = Double.parseDouble(scanner.nextLine());
 if (price <= 0) {

	    System.out.println(
	            "Room price must be greater than 0!"
	    );

	    return;
	}
 
 String status = "Available";

 Room room = new Room(
         roomNumber,
         roomType,
         price,
         status,
         hotel
 );

 roomDAO.addRoom(room);

 System.out.println("Room added successfully!");
 System.out.println("Room ID: " + room.getRoomId());
}

//VIEW ROOM


public static void viewRoom() {

 System.out.println("\n----- View Room -----");

 System.out.print("Enter Room ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Room room = roomDAO.getRoom(id);

 if (room != null) {

     System.out.println("\nRoom Details");
     System.out.println("-------------------------");
     System.out.println("Room ID     : " + room.getRoomId());
     System.out.println("Room Number : " + room.getRoomNumber());
     System.out.println("Room Type   : " + room.getRoomType());
     System.out.println("Price       : " + room.getPrice());
     System.out.println("Status      : " + room.getStatus());

     if (room.getHotel() != null) {
         System.out.println(
             "Hotel       : " + room.getHotel().getName()
         );
     }

 } else {

     System.out.println("Room not found!");
 }
}

//VIEW ALL ROOMS


public static void viewAllRooms() {

 System.out.println("\n----- All Rooms -----");

 List<Room> rooms = roomDAO.getAllRooms();

 if (rooms == null || rooms.isEmpty()) {

     System.out.println("No rooms found!");
     return;
 }

 for (Room room : rooms) {

     System.out.println("-------------------------");
     System.out.println("Room ID     : " + room.getRoomId());
     System.out.println("Room Number : " + room.getRoomNumber());
     System.out.println("Room Type   : " + room.getRoomType());
     System.out.println("Price       : " + room.getPrice());
     System.out.println("Status      : " + room.getStatus());

     if (room.getHotel() != null) {
         System.out.println(
             "Hotel       : " + room.getHotel().getName()
         );
     }
 }
}

//UPDATE ROOM


public static void updateRoom() {

 System.out.println("\n----- Update Room -----");

 System.out.print("Enter Room ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Room room = roomDAO.getRoom(id);

 if (room == null) {

     System.out.println("Room not found!");
     return;
 }

 System.out.print("Enter New Room Number: ");
 String roomNumber = scanner.nextLine();

 System.out.print("Enter New Room Type: ");
 String roomType = scanner.nextLine();

 System.out.print("Enter New Price: ");
 double price = Double.parseDouble(scanner.nextLine());

 System.out.print("Enter New Status (Available/Booked): ");
 String status = scanner.nextLine();

 room.setRoomNumber(roomNumber);
 room.setRoomType(roomType);
 room.setPrice(price);
 room.setStatus(status);

 roomDAO.updateRoom(room);

 System.out.println("Room updated successfully!");
}

//DELETE ROOM


public static void deleteRoom() {

 System.out.println("\n----- Delete Room -----");

 System.out.print("Enter Room ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Room room = roomDAO.getRoom(id);
 if (room.getStatus().equalsIgnoreCase("Booked")) {

	    System.out.println(
	            "Cannot delete a booked room!"
	    );

	    return;
	}
 if (room == null) {

     System.out.println("Room not found!");
     return;
 }

 roomDAO.deleteRoom(id);

 System.out.println("Room deleted successfully!");
}


//BOOKING MENU


public static void bookingMenu() {

 while (true) {

     System.out.println("\n=================================");
     System.out.println("        BOOKING MANAGEMENT");
     System.out.println("=================================");
     System.out.println("1. Add Booking");
     System.out.println("2. View Booking");
     System.out.println("3. View All Bookings");
     System.out.println("4. Update Booking");
     System.out.println("5. Delete Booking");
     System.out.println("6. Back");

     System.out.print("Enter your choice: ");
     int choice = Integer.parseInt(scanner.nextLine());

     switch (choice) {

         case 1:
             addBooking();
             break;

         case 2:
             viewBooking();
             break;

         case 3:
             viewAllBookings();
             break;

         case 4:
             updateBooking();
             break;

         case 5:
             deleteBooking();
             break;

         case 6:
             return;

         default:
             System.out.println("Invalid choice!");
     }
 }
}


//ADD BOOKING


public static void addBooking() {

 System.out.println("\n----- Add Booking -----");

 // Customer
 System.out.print("Enter Customer ID: ");
 int customerId = Integer.parseInt(scanner.nextLine());

 Customer customer = customerDAO.getCustomer(customerId);

 if (customer == null) {
     System.out.println("Customer not found!");
     return;
 }

 // Room
 System.out.print("Enter Room ID: ");
 int roomId = Integer.parseInt(scanner.nextLine());

 Room room = roomDAO.getRoom(roomId);

 if (room == null) {
     System.out.println("Room not found!");
     return;
 }

 // Check room availability
 if (!room.getStatus().equalsIgnoreCase("Available")) {

     System.out.println("Room is not available!");
     System.out.println("Current Status: " + room.getStatus());

     return;
 }

 // Check-in
 System.out.print("Enter Check-In Date (YYYY-MM-DD): ");
 LocalDate checkIn =
	        LocalDate.parse(scanner.nextLine());

	if (checkIn.isBefore(LocalDate.now())) {

	    System.out.println(
	            "Check-in date cannot be in the past!"
	    );

	    return;
	}

 // Check-out
 System.out.print("Enter Check-Out Date (YYYY-MM-DD): ");
 LocalDate checkOut =
         LocalDate.parse(scanner.nextLine());

 // Validate dates
 if (!checkOut.isAfter(checkIn)) {

     System.out.println(
             "Check-out date must be after check-in date!"
     );

     return;
 }

 Booking booking = new Booking(
         checkIn,
         checkOut,
         customer,
         room
 );

 bookingDAO.addBooking(booking);

 // Change room status
 room.setStatus("Booked");
 roomDAO.updateRoom(room);

 System.out.println("Booking added successfully!");
 System.out.println("Booking ID: " + booking.getBookingId());
}


//VIEW BOOKING


public static void viewBooking() {

 System.out.println("\n----- View Booking -----");

 System.out.print("Enter Booking ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Booking booking = bookingDAO.getBooking(id);

 if (booking != null) {

     System.out.println("\nBooking Details");
     System.out.println("-------------------------");

     System.out.println(
             "Booking ID : " + booking.getBookingId()
     );

     System.out.println(
             "Check-In   : " + booking.getCheckIn()
     );

     System.out.println(
             "Check-Out  : " + booking.getCheckOut()
     );

     if (booking.getCustomer() != null) {

         System.out.println(
                 "Customer   : "
                 + booking.getCustomer().getName()
         );
     }

     if (booking.getRoom() != null) {

         System.out.println(
                 "Room       : "
                 + booking.getRoom().getRoomNumber()
         );

         System.out.println(
                 "Room Type  : "
                 + booking.getRoom().getRoomType()
         );
     }

 } else {

     System.out.println("Booking not found!");
 }
}


//VIEW ALL BOOKINGS


public static void viewAllBookings() {

 System.out.println("\n----- All Bookings -----");

 List<Booking> bookings =
         bookingDAO.getAllBookings();

 if (bookings == null || bookings.isEmpty()) {

     System.out.println("No bookings found!");
     return;
 }

 for (Booking booking : bookings) {

     System.out.println("-------------------------");

     System.out.println(
             "Booking ID : "
             + booking.getBookingId()
     );

     System.out.println(
             "Check-In   : "
             + booking.getCheckIn()
     );

     System.out.println(
             "Check-Out  : "
             + booking.getCheckOut()
     );

     if (booking.getCustomer() != null) {

         System.out.println(
                 "Customer   : "
                 + booking.getCustomer().getName()
         );
     }

     if (booking.getRoom() != null) {

         System.out.println(
                 "Room       : "
                 + booking.getRoom().getRoomNumber()
         );
     }
 }
}


//UPDATE BOOKING


public static void updateBooking() {

 System.out.println("\n----- Update Booking -----");

 System.out.print("Enter Booking ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Booking booking = bookingDAO.getBooking(id);

 if (booking == null) {

     System.out.println("Booking not found!");
     return;
 }

 System.out.print("Enter New Check-In Date (YYYY-MM-DD): ");
 LocalDate checkIn =
         LocalDate.parse(scanner.nextLine());

 System.out.print("Enter New Check-Out Date (YYYY-MM-DD): ");
 LocalDate checkOut =
         LocalDate.parse(scanner.nextLine());

 if (!checkOut.isAfter(checkIn)) {

     System.out.println(
             "Check-out date must be after check-in date!"
     );

     return;
 }

 booking.setCheckIn(checkIn);
 booking.setCheckOut(checkOut);

 bookingDAO.updateBooking(booking);

 System.out.println("Booking updated successfully!");
}


//DELETE BOOKING


public static void deleteBooking() {

 System.out.println("\n----- Delete Booking -----");

 System.out.print("Enter Booking ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Booking booking = bookingDAO.getBooking(id);

 if (booking == null) {

     System.out.println("Booking not found!");
     return;
 }

 Room room = booking.getRoom();

 bookingDAO.deleteBooking(id);

 // Make room available again
 if (room != null) {

     room.setStatus("Available");

     roomDAO.updateRoom(room);
 }

 System.out.println("Booking deleted successfully!");
}


//PAYMENT MENU


public static void paymentMenu() {

 while (true) {

     System.out.println("\n=================================");
     System.out.println("        PAYMENT MANAGEMENT");
     System.out.println("=================================");
     System.out.println("1. Add Payment");
     System.out.println("2. View Payment");
     System.out.println("3. View All Payments");
     System.out.println("4. Update Payment");
     System.out.println("5. Delete Payment");
     System.out.println("6. Back");

     System.out.print("Enter your choice: ");
     int choice = Integer.parseInt(scanner.nextLine());

     switch (choice) {

         case 1:
             addPayment();
             break;

         case 2:
             viewPayment();
             break;

         case 3:
             viewAllPayments();
             break;

         case 4:
             updatePayment();
             break;

         case 5:
             deletePayment();
             break;

         case 6:
             return;

         default:
             System.out.println("Invalid choice!");
     }
 }
}

//ADD PAYMENT


public static void addPayment() {

 System.out.println("\n----- Add Payment -----");

 System.out.print("Enter Booking ID: ");
 int bookingId = Integer.parseInt(scanner.nextLine());

 Booking booking = bookingDAO.getBooking(bookingId);

 if (booking == null) {

     System.out.println("Booking not found!");
     return;
 }

 System.out.print("Enter Payment Amount: ");
 double amount = Double.parseDouble(scanner.nextLine());

 if (amount <= 0) {

     System.out.println("Payment amount must be greater than 0!");
     return;
 }

 System.out.print("Enter Payment Method: ");
 String paymentMethod = scanner.nextLine();
 if (paymentMethod.trim().isEmpty()) {

	    System.out.println(
	            "Payment method cannot be empty!"
	    );

	    return;
	}
 
 LocalDate paymentDate = LocalDate.now();
 
 
 Payment payment = new Payment(
         amount,
         paymentDate,
         paymentMethod,
         booking
 );

 paymentDAO.addPayment(payment);

 System.out.println("Payment added successfully!");
 System.out.println("Payment ID: " + payment.getPaymentId());
}


//VIEW PAYMENT


public static void viewPayment() {

 System.out.println("\n----- View Payment -----");

 System.out.print("Enter Payment ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Payment payment = paymentDAO.getPayment(id);

 if (payment != null) {

     System.out.println("\nPayment Details");
     System.out.println("-------------------------");

     System.out.println(
             "Payment ID     : "
             + payment.getPaymentId()
     );

     System.out.println(
             "Amount         : "
             + payment.getAmount()
     );

     System.out.println(
             "Payment Date   : "
             + payment.getPaymentDate()
     );

     System.out.println(
             "Payment Method : "
             + payment.getPaymentMethod()
     );

     if (payment.getBooking() != null) {

         System.out.println(
                 "Booking ID     : "
                 + payment.getBooking().getBookingId()
         );
     }

 } else {

     System.out.println("Payment not found!");
 }
}


//VIEW ALL PAYMENTS


public static void viewAllPayments() {

 System.out.println("\n----- All Payments -----");

 List<Payment> payments =
         paymentDAO.getAllPayments();

 if (payments == null || payments.isEmpty()) {

     System.out.println("No payments found!");
     return;
 }

 for (Payment payment : payments) {

     System.out.println("-------------------------");

     System.out.println(
             "Payment ID     : "
             + payment.getPaymentId()
     );

     System.out.println(
             "Amount         : "
             + payment.getAmount()
     );

     System.out.println(
             "Payment Date   : "
             + payment.getPaymentDate()
     );

     System.out.println(
             "Payment Method : "
             + payment.getPaymentMethod()
     );

     if (payment.getBooking() != null) {

         System.out.println(
                 "Booking ID     : "
                 + payment.getBooking().getBookingId()
         );
     }
 }
}


//UPDATE PAYMENT


public static void updatePayment() {

 System.out.println("\n----- Update Payment -----");

 System.out.print("Enter Payment ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Payment payment = paymentDAO.getPayment(id);

 if (payment == null) {

     System.out.println("Payment not found!");
     return;
 }

 System.out.print("Enter New Amount: ");
 double amount = Double.parseDouble(scanner.nextLine());

 if (amount <= 0) {

     System.out.println(
             "Payment amount must be greater than 0!"
     );

     return;
 }

 System.out.print("Enter New Payment Method: ");
 String paymentMethod = scanner.nextLine();

 payment.setAmount(amount);
 payment.setPaymentMethod(paymentMethod);

 paymentDAO.updatePayment(payment);

 System.out.println("Payment updated successfully!");
}


//DELETE PAYMENT


public static void deletePayment() {

 System.out.println("\n----- Delete Payment -----");

 System.out.print("Enter Payment ID: ");
 int id = Integer.parseInt(scanner.nextLine());

 Payment payment = paymentDAO.getPayment(id);

 if (payment == null) {

     System.out.println("Payment not found!");
     return;
 }

 paymentDAO.deletePayment(id);

 System.out.println("Payment deleted successfully!");
}



	
}

