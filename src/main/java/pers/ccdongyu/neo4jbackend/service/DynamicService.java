package pers.ccdongyu.neo4jbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.ccdongyu.neo4jbackend.domain.Dynamic;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.repository.DynamicRepository;
import pers.ccdongyu.neo4jbackend.repository.PersonRepository;

import java.util.List;

@Service
public class DynamicService {

    private final DynamicRepository dynamicRepository;
    private final PersonRepository personRepository;

    public DynamicService(DynamicRepository dynamicRepository, PersonRepository personRepository){
        this.dynamicRepository = dynamicRepository;
        this.personRepository = personRepository;
    }

    public Status releaseDynamic(String userid, String content){
        Person person = personRepository.findByUserid(userid);
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info(userid);
        if(person == null){
            return Status.getFailedInstance("无该用户");
        }
        Dynamic dynamic = new Dynamic(content, userid);
        dynamicRepository.save(dynamic);
        dynamicRepository.createDynamic(userid, dynamic.getId());
        return Status.getInstance(200, "release success", dynamic);
    }


    public Status getDynamicList(String userid) {
        Person person = personRepository.findByUserid(userid);
        if(person == null){
            return Status.getFailedInstance("无该用户");
        }
        List<Dynamic> dynamics = dynamicRepository.getDynamicsByUserid(userid);
        return Status.getInstance(200, "get dynamic list success", dynamics);
    }

    public Status deleteDynamic() {
        return null;
    }
}
