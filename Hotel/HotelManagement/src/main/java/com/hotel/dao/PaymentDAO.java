package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entity.Payment;
import com.hotel.util.HibernateUtil;

public class PaymentDAO {

	    // CREATE
	    public void addPayment(Payment payment) {

	        Transaction transaction = null;

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            transaction = session.beginTransaction();

	            session.persist(payment);

	            transaction.commit();

	            System.out.println(
	                    "Payment added successfully");

	        } catch (Exception e) {

	            if (transaction != null) {
	                transaction.rollback();
	            }

	            e.printStackTrace();
	        }
	    }

	    // READ - Single Payment
	    public Payment getPayment(int paymentId) {

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            return session.get(Payment.class, paymentId);

	        } catch (Exception e) {

	            e.printStackTrace();
	            return null;
	        }
	    }

	    // READ - All Payments
	    public List<Payment> getAllPayments() {

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            return session
	                    .createQuery(
	                            "from Payment",
	                            Payment.class)
	                    .getResultList();

	        } catch (Exception e) {

	            e.printStackTrace();
	            return null;
	        }
	    }

	    // UPDATE
	    public void updatePayment(Payment payment) {

	        Transaction transaction = null;

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            transaction = session.beginTransaction();

	            session.merge(payment);

	            transaction.commit();

	            System.out.println(
	                    "Payment updated successfully");

	        } catch (Exception e) {

	            if (transaction != null) {
	                transaction.rollback();
	            }

	            e.printStackTrace();
	        }
	    }

	    // DELETE
	    public void deletePayment(int paymentId) {

	        Transaction transaction = null;

	        try (Session session =
	                HibernateUtil.getSessionFactory().openSession()) {

	            transaction = session.beginTransaction();

	            Payment payment =
	                    session.get(Payment.class, paymentId);

	            if (payment != null) {

	                session.remove(payment);

	                System.out.println(
	                        "Payment deleted successfully");

	            } else {

	                System.out.println(
	                        "Payment not found");
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
