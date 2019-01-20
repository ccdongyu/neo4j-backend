package pers.ccdongyu.neo4jbackend.controller;

//<<<<<<< HEAD
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//=======
//>>>>>>> b74d8edf22e7a9ab92d4041eb3773f3b14146d76
import org.springframework.web.bind.annotation.*;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.service.PersonService;

@RestController
@RequestMapping("/")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/User/register")
    public Status register(@RequestBody Person person) {
        return personService.register(person);
    }

    @GetMapping("/User/login")
    public Status login(String userid, String password) {
        return personService.login(userid, password);
    }

    @PostMapping("/User/friend_add")
    public Status becomFriend(@RequestBody Param param) {
        return personService.becomFriend(param.userid, param.friend_id);

    }

    @PostMapping("/User/friend_delete")
    public Status detachFriend(@RequestBody Param param) {
        return personService.detachFriend(param.userid, param.friend_id);
    }

    @GetMapping("/User/friend_list")
    public Status getAllFriends(String userid) {
        return personService.friendList(userid);
    }

//<<<<<<< HEAD
    @GetMapping("/User/friend_recommend")
    public Status getRecommendFriends(String userid){
        return personService.recommendFriends(userid);
//=======
//    @PostMapping("/User/friends_may_know")
//    public Status friendsMayKnow(@RequestParam("friend_id") String friendid) {
//        return personService.friendsMayKnow(friendid);
//>>>>>>> b74d8edf22e7a9ab92d4041eb3773f3b14146d76
    }
}
