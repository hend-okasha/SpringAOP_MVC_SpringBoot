import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LoggingHandler implements InvocationHandler {
    private final Object targetObj;

    public LoggingHandler(Object targetObj) {

        this.targetObj = targetObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----- Before Method -----");
        System.out.println("Method: " + method.getName());
        System.out.println("Arguments: " + Arrays.toString(args));

        long startTime = System.currentTimeMillis();

        System.out.println("Method call");
        Object result = method.invoke(targetObj, args);

        long endTime = System.currentTimeMillis();

        System.out.println("----- After Method -----");
        System.out.println("Return value: " + result);
        System.out.println("Execution time: " + (endTime - startTime) );

        return result;
    }
}
