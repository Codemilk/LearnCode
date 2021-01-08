package Rest.test;


import Rest.bean.Employee;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.nativesandbox.comm.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

//通过spring测试请求功能
@RunWith(SpringJUnit4ClassRunner.class)
//配上这个@WebAppConfiguration，就可以让webApplicationContext自动获取到Ioc容器本身
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:Spring.xml","classpath:SpringMVC.xml"})
public class mvc {
        @Autowired
        WebApplicationContext webApplicationContext;
        //虚拟MVC请求，获取到处理结果
        MockMvc mockMvc;

    @Before
    public void initMokcMVC(){
        mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求并获得返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();

        //请求成功，请求域拥有pageInfo

        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        //查看是否获取到了pageinfo
        System.out.println("当前页面"+pageInfo);
        //查看总页码
        System.out.println("总页码"+pageInfo.getPages());
        //查看总记录数
        System.out.println("总记录"+pageInfo.getTotal());

        System.out.println("当前页面需要连续显示的页码");

        int [] nums=pageInfo.getNavigatepageNums();

        for(int i:nums){
            System.out.println(i);
        }

//        员工数据

        List<Employee> list=pageInfo.getList();

        for(Employee e:list){

            System.out.println(e);

        }
    }
}
