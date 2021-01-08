import com.itcast.dao.ItemDao;
import com.itcast.dao.daoImpl.impl;
import com.itcast.domain.Item;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void test1() throws Exception {

        ItemDao itemDao=new impl();
        List<Item> items = itemDao.finAll();
        System.out.println(items);
    }
}
