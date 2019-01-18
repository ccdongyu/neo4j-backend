package pers.ccdongyu.neo4jbackend.controller;

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
    public Status becomFriend(String userid, @RequestParam("friend_id") String friendid) {
        return personService.becomFriend(userid, friendid);

    }

    @PostMapping("/User/friend_delete")
    public Status detachFriend(String userid, @RequestParam("friend_id") String friendid) {
        return personService.detachFriend(userid, friendid);
    }

    @GetMapping("/User/friend_list")
    public Status getAllFriends(String userid) {
        return personService.friendList(userid);
    }

    @PostMapping("/User/friends_may_know")
    public Status friendsMayKnow(@RequestParam("friend_id") String friendid) {
        return personService.friendsMayKnow(friendid);
    }
    @PostMapping("/User/info_update")
    public Status setPersonMessage(String userid,String username,String sex,String desc){
        return personService.setMessage(userid,username,sex,desc);
    }
}
