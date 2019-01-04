package pers.ccdongyu.neo4jbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.service.PersonService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/user/register")
    public Status register(@RequestBody Person person) {
        return personService.register(person);
    }

    @GetMapping("/user/login")
    public Status login(String userid, String password) {
        return personService.login(userid, password);
    }

    @PostMapping("/user/friend_add")
    public Status becomFriend(String userid, @RequestParam("friend_id") String friendid) {
        return personService.becomFriend(userid, friendid);

    }

    @PostMapping("/user/friend_delete")
    public Status detachFriend(String userid, @RequestParam("friend_id") String friendid) {
        return personService.detachFriend(userid, friendid);
    }

    @GetMapping("/user/friend_list")
    public Status getAllFriends(String userid) {
        return personService.friendList(userid);
    }

}
