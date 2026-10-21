package com.hotel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hotel.entity.Room;
import com.hotel.util.HibernateUtil;

public class RoomDAO {
	// CREATE
    public void addRoom(Room room) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(room);

            transaction.commit();

            System.out.println("Room added successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // READ
    public Room getRoom(int roomId) {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Room.class, roomId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // READ ALL
    public List<Room> getAllRooms() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery(
                            "from Room",
                            Room.class)
                    .getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // UPDATE
    public void updateRoom(Room room) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(room);

            transaction.commit();

            System.out.println("Room updated successfully");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteRoom(int roomId) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Room room =
                    session.get(Room.class, roomId);

            if (room != null) {

                session.remove(room);

                System.out.println(
                        "Room deleted successfully");

            } else {

                System.out.println(
                        "Room not found");
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
