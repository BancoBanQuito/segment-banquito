package com.banquito.segment.service;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.segment.controller.dto.SegmentRQ;
import com.banquito.segment.model.Segment;
import com.banquito.segment.repository.SegmentRepository;


@Service
public class SegmentService {

    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public Segment findById(String id){
        Segment opSegment = segmentRepository.findBySegmentId(id);
        if (opSegment == null){
            throw new RuntimeException("Segment not found");
        }
        return this.segmentRepository.findBySegmentId(id);
    }

    @Transactional
    public void createSegment(Segment segment){
        Optional<Segment> opSegment = segmentRepository.findBySegmentName(segment.getName());
        if(opSegment.isPresent()){
            throw new RuntimeException("Segment already exists");
        }
        segment.setName(segment.getName());
        segment.setStatus(false);
        this.segmentRepository.save(segment);
    }

    @Transactional
    public void updateSegment(String id, SegmentRQ segmentRQ){
        Segment opSegment = segmentRepository.findBySegmentId(id);
        if(opSegment == null){
            throw new RuntimeException("Segment not exists");
        }
        Segment segmentUpdate = this.segmentRepository.findBySegmentId(id);
        segmentUpdate.setName(segmentRQ.getName());
        segmentUpdate.setStatus(segmentRQ.getStatus());
        this.segmentRepository.save(segmentUpdate);
    }

    @Transactional
    public Segment deleteSegment(Segment segment){
        Segment opSegment = segmentRepository.findBySegmentId(segment.getId());
        if(opSegment == null){
            throw new RuntimeException("Segment not exists");
        }
        Segment segmentDelete = this.segmentRepository.findBySegmentId(segment.getId());
        segmentDelete.setName(segment.getName());
        segmentDelete.setStatus(false);
        this.segmentRepository.save(segmentDelete);
        return segmentDelete;
    }
}
