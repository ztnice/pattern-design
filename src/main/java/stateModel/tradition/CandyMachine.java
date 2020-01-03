package stateModel.tradition;

/**
 * @author haozt
 * @since 2019/12/31
 */
public class CandyMachine {
    final static int SoldOutState = 0; //初始状态
    final static int OnReadyState = 1;  //待机状态
    final static int HasCoin = 2;  //准备状态
    final static int SoldState = 3;  //售出状态

    private int state = SoldOutState; //变量,用于存放当前的状态值
    private int count = 0; //糖果的数目

    public CandyMachine(int count) {
        this.count = count;

        if(count > 0){
            state = OnReadyState;
        }
    }

    //投入硬币行为的时候，通过判断当前的状态来匹配所有的状态.
    public void insertCoin(){
        switch (state){
            case SoldOutState:
                System.out.println("不接收硬币，糖果已售空！");
                break;
            case OnReadyState:
                System.out.println("已接收硬币，请转动曲柄！");
                state = HasCoin;
                break;
            case HasCoin:
                System.out.println("正在运行中，暂时不能投入硬币！");
                break;
            case SoldState:
                System.out.println("请稍等，正在出货！");
                break;
        }
    }


    //回退硬币
    public void returnCoin(){
        switch (state){
            case SoldOutState:
                System.out.println("无法回退，没有硬币可以回退！");
                break;
            case OnReadyState:
                System.out.println("待机状态，没有接收到硬币！");
                break;
            case HasCoin:
                System.out.println("可以回退！");
                state = OnReadyState;
                break;
            case SoldState:
                System.out.println("请稍后，正在回退硬币！");
                break;
        }
    }



    //转动旋钮
    public void turnCrank(){
        switch (state){
            case SoldOutState:
                System.out.println("无法旋转，已售空！");
                break;
            case OnReadyState:
                System.out.println("无硬币，无法旋转，请先投入硬币！");
                break;
            case HasCoin:
                System.out.println("正在旋转中！");
                state = SoldState;
                break;
            case SoldState:
                System.out.println("正在出货中！");
                break;
        }
    }


    /**
     * 出货中
     */
    private void dispense(){
        count = count -1;
        if(count > 0){
            System.out.println("出货中");
        }else {
            System.out.println("已售空");
            state = OnReadyState;
        }
    }


    private void printState(){
        switch (state){
            case SoldOutState:
                System.out.println("SoldOutState(初始状态)！");
                break;
            case OnReadyState:
                System.out.println("OnReadyState(待机状态)！");
                break;
            case HasCoin:
                System.out.println("HasCoin（准备出货状态）！");
                state = SoldState;
                break;
            case SoldState:
                System.out.println("SoldState（售空状态）！");
                break;
        }
    }




}
