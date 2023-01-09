package com.banquito.segment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "segment")

public class Segment {
    @Id
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "status")
    private String status;

}
