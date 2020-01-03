package stateModel.state;

/**
 * @author haozt
 * @since 2019/12/31
 */
public interface State {

     void insertCoin();
     void returnCoin();
     void turnCrank();
     void dispense();
     void printstate();

}
