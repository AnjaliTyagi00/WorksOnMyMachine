package com.hsbc.Dao;

import com.hsbc.exceptions.*;
import com.hsbc.model.*;

import java.util.List;


public interface AdminDao {

    // CRUD Operations for User
    public boolean createUser(User user) throws UserAlreadyExistsException;
    public User getUserById(int userId) throws UserNotFoundException;
    public boolean updateUser(User user) throws UserNotFoundException;
    public boolean deleteUser(int userId) throws UserNotFoundException;
    public List<User> getAllUsers();

    // CRUD Operations for Amenity
    public boolean createAmenity(Amenity amenity);
    public Amenity getAmenityById(int amenityId);
    public boolean updateAmenity(Amenity amenity);
    public boolean deleteAmenity(int amenityId);
    public List<Amenity> getAllAmenities();

    // CRUD Operations for Meeting Room
    public boolean createMeetingRoom(MeetingRoom meetingRoom) throws ConnectionFailedException;
    public MeetingRoom getMeetingRoomById(int roomId) throws MeetingNotFoundException;
    public boolean updateMeetingRoom(MeetingRoom meetingRoom) throws MeetingNotFoundException;
    public boolean deleteMeetingRoom(int roomId) throws MeetingNotFoundException;
    public List<MeetingRoom> getAllMeetingRooms() throws ConnectionFailedException;

    // Get Booking and meeting Details
    public List<Booking> getBookingDetails() throws BookingNotFound;
    public Meeting getMeetingDetails(int MeetingId) throws MeetingNotFoundException;
}