package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.*;

import javax.annotation.Generated;

@RelationshipEntity(type = "Friend")
public class Friend {

    @Id
    @GeneratedValue
    private int id;

    @StartNode
    private Person p1;

    @EndNode
    private Person p2;

    public Friend(){}

    public Friend(Person p1, Person p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getId() {
        return id;
    }

    public Person getP1() {
        return p1;
    }

    public Person getP2() {
        return p2;
    }
}
