package com.ConverterSpringMvcTest;

import com.SpringCRUD.Dao.Department;
import com.SpringCRUD.Dao.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SpringConversion implements Converter<String, Employee> {
    @Override
    public Employee convert(String s) {
//        GG-gg@qq.com-0-105

        if (s != null) {
            String[] val = s.split("-");

            if (val != null && val.length == 4) {

                String name = val[0];
                String email = val[1];
                Integer gender = Integer.parseInt(val[2]);
                Department department = new Department();
                department.setId(Integer.parseInt(val[3]));
                Employee employee = new Employee(null, name, email, gender, department);
                return employee;
            }
        }

        return  null;
    }
}
