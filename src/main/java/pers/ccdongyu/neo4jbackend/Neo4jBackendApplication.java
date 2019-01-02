package pers.ccdongyu.neo4jbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("pers.ccdongyu.neo4jbackend.repository")
public class Neo4jBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jBackendApplication.class, args);
    }

}

