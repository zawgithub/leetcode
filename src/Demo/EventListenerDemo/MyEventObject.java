package Demo.EventListenerDemo;

import java.util.EventObject;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/5
 */
public class MyEventObject extends EventObject {
    private static final long serialVersionUID = 1L;
    public MyEventObject(Object source) {
        super(source);
    }
    public void doEvent(){
        System.out.println("通知一个事件源 source:"+this.getSource());
    }
}
