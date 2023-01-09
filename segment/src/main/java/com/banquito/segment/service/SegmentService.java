package com.banquito.segment.service;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.segment.model.Segment;
import com.banquito.segment.repository.SegmentRepository;

@Service
public class SegmentService {
    private final SegmentRepository segmentRepository;

    public SegmentService(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    public Optional<Segment> findById(String id){
        return segmentRepository.findById(id);
    }

    @Transactional
    public Segment update(Segment segment) {
        return segmentRepository.save(segment);
    }

    @Transactional
    public void delete(String id){
        segmentRepository.deleteById(id);
    }

    @Transactional
    public Segment create(Segment segment){
        return segmentRepository.insert(segment);
    }
}
