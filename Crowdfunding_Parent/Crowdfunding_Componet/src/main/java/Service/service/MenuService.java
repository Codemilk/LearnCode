package Service.service;

import CrowedFunding_Entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author lenovo
 */
public interface MenuService {

    public List<Menu>  getAll();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(Integer id);
}
