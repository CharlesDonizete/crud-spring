package com.charles.crudspring.dto.mapper;

import java.util.List;

import com.charles.crudspring.dto.CourseDTO;

public record CoursePageDTO(List<CourseDTO> courses, long totalElements, int totalPages) {

}
