package pers.ccdongyu.neo4jbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.message.StatusWithTime;
import pers.ccdongyu.neo4jbackend.service.DynamicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class DynamicController {

    private final DynamicService dynamicService;

    public DynamicController(DynamicService dynamicService){
        this.dynamicService = dynamicService;
    }

    @PostMapping("/Dynamic/create")
    private StatusWithTime releaseDynamic(@RequestBody Param param){
        return dynamicService.releaseDynamic(param.userid, param.contents, param.contents_img);
    }

    @GetMapping("/Dynamic/getList")
    private StatusWithTime getDynamicList(@RequestParam(required = false) Integer dynamicid, @RequestParam String userid){
        return dynamicService.getDynamicList(dynamicid, userid);
    }

    @DeleteMapping("/Dynamic/delete")
    private Status deleteDynamic(@RequestParam Long nodeid){
        return dynamicService.deleteDynamic(nodeid);
    }

    @PostMapping("/Dynamic/thumb_up")
    private Status givenThumbUp(@RequestBody Param param){
        return dynamicService.givenThumbUp(param.userid, Long.valueOf(param.dynamicid));
    }
}

class Param{
    public String userid;
    public Integer dynamicid;
    public String comments;
    public String contents;
    public List<String> contents_img;
}
