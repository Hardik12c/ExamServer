package com.exam.examserver.service;

import com.exam.examserver.models.User;

import java.util.List;


public interface UserService {
    public List<User> findallusers();
    public User createUser(User user) throws Exception;

    public User finduserbyemail(String email) throws Exception;

    public String deleteuserbyemail(String email) ;
}
