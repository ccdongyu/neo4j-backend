package pers.ccdongyu.neo4jbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.repository.PersonRepository;

@Service
public class PersonService {


    private final PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Status login(String userid, String password){
        Person p;
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info(userid);
        if((p = personRepository.findByUserid(userid))==null){
            return Status.getFailedInstance("用户未注册！");
        }else if(password !=null && password.equals(p.getPassword())){
            return Status.getInstance(200, "", p.clearPassword());
        }else{
            return Status.getFailedInstance("密码错误！");
        }

    }

    public Status register(Person person){
        String id;
        if ((id=person.getUserid()) ==null){
            return Status.getFailedInstance("用户名不能为空！");
        }
        if(personRepository.findByUserid(id) != null){
            return Status.getFailedInstance("用户已注册");
        }
        personRepository.save(person.assignName());
        return Status.getSucceedInstance();
    }

    public Status becomFriend(String userid, String friendid){
        personRepository.becomeFriend(userid,friendid);
        return Status.getSucceedInstance();
    }

    public Status detachFriend(String userid, String friendid){
        personRepository.detachFriend(userid, friendid);
        return Status.getSucceedInstance();
    }

    public Status friendList(String userid){
        return Status.getInstance(200,"",personRepository.getAllFriends(userid).stream().map(Person::clearPassword));

    }


}
