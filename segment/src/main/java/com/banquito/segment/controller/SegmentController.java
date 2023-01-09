package com.banquito.segment.controller;

import com.banquito.segment.model.Segment;
import com.banquito.segment.service.SegmentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/segment")
public class SegmentController {
    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Segment> findById() {
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object create() {
        return ResponseEntity.status(200).body("Segment created");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Object updateById() {
        return ResponseEntity.status(200).body("Segment updated");
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public Object deleteByID() {
        return ResponseEntity.status(200).body("Segment deleted");
    }

}
