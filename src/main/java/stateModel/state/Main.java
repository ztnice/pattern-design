package stateModel.state;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author haozt
 * @since 2019/12/31 0031
 */
public class Main {


    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(10);

        final CandyMachine candyMachine = new CandyMachine(10000);

        for(int i = 0 ; i < 100;i++){
            executors.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread());
                    Main.run(candyMachine);
                }
            });
        }


    }


    public static void run(CandyMachine candyMachine){
        for(int i = 0 ;i < 100;i++){
            candyMachine.insertCoin();

            candyMachine.turnCrank();
        }
    }
}
