package com.banquito.segment.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.segment.model.Segment;
import com.banquito.segment.repository.SegmentRepository;
import com.fasterxml.jackson.core.sym.Name;

@Service
public class SegmentService {
    
    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public Segment findByName(String name) {
        Segment optSegment = this.segmentRepository.findByName(name);
        if (optSegment == null) {
            throw new RuntimeException("Segment not found");
        }
        return this.segmentRepository.findByName(name);
    }

    //buscar por Optional<Segment> findByStatus(String status)
    public Segment findByStatus(String status) {
        Segment optSegment = this.segmentRepository.findByStatus(status).orElseThrow(() -> new RuntimeException("Segment not found"));
        return optSegment;
    }

    //buscar todos los segmentos
    public Iterable<Segment> findAll() {
        return this.segmentRepository.findAll();
    }

    //crear segmento
    @Transactional
    public void createSegment(Segment segment){
        Boolean segmentExists = this.segmentRepository.existsByName(segment.getName());
        if(segmentExists){
            throw new RuntimeException("Segment already exists");
        }
        segment.setName(segment.getName());
        segment.setStatus(segment.getStatus());
        this.segmentRepository.save(segment);
    }

    @Transactional
    public void updateSegment(String name, Segment segment) {
        Boolean segmentExists = this.segmentRepository.existsByName(name);
        if (segmentExists) {
            throw new RuntimeException("Client not found");
        }
        Segment segmentToUpdate = this.segmentRepository.findByName(name);
        segmentToUpdate.setStatus(segment.getStatus());
        this.segmentRepository.save(segmentToUpdate);
    }

}
