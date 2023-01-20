package com.banquito.segment.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "segments")
@CompoundIndexes({
        @CompoundIndex(name = "idux_idSegmentAndName", def = "{'idSegment': 1, 'name': 1}", unique = true)
})
public class Segment {

    @Id
    private String id;
    private String idSegment;

    private String name;
    private String status;

    @Version
    private Long version;
}
