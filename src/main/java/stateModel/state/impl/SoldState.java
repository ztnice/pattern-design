package stateModel.state.impl;

import stateModel.state.CandyMachine;
import stateModel.state.State;

/**
 * @author haozt
 * @since 2019/12/31 0031
 */
public class SoldState implements State {

    private CandyMachine candyMachine;

    public SoldState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }


    public void insertCoin() {
        System.out.println("无法插入，正在出货");
    }


    public void returnCoin() {
        System.out.println("正在出货，没钱退，不给退");
    }


    public void turnCrank() {
        System.out.println("出货中，稍后在转");
    }


    //触发 出货的行为
    public void dispense() {

        candyMachine.releaseCandy();

        if(candyMachine.getCount() > 0){
            candyMachine.setState(candyMachine.mOnReadyState);
        }else {
            System.out.println("卖完了");
            candyMachine.setState(candyMachine.mSoldOutState);
        }


    }


    public void printstate() {
        System.out.println("SoldState(售出状态)");
    }
}
