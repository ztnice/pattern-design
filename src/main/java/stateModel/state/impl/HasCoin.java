package stateModel.state.impl;


import stateModel.state.CandyMachine;
import stateModel.state.State;

import java.util.Random;

/**
 * @author haozt
 * @since 2019/12/31
 */
public class HasCoin  implements State {


    private CandyMachine candyMachine;

    public HasCoin(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }




    public void insertCoin() {

        System.out.println("无法新增，已经有硬币了");

    }


    public void returnCoin() {
        System.out.println("已退出硬币");
        candyMachine.setState(candyMachine.mOnReadyState);
    }


    public void turnCrank() {
        System.out.println("旋转中");
        Random random = new Random();

        int r = random.nextInt(10);
        if(r == 0){
            candyMachine.setState(candyMachine.mWinnerState);
        }else {
            candyMachine.setState(candyMachine.mSoldState);
        }
    }


    public void dispense() {

    }


    public void printstate() {

        System.out.println("HasCoin(有币)");
    }
}
