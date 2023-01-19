package com.banquito.segment.repository;

import com.banquito.segment.model.Segment;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends MongoRepository<Segment, String>{

    Segment findBySegmentId(String id);

    Optional<Segment> findBySegmentName(String name);
}
