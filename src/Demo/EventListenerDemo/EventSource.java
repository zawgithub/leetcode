package Demo.EventListenerDemo;

import java.util.Vector;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/5
 */
public class EventSource {
    //监听器列表，监听器的注册则加入此列表
    private Vector<MyEventListener> listenerList = new Vector<>();
    //注册监听器
    public void addListener(MyEventListener eventListener){
        listenerList.add(eventListener);
    }
    //撤销注册
    public void removeListener(MyEventListener eventListener){
        listenerList.remove(eventListener);
    }
    //接受外部事件
    public void notifyListenerEvents(MyEventObject event){
        for(MyEventListener eventListener:listenerList){
            eventListener.handleEvent(event);
        }
    }
}
