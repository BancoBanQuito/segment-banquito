package com.banquito.segment.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SegmentRQ implements Serializable{

    private String name;
    private String status;
}
