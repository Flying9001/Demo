package com.ljq.demo.util;

import org.bson.types.ObjectId;
import org.junit.Test;

public class MongoDbUtilTest {

    private static final String collectionName = "user";

    @Test
    void connectWithUri() {
        MongoDbUtil.connectWithUri();
    }

    @Test
    void connect() {
        MongoDbUtil.connect();
    }

    @Test
    void listDatabase() {
        MongoDbUtil.listDatabase();
    }

    @Test
    void createCollection() {
        MongoDbUtil.createCollection(collectionName);
    }

    @Test
    void listCollection() {
        MongoDbUtil.listCollection();
    }

    @Test
    void getCollection() {
        MongoDbUtil.getCollection(collectionName);
    }

    @Test
    void deleteCollection() {
        MongoDbUtil.deleteCollection(collectionName);
    }

    @Test
    void insertOne() {
        MongoDbUtil.insertOne(collectionName);
    }

    @Test
    void insertMany() {
        MongoDbUtil.insertMany(collectionName);
    }

    @Test
    void query() {
        MongoDbUtil.query(collectionName);
    }

    @Test
    void queryAll() {
        MongoDbUtil.queryAll(collectionName);
    }

    @Test
    void update() {
        MongoDbUtil.update(collectionName);
    }

    @Test
    void testUpdate() {
        String id = "5ff2f902d853711912818c63";
        MongoDbUtil.update(collectionName, id);
    }

    @Test
    void delete() {
        String id = "5ff2f902d853711912818c63";
        MongoDbUtil.delete(collectionName, id);
    }

    @Test
    void deleteBatch() {
        ObjectId[] ids = {new ObjectId("5ff2f8df563a2859b31bb16c"),
                new ObjectId("5ff2f9cf20191b477b875a4e"),
                new ObjectId("5ff2f9cf20191b477b875a4f")};
        MongoDbUtil.deleteBatch(collectionName, ids);
    }

}