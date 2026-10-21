package com.hotel.HotelManagement;

import com.hotel.dao.HotelDAO;
import com.hotel.entity.Hotel;

public class hotelmain {

	public static void main(String[] args) {
		HotelDAO hotelDAO = new HotelDAO();

        Hotel hotel = new Hotel(
                "Green Park Hotel",
                "Chennai",
                "0441234567"
        );

        hotelDAO.addHotel(hotel);

        System.out.println(
                "Hotel ID: "
                + hotel.getHotelId());

	}

}
