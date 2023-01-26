package com.banquito.segment.controller.mapper;

import com.banquito.segment.controller.dto.SegmentRQ;
import com.banquito.segment.controller.dto.SegmentRS;
import com.banquito.segment.model.Segment;

public class SegmentMapper {
    
    public static Segment toSegment(SegmentRQ segmentRQ) {
        return Segment.builder()
                .name(segmentRQ.getName())
                .status(segmentRQ.getStatus())
                .build();
    }

    public static SegmentRS toSegmentRS(Segment segment) {
        return SegmentRS.builder()
                .idSegment(segment.getIdSegment())
                .name(segment.getName())
                .status(segment.getStatus())
                .build();
    }
}
