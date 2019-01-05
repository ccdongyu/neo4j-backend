package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@NodeEntity
public class Dynamic {

    @Id
    @GeneratedValue
    private Long id;
    private String contents;
    private String userid;

    @Relationship(type = "Release")
    private List<Release> releases;

    public Dynamic(){}

    public Dynamic(String contents, String userid){
        this.contents = contents;
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString(){
        return this.contents + " " + this.userid;
    }
}
