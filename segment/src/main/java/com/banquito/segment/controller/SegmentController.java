package com.banquito.segment.controller;

import com.banquito.segment.controller.dto.SegmentRS;
import com.banquito.segment.controller.mapper.SegmentMapper;
import com.banquito.segment.model.Segment;
import com.banquito.segment.service.SegmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/segment")
public class SegmentController {
    
    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping(value = "/{idSegment}")
    public ResponseEntity<SegmentRS> getSegmentById(@PathVariable("idSegment") String id){
        Segment segment = this.segmentService.findById(id);
        if (segment != null){
            return ResponseEntity.ok(SegmentMapper.toSegmentRS(segment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
