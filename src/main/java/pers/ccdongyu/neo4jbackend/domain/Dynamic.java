package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Dynamic {

    @Id
    @GeneratedValue
    private Long id;
    private String contents;
    private String userid;
    private List<String> contents_img;
    private Integer stars;

    @Relationship(type = "Release")
    private List<Release> releases;

    public Dynamic(){}

    public Dynamic(String contents, String userid, List<String> contents_img){
        this.contents = contents;
        this.userid = userid;
        this.contents_img = contents_img;
        this.stars = 0;
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

    public List<String> getContents_img() {
        return contents_img;
    }

    public void setContents_img(List<String> contents_img) {
        this.contents_img = contents_img;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    @Override
    public String toString(){
        return this.contents + " " + this.userid;
    }
}
