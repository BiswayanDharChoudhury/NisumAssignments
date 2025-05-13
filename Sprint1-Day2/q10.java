import java.util.*;

class staticMethodOverload{
    static void display(){
        System.out.println("This one is without any parameters");
    }
    
    static void display(int a , int b){
        System.out.println("This one is with two numbers"+a+"&"+b);
    }
    
    static void display(String message , int a){
        System.out.println("This one is with message:"+message+"and the number:"+a);
    }
}
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    staticMethodOverload.display();
	    staticMethodOverload.display(2,3);
		staticMethodOverload.display("Hi",5);

	}
}
