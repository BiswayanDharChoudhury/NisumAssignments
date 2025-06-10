import java.util.*;
public class q1 {
    public static int divisionOfTwoNums(int a , int b){
        return a/b ;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            int a = 2 ;
            int b = 0 ;
            int division = divisionOfTwoNums(a,b);
        }catch(Exception ArithmeticException){
            System.out.println("It is an error");
        }finally{
            System.out.println("Finally , the division block will be printed");
        }
    }
}
