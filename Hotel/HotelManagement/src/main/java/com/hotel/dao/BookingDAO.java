package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entity.Booking;
import com.hotel.util.HibernateUtil;

public class BookingDAO {
	// CREATE
    public void addBooking(Booking booking) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(booking);

            transaction.commit();

            System.out.println("Booking added successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ - Single Booking
    public Booking getBooking(int bookingId) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Booking.class, bookingId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ - All Bookings
    public List<Booking> getAllBookings() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery(
                            "from Booking",
                            Booking.class)
                    .getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateBooking(Booking booking) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(booking);

            transaction.commit();

            System.out.println(
                    "Booking updated successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteBooking(int bookingId) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Booking booking =
                    session.get(Booking.class, bookingId);

            if (booking != null) {

                session.remove(booking);

                System.out.println(
                        "Booking deleted successfully");

            } else {

                System.out.println(
                        "Booking not found");
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
