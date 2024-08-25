package com.hsbc.services;

import com.hsbc.Dao.AdminDao;
import com.hsbc.Dao.AdminDaoImpl;
import com.hsbc.exceptions.*;
import com.hsbc.model.Amenity;
import com.hsbc.model.Booking;
import com.hsbc.model.MeetingRoom;
import com.hsbc.model.User;

import java.util.List;

public class AdminServiceImpl implements AdminService{
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public boolean addUser(User user) throws UserAlreadyExistsException {
        return dao.createUser(user);
    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {
        return dao.getUserById(userId);
    }

    @Override
    public boolean updateUser(User user) throws UserNotFoundException {
        return dao.updateUser(user);
    }

    @Override
    public boolean removeUser(int userId) throws UserNotFoundException {
        return dao.deleteUser(userId);
    }

    @Override
    public List<User> getAllMemebrs() {
        return dao.getAllUsers();
    }

    @Override
    public boolean createAmenity(Amenity amenity) {
        return dao.createAmenity(amenity);
    }

    @Override
    public Amenity getAmenityById(int amenityId) {
        return dao.getAmenityById(amenityId);
    }

    @Override
    public boolean updateAmenity(Amenity amenity) {
        return dao.updateAmenity(amenity);
    }

    @Override
    public boolean RemoveAmenity(int amenityId) {
        return dao.deleteAmenity(amenityId);
    }

    @Override
    public List<Amenity> getAllAmenities() {
        return dao.getAllAmenities();
    }

    @Override
    public boolean makeMeetingRoom(MeetingRoom meetingRoom) throws ConnectionFailedException {
        return dao.createMeetingRoom(meetingRoom);
    }

    @Override
    public MeetingRoom getMeetingRoomById(int roomId) throws MeetingNotFoundException {
        return dao.getMeetingRoomById(roomId);
    }

    @Override
    public boolean updateMeetingRoom(MeetingRoom meetingRoom) throws MeetingNotFoundException{
        return dao.updateMeetingRoom(meetingRoom);
    }

    @Override
    public boolean deleteMeetingRoom(int roomId) throws MeetingNotFoundException{
        return dao.deleteMeetingRoom(roomId);
    }

    @Override
    public List<MeetingRoom> getAllMeetingRooms() throws ConnectionFailedException {
        return dao.getAllMeetingRooms();
    }

    @Override
    public List<Booking> getBookingDetails() throws BookingNotFound {
        return dao.getBookingDetails();
    }


}
