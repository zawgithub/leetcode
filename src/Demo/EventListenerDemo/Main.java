package Demo.EventListenerDemo;

/**
 * @Author: zhaoanwei
 * @Date: 2021/3/5
 */
public class Main {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.addListener(new MyEventListener() {
            @Override
            public void handleEvent(MyEventObject event) {
                event.doEvent();
                if ("closeWindows".equals(event.getSource())) System.out.println("doClose");
            }
        });

        eventSource.notifyListenerEvents(new MyEventObject("closeWindows"));
    }
}
