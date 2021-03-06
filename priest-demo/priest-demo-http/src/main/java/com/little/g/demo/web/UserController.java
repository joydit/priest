package com.little.g.demo.web;

import com.little.g.common.ResultJson;
import com.little.g.common.dto.ListResultDTO;
import com.little.g.common.params.TimeQueryParam;
import com.little.g.demo.api.UserService;
import com.little.g.demo.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by lengligang on 2019/3/12.
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResultJson add(@Valid UserDTO params){
        ResultJson r=new ResultJson();

        if(userService.add(params)){
            return r;
        }
        r.setC(ResultJson.SYSTEM_UNKNOWN_EXCEPTION);
        return r;
    }

    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public ResultJson del(@RequestParam Integer id){
        ResultJson r=new ResultJson();
        if(userService.delete(id)){
            return r;
        }
        r.setC(ResultJson.SYSTEM_UNKNOWN_EXCEPTION);
        return r;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResultJson update(@Valid UserDTO params){
        ResultJson r=new ResultJson();
        if(userService.update(params)){
            return r;
        }
        r.setC(ResultJson.SYSTEM_UNKNOWN_EXCEPTION);
        return r;
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResultJson list(@Valid TimeQueryParam params){
        ResultJson r=new ResultJson();
        ListResultDTO<UserDTO> list= userService.list(params);
        r.setData(list);
        return r;
    }
}
