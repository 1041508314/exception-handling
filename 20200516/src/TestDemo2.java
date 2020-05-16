/**
 * @Version 1.0
 * @Author:LiuXinYu
 * 自定义异常
 * @Date:2020/5/16
 * @Content:
 */

/**
 *
 * 自定义异常注意
 * 1.一定要继承一个父类异常
 *
 * 自定义异常最好继承于Exception
 * 这样的好处是它必须去处理这个异常
 */
class MyException extends RuntimeException{

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}

public class TestDemo2 {
    public static void func(int x) throws MyException{
        if(x == 10){
            throw new MyException("x == 10");
        }
    }
    public static void main(String[] args) {
        try{
            func(10);
        }catch(MyException e){
            e.printStackTrace();
        }
    }
}
