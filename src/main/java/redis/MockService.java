package redis;

import redis.clients.jedis.Jedis;



/**
 * @author shiming.li
 * @version $ v1.0 19-3-25 $
 */
public class MockService {


    public int getAge(String name , Jedis jedis){
        //从redis取数
        String s = jedis.get(name);
        if(s != null){
            System.out.println(Thread.currentThread().getName() + " redis 中的数据 s=" + s);
            return Integer.parseInt(s);
        }

        //从数据库取
        System.out.println(Thread.currentThread().getName() + " 取数据库中的数据 s= 27");

        //放到redis中
        jedis.set(name, "27");

        return 27;
    }
}
