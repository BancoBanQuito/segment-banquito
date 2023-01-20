package com.banquito.segment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/segment")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    //buscar por nombre
    @GetMapping(value = "/{name}")
    public ResponseEntity<SegmentRS> getSegmentByName(@PathVariable("name") String name) {
        Segment segment = this.segmentService.findByName(name);
        if (segment != null) {
            return ResponseEntity.ok(SegmentMapper.toSegmentRS(segment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //buscar todos los segmentos
    @GetMapping()
	public ResponseEntity<List<Segment>> findAll() {
		Iterable<Segment> segment = this.segmentService.findAll();
        return ResponseEntity.ok((List<Segment>) segment);
    }

    //buscar por status
    @GetMapping(value = "/status/{status}")
    public ResponseEntity<SegmentRS> getSegmentByStatus(@PathVariable("status") String status) {
        Segment segment = this.segmentService.findByStatus(status);
        if (segment != null) {
            return ResponseEntity.ok(SegmentMapper.toSegmentRS(segment));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //crear segmento
    @PostMapping
    public ResponseEntity<String> createSegment(@RequestBody SegmentRQ segmentRQ) {
        try {
            this.segmentService.createSegment(SegmentMapper.toSegment(segmentRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("hola");
            return ResponseEntity.internalServerError().build();
        }
    }


    //actualizar segmento
    @PutMapping(value = "/update/{name}")
    public ResponseEntity<String> updateSegment(@PathVariable("name") String name, @RequestBody SegmentRQ segmentRQ) {
        try {
            this.segmentService.updateSegment(name, SegmentMapper.toSegment(segmentRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
