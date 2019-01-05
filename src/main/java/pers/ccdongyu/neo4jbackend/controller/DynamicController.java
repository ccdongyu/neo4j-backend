package pers.ccdongyu.neo4jbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.service.DynamicService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DynamicController {

    private final DynamicService dynamicService;

    public DynamicController(DynamicService dynamicService){
        this.dynamicService = dynamicService;
    }

    @PostMapping("/Dynamic/create")
    private Status releaseDynamic(@RequestBody Param param){
        return dynamicService.releaseDynamic(param.userid, param.contents);
    }

    @PostMapping("/Dynamic/getList")
    private Status getDynamicList(@RequestBody Param param){
        return dynamicService.getDynamicList(param.userid);
    }

    @DeleteMapping("/Dynamic/delete")
    private Status deleteDynamic(@RequestParam Long nodeid){
        return dynamicService.deleteDynamic(nodeid);
    }
}

class Param{
    public String userid;
    public String contents;
}