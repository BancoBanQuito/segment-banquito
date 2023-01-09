package com.banquito.segment.repository;

import com.banquito.segment.model.Segment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends MongoRepository<Segment, String>{
    
}
