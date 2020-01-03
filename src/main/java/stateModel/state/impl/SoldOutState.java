package stateModel.state.impl;

import stateModel.state.CandyMachine;
import stateModel.state.State;

/**
 * @author haozt
 * @since 2019/12/31 0031
 */
public class SoldOutState implements State {

    private CandyMachine candyMachine;

    public SoldOutState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }


    public void insertCoin() {

        System.out.println("无法插入硬币，没货");
    }


    public void returnCoin() {

        System.out.println("没接收到钱，不给退");
    }


    public void turnCrank() {
        System.out.println("没货，旋转没意义");
    }


    public void dispense() {

    }


    public void printstate() {

        System.out.println("SoldOutState(售空)");
    }
}
