package pers.ccdongyu.neo4jbackend.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "Release")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String create_at;
    private String text;

    @StartNode
    private Person person;

    @EndNode
    private Dynamic dynamic;

    Comment(){}

    Comment(String create_at, String text, Person person, Dynamic dynamic){
        this.create_at = create_at;
        this.text = text;
        this.person = person;
        this.dynamic = dynamic;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Dynamic getDynamic() {
        return dynamic;
    }

    public void setDynamic(Dynamic dynamic) {
        this.dynamic = dynamic;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
