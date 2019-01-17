package pers.ccdongyu.neo4jbackend.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import pers.ccdongyu.neo4jbackend.domain.Dynamic;
import pers.ccdongyu.neo4jbackend.domain.Person;

import java.util.List;

public interface CommentRepository extends Neo4jRepository<Dynamic, Long> {
    @Query("MATCH (n:Dynamic),(m:Person) WHERE ID(n)={0} and m.name={1}" +
            "CREATE (m)-[:Comment{text:{2},create_at:{3}}]->(n)")
    void createDynamicComment(Long dynamicid, String userid, String text, String create_at);

    @Query("MATCH ()-[c:Comment]->(n:Dynamic) WHERE ID(n)={0} RETURN count(c)")
    Integer getCommentsNum(Long dynamicid);

    @Query("MATCH ()-[c:Comment]->(n:Dynamic) WHERE ID(n)={0} RETURN c.text")
    List<String> getCommentTextList(Long dynamicid);

    @Query("MATCH ()-[c:Comment]->(n:Dynamic) WHERE ID(n)={0} RETURN c.create_at")
    List<String> getCommentTimeList(Long dynamicid);

    @Query("MATCH (p:Person)-[c:Comment]->(n:Dynamic) WHERE ID(n)={0} AND c.text={1} AND c.create_at={2} RETURN p")
    Person getCommentors(Long dynamicid, String text, String create_at);
}