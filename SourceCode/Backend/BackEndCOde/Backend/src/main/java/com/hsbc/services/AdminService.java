package com.hsbc.services;

import com.hsbc.exceptions.*;
import com.hsbc.model.Amenity;
import com.hsbc.model.Booking;
import com.hsbc.model.MeetingRoom;
import com.hsbc.model.User;

import java.util.List;

public interface AdminService {
    public boolean addUser(User user) throws UserAlreadyExistsException;
    public User findUserById(int userId) throws UserNotFoundException;
    public boolean updateUser(User user)throws UserNotFoundException;
    public boolean removeUser(int userId)throws UserNotFoundException;
    public List<User> getAllMemebrs();

    public boolean createAmenity(Amenity amenity);
    public Amenity getAmenityById(int amenityId);
    public boolean updateAmenity(Amenity amenity);
    public boolean RemoveAmenity(int amenityId);
    public List<Amenity> getAllAmenities();

    public boolean makeMeetingRoom(MeetingRoom meetingRoom) throws ConnectionFailedException;
    public MeetingRoom getMeetingRoomById(int roomId) throws MeetingNotFoundException;
    public boolean updateMeetingRoom(MeetingRoom meetingRoom) throws MeetingNotFoundException;
    public boolean deleteMeetingRoom(int roomId) throws MeetingNotFoundException;
    public List<MeetingRoom> getAllMeetingRooms() throws ConnectionFailedException;

    public List<Booking> getBookingDetails() throws BookingNotFound;
}
