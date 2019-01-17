package pers.ccdongyu.neo4jbackend.controller;

import org.springframework.web.bind.annotation.*;
import pers.ccdongyu.neo4jbackend.message.StatusWithTime;
import pers.ccdongyu.neo4jbackend.service.CommentService;

@RestController
public class CommentController {
    private CommentService commentService;

    CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping("/Comment/create")
    private StatusWithTime releaseComment(@RequestBody Param param) {
        return commentService.releaseComment(param.dynamicid, param.userid, param.comments);
    }

    @GetMapping("/Comment/getList")
    private StatusWithTime getCommentList(@RequestParam Integer dynamic_id){
        return commentService.getCommentList(dynamic_id);
    }
}
