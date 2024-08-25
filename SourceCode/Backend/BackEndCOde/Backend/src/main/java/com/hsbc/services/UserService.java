package com.hsbc.services;

import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.List;

public interface UserService {
    List<Booking> viewUserMeetings(int userId) throws UserNotFoundException;
    User getUserById(int userId) throws UserNotFoundException;
}