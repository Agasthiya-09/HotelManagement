package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entity.Hotel;
import com.hotel.util.HibernateUtil;

public class HotelDAO {
	 // CREATE
    public void addHotel(Hotel hotel) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(hotel);

            transaction.commit();

            System.out.println("Hotel added successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ
    public Hotel getHotel(int hotelId) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Hotel.class, hotelId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ ALL
    public List<Hotel> getAllHotels() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery(
                            "from Hotel",
                            Hotel.class)
                    .getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateHotel(Hotel hotel) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(hotel);

            transaction.commit();

            System.out.println("Hotel updated successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteHotel(int hotelId) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Hotel hotel =
                    session.get(Hotel.class, hotelId);

            if (hotel != null) {

                session.remove(hotel);

                System.out.println(
                        "Hotel deleted successfully");

            } else {

                System.out.println(
                        "Hotel not found");
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
