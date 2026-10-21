package com.hotel.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Hotel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    private String name;
    private String location;
    private String phone;
 
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
    public Hotel() {
    }

    public Hotel(String name, String location, String phone) {

        this.name = name;
        this.location = location;
        this.phone = phone;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
