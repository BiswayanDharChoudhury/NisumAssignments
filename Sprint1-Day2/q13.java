import java.util.*;

class CodeChef{
        static{
            System.out.println("This is will be executed first before the main function is executed");
        }
        
        public static void showExec(){
            System.out.println("This will only execute when it is called");
        }
        
        public static void main(String args[]){
            System.out.println("Main method will execute here");
            showExec();
        }
    }
