package Test;

import java.net.URL;

public class tt {
    public static void main(String[] args) {

        URL resource = tt.class.getClassLoader().getResource("Test/a.txt");
        System.out.println(resource.getPath());

    }
}
