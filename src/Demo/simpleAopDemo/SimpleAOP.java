package Demo.simpleAopDemo;

import java.lang.reflect.Proxy;

/**
 * @Author: zhaoanwei
 * @Date: 2021/2/2
 */
public class SimpleAOP {
    public static Object getProxy(Object bean, Advice advice) {
        return Proxy.newProxyInstance(SimpleAOP.class.getClassLoader(),
                bean.getClass().getInterfaces(), advice);
    }
}
