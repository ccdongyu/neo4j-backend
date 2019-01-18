package pers.ccdongyu.neo4jbackend.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import pers.ccdongyu.neo4jbackend.domain.Dynamic;
import pers.ccdongyu.neo4jbackend.domain.Person;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
    Person findByUserid(String userid);

    @Query("MATCH (a),(b) WHERE a.name={0} AND b.name={1}" +
            "CREATE (a)-[:Friend]->(b)")
    void becomeFriend(String userid, String friendid);

    @Query("MATCH (a)-[f:Friend]->(b) WHERE a.userid={0} AND b.userid={1} DETACH DELETE f")
    void detachFriend(String userid, String friendid);

    @Query("MATCH (Person{userid:{0}})-[:Friend*1]-(p) RETURN p")
    Collection<Person> getAllFriends(String userid);

    @Query("match (:Person{userid:{0}})-[:Friend*2]-(n:Person) where n.userid <> {0} return n")
    List<Person> getRecommendFriends(String userid);

    @Query("MATCH (n:Person{userid:{0}})-[:Friend*1]-(m:Person{userid:{1}}) RETURN true")
    Boolean isFriend(String userid, String friendid);
}
