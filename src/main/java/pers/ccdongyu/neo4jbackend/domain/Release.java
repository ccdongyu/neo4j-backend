package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "Release")
public class Release {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Person person;

    @EndNode
    private Dynamic dynamic;

    public Release(){}

    public Release(Person person, Dynamic dynamic){
        this.person = person;
        this.dynamic = dynamic;
    }
}
