package com.hsbc.services;

import com.hsbc.exceptions.BookingNotFound;
import com.hsbc.exceptions.ConnectionFailedException;
import com.hsbc.exceptions.MeetingNotFoundException;
import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;



public interface ManagerService {

    // Book a meeting room
    boolean bookMeeting(Booking booking) throws ConnectionFailedException;

    // Add users to a meeting
    boolean addUserToMeeting(int bookingId, int userId)throws UserNotFoundException;

    // Search users by name
    List<User> searchUsers(String keyword) throws UserNotFoundException;

    // View all meetings booked by the manager
    List<Booking> viewBookings(int managerId) throws BookingNotFound;

    // View details of a specific meeting
    Booking getMeetingDetails(int bookingId) throws MeetingNotFoundException;
}
