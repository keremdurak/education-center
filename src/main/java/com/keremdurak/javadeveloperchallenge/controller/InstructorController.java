package com.keremdurak.javadeveloperchallenge.controller;

import com.keremdurak.javadeveloperchallenge.dto.CreateInstructorRequest;
import com.keremdurak.javadeveloperchallenge.dto.InstructorDto;
import com.keremdurak.javadeveloperchallenge.dto.UpdateInstructorRequest;
import com.keremdurak.javadeveloperchallenge.service.InstructorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/instructor")
@Api(value = "Instructor API ")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping()
    @ApiOperation(value = "Get All Instructors ")
    public ResponseEntity<List<InstructorDto>> getAllInstructor() {
        return ResponseEntity.ok(instructorService.getAllInstructor());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Instructor By Id ")
    public ResponseEntity<InstructorDto> getAllInstructors(@PathVariable("id") @ApiParam(value = "Id") String id) {
        return ResponseEntity.ok(instructorService.getInstructorById(id));
    }

    @PostMapping
    @ApiOperation(value = "Create Instructor ")
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody
                                                          @ApiParam(value = "Create Request")
                                                                  CreateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.createInstructor(request));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Instructor ")
    public ResponseEntity<InstructorDto> updateInstructor(@PathVariable String id,
                                                          @RequestBody
                                                          @ApiParam(value = "Update Request")
                                                                  UpdateInstructorRequest request) {
        return ResponseEntity.ok(instructorService.updateInstructor(id, request));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Instructor ", notes = "Eğitmenin bağlı kurs varsa önce kurslar silinmeli yoksa silmez!")
    public ResponseEntity<InstructorDto> deleteInstructor(@PathVariable("id") @ApiParam(value = "Delete Request Id")
                                                                  String id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.ok().build();
    }


}
