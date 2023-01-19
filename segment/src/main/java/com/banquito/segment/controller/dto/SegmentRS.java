package com.banquito.segment.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SegmentRS implements Serializable{
    
        private String id;
        private String name;
        private Boolean status;
}
