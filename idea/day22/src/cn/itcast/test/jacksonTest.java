package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class jacksonTest {


    //java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
         //创建Person对象
        Person person=new Person();
        person.setAge(18);
        person.setName("张三");
        person.setGender("男");
        //创建Jackson的核心对象 objectMapper

        ObjectMapper mapper=new ObjectMapper();
        //3.转换
        /*
           转换方法：
                 writeValue(参数1，obj)：
                            参数1：
                                File:将obj对象转换为JSON字符串，并保存到指定的文件中
                                Writer：将obj对象转换为JSON字符串，并将JSON数据填充到字符输出流中
                                outputstream：将obj对象转换为JSON字符串，并保存到指定的字符输出流中
                 writeValueString(obj),将对象转化为json字符串

         */
        //writeValueString(obj)
        String s = mapper.writeValueAsString(person);
        //{"name":"张三","age":18,"gender":"男"}
        //System.out.println(s);

        //writeValue，将数据写到d://a.txt
        mapper.writeValue(new File("d://a.txt"), person);
        //writeValue，将数据写到Writer
        mapper.writeValue(new FileWriter("d://b.txt"), person);
    }


    @Test
    public void test2() throws JsonProcessingException {

        //创建Person对象
        Person person=new Person();
        person.setAge(18);
        person.setName("张三");
        person.setGender("男");
        person.setBirthday(new Date());



        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(person);
        System.out.println(s);

    }

    @Test
    public void test3() throws JsonProcessingException {

        //创建Person对象
        Person p1=new Person();
        p1.setAge(18);
        p1.setName("张三");
        p1.setGender("男");
        p1.setBirthday(new Date());


        Person p2=new Person();
        p2.setAge(18);
        p2.setName("张三");
        p2.setGender("男");
        p2.setBirthday(new Date());


        Person p3=new Person();
        p3.setAge(18);
        p3.setName("张三");
        p3.setGender("男");
        p3.setBirthday(new Date());

        //创建list集合
        List<Person> list=new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);

    }

    @Test
    public void test4() throws JsonProcessingException {

        //创建map集合
        Map map=new HashMap();
        map.put("name", "张三");
        map.put("age","18");
        map.put("gender","男");

        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(map);
        System.out.println(s);

    }
   //json字符串转化为java对象
    @Test
    public void test5() throws IOException {

        String json="{\"gender\":\"男\",\"name\":\"张三\",\"age\":\"18\"}";



     ObjectMapper  mapper=new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);

    }
}
