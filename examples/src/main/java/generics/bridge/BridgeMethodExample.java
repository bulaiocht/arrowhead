package generics.bridge;

import java.lang.reflect.Method;

public class BridgeMethodExample {
    public static void main(String[] args) {

        Class<NodeChild> nodeChild = NodeChild.class;

        Method[] declaredMethods = nodeChild.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }


    }
}
