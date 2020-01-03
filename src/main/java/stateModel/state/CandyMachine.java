package stateModel.state;

import stateModel.state.impl.*;

/**
 * @author haozt
 * @since 2019/12/31
 */
public class CandyMachine {

    public State mSoldOutState;
    public State mOnReadyState;
    public State mHasCoin;
    public State mSoldState;
    public State mWinnerState;
    private State state;
    private int count = 0;


    public CandyMachine( int count) {

        this.count = count;

        mSoldOutState = new SoldOutState(this);

        mOnReadyState  = new OnReadyState(this);

        mHasCoin = new HasCoin(this);

        mSoldState = new SoldState(this);

        mWinnerState  = new WinnerState(this);

        state = count > 0 ? mOnReadyState : mSoldOutState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;

    }

    public int getCount() {
        return count;
    }

    public void insertCoin() {
        state.insertCoin();
    }


    public void returnCoin() {
        state.returnCoin();
    }


    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }


    public void printState(){
        state.printstate();
    }



    public  void releaseCandy() {

            if (count > 0) {
                count = count - 1;
                System.out.println("售出了一件货,现在还剩"+count+"件");
            }
        }


}
