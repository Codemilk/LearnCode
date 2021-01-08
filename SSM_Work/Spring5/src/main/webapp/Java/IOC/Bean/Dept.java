package IOC.Bean;

import org.springframework.stereotype.Component;

@Component
public class Dept {

    private String Dname;

    public String getDname() {
        return Dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "Dname='" + Dname + '\'' +
                '}';
    }

    public void setDname(String dname) {
        Dname = dname;
    }
}
