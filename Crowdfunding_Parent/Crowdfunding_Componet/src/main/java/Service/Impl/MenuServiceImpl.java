package Service.Impl;

import CrowedFunding_Entity.Menu;
import CrowedFunding_Entity.MenuExample;
import Mapper.MenuMapper;
import Service.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {

        MenuExample menuExample=new MenuExample();

        List<Menu> menus = menuMapper.selectByExample(menuExample);

        return menus;
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insertSelective(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
