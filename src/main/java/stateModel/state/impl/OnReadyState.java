package stateModel.state.impl;

import stateModel.state.CandyMachine;
import stateModel.state.State;

/**
 * @author haozt
 * @since 2019/12/31 0031
 */
public class OnReadyState implements State {

    private CandyMachine candyMachine;

    public OnReadyState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }


    public void insertCoin() {
        System.out.println("接收到插入的硬币，请旋转旋钮");
        candyMachine.setState(candyMachine.mHasCoin);
    }


    public void returnCoin() {
        System.out.println("没有接收到硬币");
    }


    public void turnCrank() {
        System.out.println("无法旋转，没币");
    }


    public void dispense() {

    }


    public void printstate() {
        System.out.println("OnReadyState(准备状态)");
    }
}
