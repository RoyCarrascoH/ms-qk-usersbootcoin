package com.quarkus.bootcamp.nttdata.domain.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "users")
public class Users {

    private ObjectId id;
    private String walletId;
    private Long cardId;
    private String documentType;
    private String documentNumber;
    private String cellphone;
    private String email;
}
