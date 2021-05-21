package Demo.EventListenerDemo;

import java.util.EventListener;

/**
 * 事件监听接口
 * @Author: zhaoanwei
 * @Date: 2021/3/5
 */
public interface MyEventListener extends EventListener {
    //事件处理
    void handleEvent(MyEventObject event);
}
