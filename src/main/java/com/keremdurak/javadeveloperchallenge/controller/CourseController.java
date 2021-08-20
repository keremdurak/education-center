package com.keremdurak.javadeveloperchallenge.controller;

import com.keremdurak.javadeveloperchallenge.dto.CourseDto;
import com.keremdurak.javadeveloperchallenge.dto.CreateCourseRequest;
import com.keremdurak.javadeveloperchallenge.dto.UpdateCourseRequest;
import com.keremdurak.javadeveloperchallenge.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/course")
@Api(value = "Course API ")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    @ApiOperation(value = "Get All Courses ")
    public ResponseEntity<List<CourseDto>> getAllCourse() {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Course By Id")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") String id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create Course ")
    public ResponseEntity<CourseDto> createCourse(@RequestBody @ApiParam(value = "Create Request")
                                                          CreateCourseRequest request) {
        return ResponseEntity.ok(courseService.createCourse(request));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Course ")
    public ResponseEntity<CourseDto> updateCourse(@PathVariable String id,
                                                  @RequestBody @ApiParam(value = "Update Request")
                                                          UpdateCourseRequest request) {
        return ResponseEntity.ok(courseService.updateCourse(id, request));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Course ")
    public ResponseEntity<CourseDto> deleteCourse(@PathVariable("id") @ApiParam(value = "Delete Request Id")
                                                          String id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

}
