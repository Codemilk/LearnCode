package Exception;

public class SonException {

    public static void main(String[] args) {

        try {
        new FatherException().add();
        }catch (Exception e){
            System.out.println("SonException");
            e.printStackTrace();
        }

    }
}
