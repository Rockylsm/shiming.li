package J.U.C;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shiming.li
 * @version $ v1.0 19-3-28 $
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        Map<String, Person> map  = new ConcurrentHashMap<>();
        Person person = Person.newPerson("shiming.li", 15);
        map.put("li", person);

        System.out.println(map);

        person.modifyName("huangdi");
        person.modifyAge(28);

        System.out.println(map);
        lock.unlock();
    }
}
