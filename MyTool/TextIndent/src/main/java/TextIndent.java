import java.io.*;

/**
 * 将文件放在
 *
 * @author lenovo
 */
public class TextIndent{

    /**
     * //父文件
     * //        File FatherFile = new File("TextIndent/src/main/resources/Father.txt");
     * //子文件
     * <p>
     * //建立流
     * //        FileReader fileReader = new FileReader(FatherFile);
     * <p>
     * try {
     * File SonFile = new File("TextIndent/src/main/resources/Son.txt");
     * <p>
     * FileWriter fileWriter = new FileWriter(SonFile);
     * fileWriter.write("ddd");
     * <p>
     * }catch (Exception e) {
     * e.printStackTrace();
     * }
     * <p>
     * <p>
     * //建立缓存数组
     * char [] array=new char[10];
     * <p>
     * //        fileReader.read(array);
     * //        System.out.println(array);
     * //        int index;
     * //        while((index = fileReader.read(array))!=-1){
     * ////            for(int i = 0; i < index; i++){
     * ////                if(array[i] =='.'){
     * ////                    array[i] ='\n';
     * ////                }
     * ////            }
     * //          fileWriter.write(String.valueOf(array));
     * //
     * //        }
     * //
     * //
     */
    public static void main(String[] args) throws IOException {


        //父文件
        File FatherFile = new File("TextIndent/src/main/resources/Father.txt");
        //子文件
        File SonFile = new File("TextIndent/src/main/resources/Son.txt");

        //建立流
        FileReader fileReader = new FileReader(FatherFile);
        FileWriter fileWriter = new FileWriter(SonFile);



        //建立缓存数组
        char[] array = new char[101];
        array[100]='\n';
        int index;
        int x=0;
        while ((index = fileReader.read(array,0,100)) != -1) {

                        for(int i = 0; i <= index; i++){
                            x++;
//                            if(array[i] =='\n'){
//                                fileWriter.write("\t"+"\t");
                                if(x>=50){
                                    if(array[i] =='.'||array[i] ==','){
                                        fileWriter.write(String.valueOf(array));
                                        x=0;
                                        break;
                                    }
                                    if (x==99)  {

                                        fileWriter.write(String.valueOf(array));
                                        x=0;

                                        break;
                                    }
                                }
//                            }


                        }


        }

        fileWriter.close();
        fileWriter.close();


    }


}

