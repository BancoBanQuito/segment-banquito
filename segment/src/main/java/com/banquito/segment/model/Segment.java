package com.banquito.segment.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "segments")

public class Segment {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field(value = "name")
    private String name;

    @Field(value = "status")
    private Boolean status;

    @Version
    private Long version;
}
