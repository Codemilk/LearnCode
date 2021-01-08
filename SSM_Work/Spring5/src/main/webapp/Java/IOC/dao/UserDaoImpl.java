package IOC.dao;

import org.springframework.stereotype.Repository;

@Repository("dd")
public class UserDaoImpl implements UserDao{

    @Override
    public void update() {
        System.out.println("IOC.dao update");
    }

}

