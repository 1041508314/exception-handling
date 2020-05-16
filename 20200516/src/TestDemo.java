/**
 * @Version 1.0
 * @Author:LiuXinYu
 * @Date:2020/5/16
 * @Content:
 */


import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * java处理异常的语法
 * try{
 *     //可能出现异常的代码
 * }catch（参数： 异常的类型 e）{
 *     捕获try当中可能出现的异常
 * }
 *
 *
 * 用try catch 处理异常需要注意的问题
 * 1.catch块当中，一定要捕获相应的异常，如果程序抛出的异常在catch块中，不能被捕获，那么就会交给JVM处理
 * 2.可以通过catch来捕获多个异常
 * 3.不建议直接捕获Exception
 * 4.finally块中的代码，终究会被执行的
 * 5.不建议在finally中出现return语句
 */
class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            Person person2 = (Person) person.clone();//受查异常 必须在运行之前处理
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }




    /**
     *
     * 抛出异常: throw 一般抛出某个你想抛出的异常
     * @param args
     */
    public static int divide(int x,int y) throws ArithmeticException{
        if(y == 0){
            throw new ArithmeticException("y == 0");
        }
        return x/y;
    }
    public static void main5(String[] args) {
        try{
            int ret = divide(20,10);
            System.out.println(ret);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }
    }



    public static void func2(){
        int[] arr = {1,2,3};
        System.out.println(arr[100]);
    }
    public static void main4(String[] args) {
        try{
            func2();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }




    public static int func1(){
        int[] array = {1,2,3};
        try{
            System.out.println(array[4]);
//            return 1;
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("捕获到了数组越界异常");
            return 3;
        }finally {
            return 2;
        }
    }

    public static void main3(String[] args) {
//        System.out.println(func1());
        Scanner scanner = new Scanner(System.in);
        try{
            int n = scanner.nextInt();
            System.out.println(10/n);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }finally{
            scanner.close();
        }
    }



    public static void main2(String[] args) {
        int[] array = {1,2,3};
        try{
            System.out.println(array[4]);
        }catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕获到了数组越界异常");

        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("捕获到了空指针异常");
        }finally {
            System.out.println("finally块的代码肯定会被执行");
        }
        System.out.println("hello");
    }



    public static void main1(String[] args) {
        int[] array = {1,2,3};
        try{
            System.out.println(array[4]);
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();//打印出现异常的调用栈
            System.out.println("捕获到了数组越界异常或者空指针异常");
        }
//        }catch(NullPointerException e){
//            e.printStackTrace();
//            System.out.println("捕获到了空指针异常");
//        }
        System.out.println("hello");//只要程序出现异常 就不会继续往下执行
    }
}
