package com.hsbc.Dao;

import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface UserDao {


    public List<Booking> viewUserMeetings(int userId) throws UserNotFoundException;


    public User getUserById(int userId) throws UserNotFoundException;
}