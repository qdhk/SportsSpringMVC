package com.nr.sports.utils;

import com.nr.sports.model.MyFile;
import com.nr.sports.model.User;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by nr on 2017/02/13 0013.
 */
@Component
public class DB {
    private static Map<String,User> t_user = new HashMap<String,User>();
    private static Map<String,MyFile> t_file = new HashMap<String,MyFile>();
    public void saveOrUpdateUser(User user){
        t_user.put(user.getId(), user);
    }
    public void delUser(String id){
        t_user.remove(id);
    }
    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        Set<String> keys = t_user.keySet();
        for(String key : keys){
            users.add(t_user.get(key));
        }
        return users ;
    }
    public User getUserById(String id){
        return t_user.get(id);
    }
    public User getUserByUserOrEmail(String s){
        User user = null ;
        List<User> users = getAllUser();
        for(User u : users){
            if(s.equals(u.getEmail()) || s.equals(u.getUsername())){
                user = u ;
                break ;
            }
        }
        return user ;
    }
    public void saveFile(MyFile file){
        t_file.put(file.getId(), file);
    }
    public List<MyFile> getAllFile(){
        Set<String> files = t_file.keySet();
        List<MyFile> flist = new ArrayList<MyFile>();
        for(String f : files){
            flist.add(t_file.get(f));
        }
        return flist ;
    }
}

