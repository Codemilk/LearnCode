package COM.AOP.HelloWord;

import org.junit.Test;

public class AOPtest {
            @Test
     public void test(){
           Calculator calculator  =new CalculatorImpl();


//                calculator.add(1,2);


            Calculator calculator_proxy=new Dynamic_proxy_Caculator(calculator).getLoggingProxy();


                int add = calculator_proxy.add(1, 2);
                System.out.println(add);


            }
  }