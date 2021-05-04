package main;

import org.neo4j.dbms.api.DatabaseManagementService;
import org.neo4j.dbms.api.DatabaseManagementServiceBuilder;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

public class Main {
    public static void main(String[] args) {
        DatabaseManagementService managementService = new DatabaseManagementServiceBuilder(databaseDirectory).build();
        GraphDatabaseService db = managementService.database(DEFAULT_DATABASE_NAME);

        try (Transaction tx = db.beginTx()) {
            Node myNode = tx.createNode();
            myNode.setProperty("name", "my node");
            tx.commit();
        }
    }
}
