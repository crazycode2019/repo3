package com.hwua.test;

import com.hwua.util.JedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisTest {
    @Test
    public void test1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);//获得一个客户端的连接
        jedis.set("user:name", "chenhao");
        Long len = jedis.strlen("user:name");
        System.out.println(jedis.get("user:name"));
        System.out.println(len);
        System.out.println(jedis.ping());
        jedis.close();
    }

    @Test
    public void testHash() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Map<String, String> map = new HashMap<>();
        map.put("emp:name", "张三");
        map.put("emp:age", "10");
        map.put("emp:address", "上海");
        jedis.close();

        jedis.hmset("emp", map);
        System.out.println(jedis.ping());
    }

    @Test
    public void test3() {
        Jedis jedis = JedisUtil.getJedis();
        Map<String, String> map = new HashMap<>();
        map.put("emp:name", "李四");
        map.put("emp:age", "10");
        map.put("emp:address", "上海");

        jedis.hmset("emp2", map);
        JedisUtil.close(jedis);
    }

    @Test
    public void test4() {
        Jedis jedis = JedisUtil.getJedis();
        Long res = jedis.del("emp2");
        System.out.println(res);
        JedisUtil.close(jedis);
    }


}
