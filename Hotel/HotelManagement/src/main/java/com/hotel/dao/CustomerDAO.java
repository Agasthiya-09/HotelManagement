package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entity.Customer;
import com.hotel.util.HibernateUtil;

public class CustomerDAO {
	//add
	 public void addCustomer(Customer customer) {

	        Transaction transaction = null;

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            transaction = session.beginTransaction();

	            session.persist(customer);

	            transaction.commit();

	            System.out.println("Customer added successfully");

	        } catch (Exception e) {

	            if (transaction != null) {
	                transaction.rollback();
	            }

	            e.printStackTrace();
	        }
	    }
	 //get-single customer
	 public Customer getCustomer(int customerId) {

		    try (Session session =
		            HibernateUtil.getSessionFactory().openSession()) {

		        Customer customer =
		                session.get(Customer.class, customerId);

		        return customer;

		    } catch (Exception e) {

		        e.printStackTrace();
		        return null;
		    }
		}
	 //get all customer
	 public List<Customer> getAllCustomers() {

		    try (Session session =
		            HibernateUtil.getSessionFactory().openSession()) {

		        return session
		                .createQuery("from Customer", Customer.class)
		                .getResultList();

		    } catch (Exception e) {

		        e.printStackTrace();
		        return null;
		    }
		}
	 //update
	 public void updateCustomer(Customer customer) {

		    Transaction transaction = null;

		    try (Session session =
		            HibernateUtil.getSessionFactory().openSession()) {

		        transaction = session.beginTransaction();

		        session.merge(customer);

		        transaction.commit();

		        System.out.println("Customer updated successfully");

		    } catch (Exception e) {

		        if (transaction != null) {
		            transaction.rollback();
		        }

		        e.printStackTrace();
		    }
		}
	 //delete
	 public void deleteCustomer(int customerId) {

		    Transaction transaction = null;

		    try (Session session =
		            HibernateUtil.getSessionFactory().openSession()) {

		        transaction = session.beginTransaction();

		        Customer customer =
		                session.get(Customer.class, customerId);

		        if (customer != null) {

		            session.remove(customer);

		            System.out.println(
		                    "Customer deleted successfully");

		        } else {

		            System.out.println("Customer not found");
		        }

		        transaction.commit();

		    } catch (Exception e) {

		        if (transaction != null) {
		            transaction.rollback();
		        }

		        e.printStackTrace();
		    }
		}
}
