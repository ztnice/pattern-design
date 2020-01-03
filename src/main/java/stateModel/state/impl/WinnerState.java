package stateModel.state.impl;

import stateModel.state.CandyMachine;
import stateModel.state.State;

/**
 * @author haozt
 * @since 2019/12/31 0031
 */
public class WinnerState implements State {

    private CandyMachine candyMachine;

    public WinnerState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }


    public void insertCoin() {
        System.out.println("稍等 在出货 暂时不支持投币");
    }


    public void returnCoin() {
        System.out.println("没有投币 不能退");
    }


    public void turnCrank() {
        System.out.println("在出货 稍等");
    }


    public void dispense() {
        candyMachine.releaseCandy();
        if(candyMachine.getCount() == 0){
            candyMachine.setState(candyMachine.mSoldOutState);
        }else {
//            System.out.println("你赢了 在给你来一发");
//            candyMachine.releaseCandy();
            if(candyMachine.getCount() > 0){
                candyMachine.setState(candyMachine.mOnReadyState);
            }else {
                candyMachine.setState(candyMachine.mSoldOutState);
            }
        }

    }


    public void printstate() {
        System.out.println("WinnerState(赢家模式)");
    }
}
