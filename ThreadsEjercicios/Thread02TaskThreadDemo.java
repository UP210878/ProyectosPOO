package ThreadsEjercicios;
import java.util.concurrent.*;
public class Thread02TaskThreadDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        
        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));


        executor.shutdown();
        
    }
}
