package JVM;

import qunar.tc.qtracer.impl.QTraceClientGetter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author shiming.li
 * @version $ v1.0 20-3-20 $
 */
public class MyTest8 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        QTraceClientGetter getter = new QTraceClientGetter();
        Field clientField = QTraceClientGetter.class.getDeclaredField("Q_TRACE_CLIENT_SUPPLIER");
        System.out.println(clientField.getClass());
        clientField.setAccessible(true);
        Field modifiers = clientField.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        int modifiers2 = clientField.getModifiers();
        System.out.println(Modifier.toString(modifiers2));
        modifiers.setInt(clientField, clientField.getModifiers() & ~Modifier.FINAL);
        modifiers.setInt(clientField, clientField.getModifiers() | Modifier.FINAL);
        int modifiers1 = clientField.getModifiers();
        System.out.println(Modifier.toString(modifiers1));


        System.out.println("-------------");
        System.out.println(clientField.getModifiers() & ~Modifier.FINAL);
        System.out.println(clientField.getModifiers() | Modifier.FINAL);

    }
}
