package reflection;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyExample {

    public static void main(String[] args) {

        SimpleTicketPrinter ticketPrinter = new SimpleTicketPrinter();

        TicketPrinter proxyPrinter = (TicketPrinter)Proxy.newProxyInstance(SimpleTicketPrinter.class.getClassLoader(),
                new Class[]{TicketPrinter.class},
                new LoggingInvocationHandler(ticketPrinter));

        System.out.println(proxyPrinter.printTickets(15, "cashier"));


    }

    private static class LoggingInvocationHandler implements InvocationHandler {

        private Object target;

        public LoggingInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Integer arg = (Integer) args[0];
            String user = (String) args[1];
            System.out.println("Amount passed: " + arg);
            Class<?> aClass = target.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            Object value = null;
            for (Method declaredMethod : declaredMethods) {
                UserSecured annotation = declaredMethod.getAnnotation(UserSecured.class);
                String principal = annotation.user();
                if (!principal.equals(user)){
                    throw new IllegalAccessException("User with role: " + user + " is not allowed!");
                }
                if (declaredMethod.getName().equals(method.getName())){
                     value = declaredMethod.invoke(target, args);
                }
            }
            System.out.println("Proxy finished it's work.");
            return value;
        }
    }


}
