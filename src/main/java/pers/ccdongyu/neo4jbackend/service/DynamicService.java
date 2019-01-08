package pers.ccdongyu.neo4jbackend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pers.ccdongyu.neo4jbackend.domain.Dynamic;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.Status;
import pers.ccdongyu.neo4jbackend.message.StatusWithTime;
import pers.ccdongyu.neo4jbackend.repository.DynamicRepository;
import pers.ccdongyu.neo4jbackend.repository.PersonRepository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        dynamicRepository.createDynamic(userid, dynamic.getId(), Calendar.getInstance().getTime());
        return Status.getInstance(200, "release success", dynamic);
    }


    public StatusWithTime getDynamicList(String userid) {
        Person person = personRepository.findByUserid(userid);
        if(person == null){
            return StatusWithTime.getFailedInstance("无该用户");
        }
        Map<String, List<Dynamic>> data = new HashMap<>();
        List<Dynamic> dynamics = dynamicRepository.getDynamicsByUserid(userid);
        data.put("dynamic_lists", dynamics);
        return StatusWithTime.getInstanceWithTime(200, "get dynamic list success", data);
    }

    public Status deleteDynamic(Long nodeId) {
        if (dynamicRepository.findDynamicById(nodeId) == null){
            return Status.getFailedInstance("无效的动态编号");
        }
        dynamicRepository.deleteDynamicById(nodeId);
        return Status.getSucceedInstance();
    }
}
