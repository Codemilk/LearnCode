import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Loose_array {
    //创建数组

      public int[][] makeArray(int a, int b){
          int [] [] array=new int[a][b];
          for(int i=0;i<a;i++){
               for(int n=0;n<b;n++){

                   if(i==1&&n==2){
                       array [i] [n]=1;
                      continue;
                   }

                   if (i==2&&n==3){
                       array [i] [n]=2;
                       continue;
                   }

                   array [i] [n]=0;
               }

               }

          return array;
      }


     static   void print(int [][] array){
         for(int [] i:array){
             for(int n=0;n<array.length;n++){
                 System.out.print(i[n]+" ");
                 if(n==10){
                     System.out.println("");
                 }
             }
         }
     }

     @Test
     public void test() throws Throwable {
         URL url=Loose_array.class.getClassLoader().getResource("a.txt");
         System.out.println(url);
         InputStream inputStream=new FileInputStream("E:\\Code\\idea\\out\\production\\ModelStruct\\a.txt");
         byte [] a=new byte[1024];
         inputStream.read(a);
         String s=new String(a);
         System.out.println(s);


     }

    public static void main(String[] args) {

        int[][] array = new Loose_array().makeArray(11, 11);


           }

}
