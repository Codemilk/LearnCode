package com.beans_annocation.resporsity.service;


import com.beans_annocation.resporsity.UserRepostory;
import com.beans_annocation.resporsity.UserRepostoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
     private UserRepostory userRepostory;

    @Autowired
    /*@Qualifier("userRepostoryJdbc")*/
    public void setUserRepostory( @Qualifier("userRepostoryJdbc")UserRepostory userRepostory) {
        this.userRepostory = userRepostory;
    }

    public void add(){
        System.out.println("UserService add ......");
        userRepostory.save();
    }
}
