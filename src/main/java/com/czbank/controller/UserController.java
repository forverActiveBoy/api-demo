package com.czbank.controller;

import com.czbank.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author foreverActiveBoy
 */
@RestController
@RequestMapping(value = {"/v1"})
@Slf4j
public class UserController {

    @RequestMapping(value = {"/user"},method = RequestMethod.POST)
    public void addUser(@RequestBody @Valid User user){
       log.info("入参user:[{}]",user);
    }

    @RequestMapping(value = {"/user"},method = RequestMethod.GET)
    public List<User> queryList(){
        log.info("查询所有！");
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"账号","邮箱"));
        list.add(new User(2L,"账号","邮箱"));
        list.add(new User(3L,"账号","邮箱"));
        return list;
    }
}
