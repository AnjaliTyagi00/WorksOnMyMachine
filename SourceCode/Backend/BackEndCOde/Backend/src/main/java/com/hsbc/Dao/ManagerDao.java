package com.hsbc.Dao;

import com.hsbc.exceptions.BookingNotFound;
import com.hsbc.exceptions.ConnectionFailedException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface ManagerDao {

    // Book a meeting room
    public boolean bookMeeting(Booking booking) throws ConnectionFailedException;

    // Add users to a meeting
    public boolean addUserToMeeting(int bookingId, int userId) throws UserNotFoundException;

    // Search users by name
    public List<User> searchUsers(String keyword) throws UserNotFoundException;

    // View all meetings booked by the manager
    public List<Booking> viewBookings(int managerId) throws BookingNotFound;

    // View details of a specific meeting
    public Booking getMeetingDetails(int bookingId) throws MeetingNotFoundException;

    public boolean validateAmenities(Booking booking);
}