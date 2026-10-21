package com.hotel.HotelManagement;

import java.util.List;

import com.hotel.dao.HotelDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.entity.Hotel;
import com.hotel.entity.Room;


public class roommain {

	public static void main(String[] args) {
        //HotelDAO hotelDAO = new HotelDAO();
        RoomDAO roomDAO = new RoomDAO();
/*
        // Create Hotel
        Hotel hotel = new Hotel(
                "Green Park Hotel",
                "Chennai",
                "0441234567"
        );

        hotelDAO.addHotel(hotel);

        // Create Room
        Room room = new Room("101","Single",1500.00,"Available",hotel);
        Room room1 = new Room(
                "102",
                "Double",
                2500,
                "Available",
                hotel
        );

        Room room2 = new Room(
                "103",
                "Deluxe",
                3500,
                "Available",
                hotel
        );

        roomDAO.addRoom(room);
        roomDAO.addRoom(room1);
        roomDAO.addRoom(room2);

        System.out.println(
                "Room ID: " + room.getRoomId());
        
*/
        //get one room details
        /*
        Room room = roomDAO.getRoom(1);

        if (room != null) {

            System.out.println(
                    "Room Number: "
                    + room.getRoomNumber());

            System.out.println(
                    "Room Type: "
                    + room.getRoomType());

            System.out.println(
                    "Price: "
                    + room.getPrice());

            System.out.println(
                    "Status: "
                    + room.getStatus());
        }*/
        //get all rooms
        List<Room> rooms = roomDAO.getAllRooms();

        for (Room r : rooms) {

            System.out.println(
                    r.getRoomId()
                    + " "
                    + r.getRoomNumber()
                    + " "
                    + r.getRoomType()
                    + " "
                    + r.getPrice()
                    + " "
                    + r.getStatus());
        }
	}

}
