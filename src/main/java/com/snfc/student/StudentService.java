package com.snfc.student;

import java.util.List;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

public class StudentService {
    static AmazonDynamoDB dynamoDBClient = AmazonDynamoDBClientBuilder.defaultClient();
    static DynamoDBMapper mapper = new DynamoDBMapper(dynamoDBClient);
    
    public static List<Student> fetchAll() {
        return mapper.scan(Student.class, new DynamoDBScanExpression());
    }
    
    public static int insertStudent(Student student) {
        mapper.save(student);
        return student.getId();
    }

}
