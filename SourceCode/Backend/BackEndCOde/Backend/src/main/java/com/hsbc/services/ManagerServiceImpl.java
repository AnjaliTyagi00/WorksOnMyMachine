package com.hsbc.services;

import com.hsbc.Dao.ManagerDao;
import com.hsbc.Dao.ManagerDaoImpl;
import com.hsbc.exceptions.BookingNotFound;
import com.hsbc.exceptions.ConnectionFailedException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;




public class ManagerServiceImpl implements ManagerService {

    private final ManagerDao managerDao;

    public ManagerServiceImpl() {
        this.managerDao = new ManagerDaoImpl();
    }

    @Override
    public boolean bookMeeting(Booking booking) {
        try {
            // Validate if the required amenities are available before booking
            if (!managerDao.validateAmenities(booking)) {
                System.out.println("Required amenities are not available for this booking.");
                return false;
            }

            // Proceed with booking
            return managerDao.bookMeeting(booking);
        }
        catch (ConnectionFailedException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addUserToMeeting(int bookingId, int userId) {
        try {
            return managerDao.addUserToMeeting(bookingId, userId);
        }
        catch ( UserNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<User> searchUsers(String keyword) {
        try {
            return managerDao.searchUsers(keyword);
        }
        catch (UserNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Booking> viewBookings(int managerId) {
        try {
            return managerDao.viewBookings(managerId);
        } catch (BookingNotFound e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Booking getMeetingDetails(int bookingId) {
        try {
            return managerDao.getMeetingDetails(bookingId);
        } catch (MeetingNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}