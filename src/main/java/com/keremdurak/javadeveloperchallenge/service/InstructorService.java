package com.keremdurak.javadeveloperchallenge.service;

import com.keremdurak.javadeveloperchallenge.dto.CreateInstructorRequest;
import com.keremdurak.javadeveloperchallenge.dto.InstructorDto;
import com.keremdurak.javadeveloperchallenge.dto.UpdateInstructorRequest;
import com.keremdurak.javadeveloperchallenge.dto.converter.InstructorDtoConverter;
import com.keremdurak.javadeveloperchallenge.exception.InstructorNotDeleteException;
import com.keremdurak.javadeveloperchallenge.exception.InstructorNotFoundException;
import com.keremdurak.javadeveloperchallenge.model.Instructor;
import com.keremdurak.javadeveloperchallenge.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorDtoConverter converter;


    public InstructorService(InstructorRepository instructorRepository,
                             InstructorDtoConverter converter) {
        this.instructorRepository = instructorRepository;
        this.converter = converter;


    }


    public List<InstructorDto> getAllInstructor() {
        return instructorRepository.findAll()
                .stream()
                .map(converter::convertToInstructorDto)
                .collect(Collectors.toList());
    }

    public InstructorDto getInstructorById(String id) {
        return converter.convertToInstructorDto(findInstructorById(id));
    }

    public InstructorDto createInstructor(CreateInstructorRequest request) {

        Instructor instructor = new Instructor(
                request.getInstructorName(),
                request.getInstructorSurname()
        );
        return converter.convertToInstructorDto(instructorRepository.save(instructor));
    }

    @Transactional
    public InstructorDto updateInstructor(String id, UpdateInstructorRequest request) {
        Instructor instructorId = findInstructorById(id);
        Instructor updatedInstructor = new Instructor(
                instructorId.getId(),
                request.getInstructorName(),
                request.getInstructorSurname()
        );
        return converter.convertToInstructorDto(instructorRepository.save(updatedInstructor));

    }

    public void deleteInstructor(String id) {
        findInstructorById(id);
        try {
            instructorRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new InstructorNotDeleteException("Instructor could not delete");
        }
    }

    protected Instructor findInstructorById(String id) {
        return instructorRepository.findById(id)
                .orElseThrow(
                        () -> new InstructorNotFoundException("Instructor could not find by id: " + id)
                );
    }


}
