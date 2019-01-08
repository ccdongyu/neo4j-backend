package pers.ccdongyu.neo4jbackend.domain;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String userid;
    private String password;
    private String username;
    private String avatar;
    private String sex;
    private String desc;

    @Relationship(type = "Friend")
    private List<Friend> friends;

    @Relationship(type = "Release")
    private List<Release> releases;

    public Person() {
    }

    public String getUserid() {
        return userid;
    }

    public Person assignName() {
        this.name = this.userid;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person clearPassword() {
        this.password = null;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public String getDesc() {
        return desc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return userid + " " + password;
    }
}