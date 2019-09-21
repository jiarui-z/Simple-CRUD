package com.monkey1024.util;

import com.monkey1024.bean.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Mock database
 */
public class DataUtil {

    private static HashMap<String, User> dataMap = new HashMap<>();

    //模拟初始化数据

    static {
        User user1 = new User("jack", "18888888888", "Boston", LocalDate.of(2012, 01, 01));
        User user2 = new User("paul", "16666666666", "Waterloo", LocalDate.of(2018, 04, 01));
        User user3 = new User("andy", "19999999999", "Beijing", LocalDate.of(2017, 11, 11));

        dataMap.put("1", user1);
        dataMap.put("2", user2);
        dataMap.put("3", user3);

    }


    /**
     * Find all
     * @return
     */
    public static HashMap<String, User> findAll(){
        return dataMap;
    }

    /**
     * Find by id
     * @param id
     * @return
     */
    public static User findUserById(String id){
        return dataMap.get(id);
    }


    /**
     * Add new user
     * @param user
     * @throws Exception
     */
    public static void create(User user) throws Exception{
        //Iterate through the keys to find the max val
        Set<Map.Entry<String, User>> entries = dataMap.entrySet();
        Iterator<Map.Entry<String, User>> iterator = entries.iterator();

        int max = 3;

        while(iterator.hasNext()){
            Map.Entry<String, User> next = iterator.next();
            int i = Integer.parseInt(next.getKey());
            if(max < i){
                max = i;
            }
        }

        //将最大值做自增运算，然后作为key放到map中
        dataMap.put(++max + "", user);

    }

    /**
     * Update user
     * @param id
     * @param user
     * @throws Exception
     */
    public static void update(String id,User user) throws Exception{
        dataMap.put(id, user);
    }

    /**
     * Delete user
     * @param id
     * @throws Exception
     */
    public static void delete(String id) throws Exception{
        dataMap.remove(id);
    }
}
