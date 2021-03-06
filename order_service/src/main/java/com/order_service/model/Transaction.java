package com.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Getter
@Setter
@Document(collection = "transactions")
@AllArgsConstructor
public class Transaction {
    @Id
    @Field("_id")
    private ObjectId id;
    private ObjectId accountId;
    @DBRef
    private Order order;
    private BigDecimal price;
    private BigDecimal currentPrice;
    private long volume;
    private ZonedDateTime time;
    private BigDecimal commission;

    public String getId() { return id.toHexString();}
    public String getAccountId() { return accountId.toHexString();}

}