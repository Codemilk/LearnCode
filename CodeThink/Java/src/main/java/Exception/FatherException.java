package Exception;

public class FatherException {


    void add() throws Exception{

        try {

         int i=1/0;

        }catch (Exception e) {
            System.out.println("FatherException");
            throw e;
        }

    }


}
