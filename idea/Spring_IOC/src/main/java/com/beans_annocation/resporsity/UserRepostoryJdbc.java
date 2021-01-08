package com.beans_annocation.resporsity;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepostoryJdbc implements UserRepostory{


    @Override
    public void save() {
        System.out.println("UserRepostoryJdbc save");


    }
}
