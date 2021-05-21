package Demo.simpleAopDemo;

import org.junit.Test;

/**
 * @Author: zhaoanwei
 * @Date: 2021/2/2
 */
public class SimpleAOPTest {
    @Test
    public void getProxy() throws Exception {
        //1.创建一个MethodInvocation实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloService helloService = new HelloServiceImpl();
        //2.创建一个Advice
        Advice beforeAdvice = new BeforeAdvice(helloService, logTask);
        //3.为目标对象
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloService, beforeAdvice);
        helloServiceImplProxy.sayHelloWorld();
    }
}
