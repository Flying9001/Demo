package com.ljq.demo.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @Description: MongoDB 数据库工具类
 * @Author: junqiang.lu
 * @Date: 2020/12/29
 */
@Slf4j
public class MongoDbUtil {

    private static final String DB_NAME = "admin";
    private static final String DB_URI = "mongodb://rout:routSa213@172.16.140.10:27017/?" +
            "authSource=admin&ssl=false";

    /**
     * 创建数据库链接
     *
     * @return
     */
    public static MongoDatabase connectWithUri() {
        MongoClientURI uri = new MongoClientURI(DB_URI);
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase mongoDatabase = null;
        try {
            mongoDatabase = mongoClient.getDatabase(DB_NAME);
            String first = mongoDatabase.listCollectionNames().first();
            log.info("first: {}",first);
            log.info("Connect successfully !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoDatabase;
    }

    /**
     * 创建连接
     *
     * @return
     */
    public static MongoClient connect() {
        MongoClientURI uri = new MongoClientURI(DB_URI);
        return new MongoClient(uri);
    }

    /**
     * 查询数据库列表
     */
    public static void listDatabase() {
        MongoClient mongoClient = connect();
        mongoClient.listDatabaseNames().forEach((Consumer<? super String>) s -> log.info("database: {}", s));
    }

    /**
     * 创建集合
     *
     * @param name
     * @return
     */
    public static MongoCollection createCollection(String name) {
        MongoDatabase mongoDatabase = connectWithUri();
        MongoCollection collection = mongoDatabase.getCollection(name);
        if (Objects.isNull(collection)) {
            mongoDatabase.createCollection(name);
        } else {
            return collection;
        }
        return mongoDatabase.getCollection(name);
    }

    /**
     * 查询集合列表
     */
    public static void listCollection() {
        MongoDatabase mongoDatabase = connectWithUri();
        mongoDatabase.listCollectionNames().forEach((Consumer<? super String>)s -> log.info("collection: {}", s));
    }

    /**
     * 获取集合/数据库表
     *
     * @param name
     * @return
     */
    public static MongoCollection<Document> getCollection(String name) {
        MongoDatabase mongoDatabase = connectWithUri();
        return mongoDatabase.getCollection(name);
    }

    /**
     * 删除集合/数据库表
     *
     * @param name
     */
    public static void deleteCollection(String name) {
        MongoDatabase mongoDatabase = connectWithUri();
        mongoDatabase.getCollection(name).drop();
    }

    /**
     * 插入数据(单条)
     *
     * @param collectionName
     */
    public static void insertOne(String collectionName) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        Document document = new Document();
        document.put("name","马保国");
        document.put("age", 69);
        document.put("specialty","浑元太极-闪电五连鞭");
        mongoCollection.insertOne(document);
    }

    /**
     * 批量插入数据
     *
     * @param collectionName
     */
    public static void insertMany(String collectionName) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        Document document1 = new Document();
        document1.put("name","张三疯");
        document1.put("age",88);
        document1.put("specialty","太极拳");
        Document document2 = new Document();
        document2.put("name","卢本伟");
        document2.put("age",33);
        document2.put("specialty","英雄联盟");
        List<Document> documentList = new ArrayList<>();
        documentList.add(document1);
        documentList.add(document2);
        mongoCollection.insertMany(documentList);
    }

    /**
     * 条件查询
     *
     * @param collectionName
     */
    public static void query(String collectionName) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        Document searchQuery = new Document();
        searchQuery.put("name","马保国");
        Iterator iterator = mongoCollection.find(searchQuery).iterator();
        while (iterator.hasNext()) {
            log.info("{}",iterator.next());
        }
    }

    /**
     * 查询全部
     *
     * @param collectionName
     */
    public static void queryAll(String collectionName) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        FindIterable<Document> findIterable = mongoCollection.find();
        Iterator iterator = findIterable.iterator();
        while (iterator.hasNext()) {
            log.info("{}", iterator.next());
        }
    }

    /**
     * 更新
     *
     * @param collectionName
     */
    public static void update(String collectionName) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        mongoCollection.updateOne(Filters.eq("name", "马保国"),
                Updates.set("specialty","浑元太极-闪电五连鞭!!!"));
        queryAll(collectionName);
    }

    /**
     * 更新
     *
     * @param collectionName
     * @param id
     */
    public static void update(String collectionName, String id) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        mongoCollection.updateOne(Filters.eq("_id", new ObjectId(id)), Updates.set("age",66));

        queryAll(collectionName);
    }

    /**
     * 删除单条
     *
     * @param collectionName
     * @param id
     */
    public static void delete(String collectionName, String id) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        mongoCollection.deleteOne(Filters.eq("_id", new ObjectId(id)));

        queryAll(collectionName);
    }

    /**
     * 批量删除
     *
     * @param collectionName
     * @param ids
     */
    public static void deleteBatch(String collectionName, ObjectId[] ids) {
        MongoCollection<Document> mongoCollection = getCollection(collectionName);
        mongoCollection.deleteMany(Filters.in("_id", ids));

        queryAll(collectionName);
    }


}
