package com.banquito.segment.repository;

import com.banquito.segment.model.Segment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends MongoRepository<Segment, String>{

    Segment findByName(String name);

    List<Segment> findAll();

    Boolean existsByName(String name);

    Segment findByIdSegment(String idSegment);

    Boolean existsByIdSegment(String idSegment);

}
