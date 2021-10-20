import Logic.MySystem;
import Entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Main {
    public static void main(String[] args) throws JsonProcessingException /*throws JsonProcessingException */{
        MySystem system = new MySystem();
        //System.out.println(java.lang.System.getProperty("java.library.path"));
        //system.registerUser();
        //system.registerUser("qwerty", "123456");
//        System.out.print("Отлично!");
//        //system.registerUser();
//        System.out.print("Отлично 2");
//        system.logIn();
        system.startSystem();
    }
}