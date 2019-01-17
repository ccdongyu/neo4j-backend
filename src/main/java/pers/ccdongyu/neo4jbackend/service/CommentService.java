package pers.ccdongyu.neo4jbackend.service;

import org.springframework.stereotype.Service;
import pers.ccdongyu.neo4jbackend.domain.Person;
import pers.ccdongyu.neo4jbackend.message.StatusWithTime;
import pers.ccdongyu.neo4jbackend.repository.CommentRepository;
import pers.ccdongyu.neo4jbackend.repository.DynamicRepository;
import pers.ccdongyu.neo4jbackend.repository.PersonRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommentService {
    private final DynamicRepository dynamicRepository;
    private final PersonRepository personRepository;
    private final CommentRepository commentRepository;

    public CommentService(DynamicRepository dynamicRepository, PersonRepository personRepository, CommentRepository commentRepository){
        this.dynamicRepository = dynamicRepository;
        this.personRepository = personRepository;
        this.commentRepository = commentRepository;
    }

    public StatusWithTime releaseComment(Integer dynamicid, String userid, String comments) {
        if (dynamicRepository.findDynamicById(Long.valueOf(dynamicid)) == null){
            return StatusWithTime.getFailedInstance("无效的动态编号");
        }
        if (personRepository.findByUserid(userid) == null){
            return StatusWithTime.getFailedInstance("无效的用户编号");
        }
        String currentTime = String.valueOf(Calendar.getInstance().getTimeInMillis());
        commentRepository.createDynamicComment(Long.valueOf(dynamicid), userid, comments, currentTime);
        return StatusWithTime.getInstanceWithTime(200,"create comment success", null);
    }

    public StatusWithTime getCommentList(Integer dynamic_id) {
        class CommentListItem{
            public String userid;
            public String username;
            public String avatar;
            public String text;
            public String create_time;
        }
        if (dynamicRepository.findDynamicById(Long.valueOf(dynamic_id)) == null){
            return StatusWithTime.getFailedInstance("无效的动态编号");
        }

        Map<String, List<CommentListItem>> data = new HashMap<>();
        List<CommentListItem> listItems = new LinkedList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<String> texts = commentRepository.getCommentTextList(Long.valueOf(dynamic_id));
        List<String> times = commentRepository.getCommentTimeList(Long.valueOf(dynamic_id));
        if (texts.size() != times.size()) {return StatusWithTime.getFailedInstance("unknown error");}

        for (int i = 0; i < texts.size(); i++) {
            Person person = commentRepository.getCommentors(Long.valueOf(dynamic_id),texts.get(i),times.get(i));
            CommentListItem commentListItem = new CommentListItem();
            commentListItem.avatar = person.getAvatar();
            commentListItem.text = texts.get(i);
            commentListItem.create_time = sdf.format(new Date(Long.parseLong(times.get(i))));
            commentListItem.username = person.getUsername();
            commentListItem.userid = person.getUserid();
            listItems.add(commentListItem);
        }

        Collections.sort(listItems, new Comparator<CommentListItem>() {
            @Override
            public int compare(CommentListItem o1, CommentListItem o2) {
                Date o1Date = null;
                Date o2Date = null;
                try {
                    o1Date = sdf.parse(o1.create_time);
                    o2Date = sdf.parse(o2.create_time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return o2Date.compareTo(o1Date);
            }
        });

        data.put("comment_lists", listItems);
        return StatusWithTime.getInstanceWithTime(200, "get comment list success", data);
    }
}
