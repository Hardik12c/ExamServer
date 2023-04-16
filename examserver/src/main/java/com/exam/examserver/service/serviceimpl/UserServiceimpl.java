package com.exam.examserver.service.serviceimpl;

import com.exam.examserver.service.UserService;
import com.exam.examserver.models.User;
import com.exam.examserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceimpl implements UserService {
    @Autowired
    public UserRepository userrepository;


    @Override
    public List<User> findallusers() {
        return userrepository.findAll();
    }

    @Override
    public User createUser(User user) throws Exception {
        User local=userrepository.findByEmail(user.getEmail());
        if(local!=null){
            throw new Exception("User already present");
        }else{
            local=userrepository.save(user);
            return local;
        }
    }

    @Override
    public User finduserbyemail(String email) throws Exception {
        User local=userrepository.findByEmail(email);
        if(local!=null){
            return local;
        }
        throw new Exception("User is not there");
    }

    @Override
    public String deleteuserbyemail(String email) {
        User local=userrepository.findByEmail(email);
        if(local!=null){
            userrepository.deleteById(local.getId());
            return "Data Deleted successfully";
        }
        return "Data Not present in database";
    }
}
