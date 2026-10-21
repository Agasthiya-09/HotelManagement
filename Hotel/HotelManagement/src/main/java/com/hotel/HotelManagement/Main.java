package com.hotel.HotelManagement;

import java.util.List;

import com.hotel.dao.CustomerDAO;
import com.hotel.entity.Customer;

public class Main {
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
       /*
        // CREATE
        Customer customer = new Customer(
                "Rahul",
                "rahul@gmail.com",
                "9876543210",
                "Chennai"
        );

        customerDAO.addCustomer(customer);


        // READ - Single Customer
        Customer result =
                customerDAO.getCustomer(1);

        if (result != null) {

            System.out.println(
                    "Customer Name: "
                    + result.getName());

            System.out.println(
                    "Email: "
                    + result.getEmail());
        }


        // READ - All Customers
        List<Customer> customers =
                customerDAO.getAllCustomers();

        for (Customer c : customers) {

            System.out.println(
                    c.getCustomerId()
                    + " "
                    + c.getName()
                    + " "
                    + c.getEmail());
        }
        //update
        Customer updateCustomer =
                customerDAO.getCustomer(1);

        if (updateCustomer != null) {

            updateCustomer.setName("Rahul Kumar");

            updateCustomer.setPhone("9999999999");

            customerDAO.updateCustomer(updateCustomer);
        }*/
        //customerDAO.deleteCustomer(4);
    }
}
