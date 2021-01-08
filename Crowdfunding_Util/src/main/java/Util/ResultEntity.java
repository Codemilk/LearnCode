package Util;

public class ResultEntity<T>{

    public static final String SUCCESS="SUCCESS";
    public static final String FAILED="FAILED";

/**用来封装当前结果成功还是失败*/
    private String result;
/**    请求处理失败，返回的错误消息*/
    private String message;
/**要返回的数据*/
    private T data;

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }
/**泛型方法:泛型在类上面就是泛型类，在方法上面就是泛型方法*/
/**请求成功但不需要返回类型*/
    public static <Type>ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }
/**请求成功但是需要返回数据
 * 注意:这里的泛型T就是泛型Type，准确的说是 先有Type再有T
 * */
    public static <Type>ResultEntity<Type> successWithData(Type data){
       return new ResultEntity<Type>(SUCCESS,null,data);
    }
/**处理消息失败*/
    public static <Type>ResultEntity<Type> Failed(String message){
        return new ResultEntity<Type>(FAILED,message,null);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
