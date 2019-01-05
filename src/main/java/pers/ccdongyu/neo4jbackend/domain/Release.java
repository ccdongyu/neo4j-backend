package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.*;

import java.util.Date;

@RelationshipEntity(type = "Release")
public class Release {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private Dynamic dynamic;

    private Date createDate;

    public Release(){}

    public Release(Person person, Dynamic dynamic, Date createDate){
        this.person = person;
        this.dynamic = dynamic;
        this.createDate = createDate;
    }
}
