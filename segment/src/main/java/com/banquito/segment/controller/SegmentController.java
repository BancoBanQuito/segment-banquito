package com.banquito.segment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.segment.controller.dto.SegmentRQ;
import com.banquito.segment.controller.dto.SegmentRS;
import com.banquito.segment.controller.mapper.SegmentMapper;
import com.banquito.segment.model.Segment;
import com.banquito.segment.service.SegmentService;

@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
@RestController
@RequestMapping("/api/segments")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<SegmentRS> getSegmentByName(@PathVariable("name") String name) {
        Segment segment = this.segmentService.findByName(name);
        if (segment != null) {
            return ResponseEntity.ok(SegmentMapper.toSegmentRS(segment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
	public ResponseEntity<List<Segment>> findAll() {
		Iterable<Segment> segment = this.segmentService.findAll();
        return ResponseEntity.ok((List<Segment>) segment);
    }

    @PostMapping
    public ResponseEntity<String> createSegmentByIdSegment(@RequestBody SegmentRQ segmentRQ) {
        try {
            this.segmentService.createSegmentByIdSegment(SegmentMapper.toSegment(segmentRQ));
            return ResponseEntity.ok().body("Segmento creado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PutMapping(value = "/update/{name}")
    public ResponseEntity<String> updateSegment(@PathVariable("name") String name, @RequestBody SegmentRQ segmentRQ) {
        try {
            this.segmentService.updateSegment(name, SegmentMapper.toSegment(segmentRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping(value = "/updates/{idSegment}")
    public ResponseEntity<String> updateSegmentByIdSegment(@PathVariable("idSegment") String idSegment, @RequestBody SegmentRQ segmentRQ) {
        try {
            this.segmentService.updateSegmentByIdSegment(idSegment, SegmentMapper.toSegment(segmentRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
