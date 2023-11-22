package ThreadsEjercicios;

public class Thread01TaskThreadDemo {
    public static void main(String[] args) {
        Runnable printA = new PrintChar('a',100);
        Runnable printB = new PrintChar('b',100);
        Runnable print100 = new PrintNum(100);

        Thread thread01 = new Thread(printA);
        Thread thread02 = new Thread(printB);
        Thread thread03 = new Thread(print100);

        thread01.start();
        thread02.start();
        thread03.start();
        
    }
}

class PrintChar implements Runnable {
    private char charToPrint;
    private int times;
    //Hilos 5 estados, tienen espera, en proceso, inicio, fin
    public PrintChar(char c, int t){
        charToPrint = c;
        times = t;
    }

    @Override
    
    public void run(){
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
        }
    }
}

class PrintNum implements Runnable {
    private int lastNum;
    public PrintNum(int n){
        lastNum = n;
    }

    @Override
    public void run(){
        for (int i = 0; i <= lastNum; i++) {
            System.out.print(" "+i);
        }
    }
}




