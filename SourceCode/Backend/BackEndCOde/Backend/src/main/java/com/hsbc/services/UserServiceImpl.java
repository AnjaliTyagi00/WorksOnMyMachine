package com.hsbc.services;

import com.hsbc.Dao.UserDao;
import com.hsbc.Dao.UserDaoImpl;
import com.hsbc.exceptions.UserNotFoundException;
import com.hsbc.model.Booking;
import com.hsbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Booking> viewUserMeetings(int userId) {
        List<Booking> meetings = new ArrayList<>();
        try {
            meetings= userDao.viewUserMeetings(userId);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return meetings;
    }


    @Override
    public User getUserById(int userId) {
        User user = null;
        try {
            user= userDao.getUserById(userId);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }
}