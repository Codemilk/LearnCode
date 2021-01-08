package com.beans_annocation.resporsity;


import com.beans_annocation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository/*("userRepostory")*/
public class UserRepostoryImpl implements UserRepostory {
    //代表这个自动装配允许获取不到

    @Autowired(required = false)
    private TestObject to;

    @Override
    public void save() {
        System.out.println("UserRepostory save ....");
        System.out.println(to);
    }
}
