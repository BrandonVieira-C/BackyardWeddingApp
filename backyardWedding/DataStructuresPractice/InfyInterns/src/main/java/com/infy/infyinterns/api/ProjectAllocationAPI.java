package com.infy.infyinterns.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.infyinterns.dto.MentorDTO;
import com.infy.infyinterns.dto.ProjectDTO;
import com.infy.infyinterns.exception.InfyInternException;
import com.infy.infyinterns.service.ProjectAllocationService;

@RestController
@RequestMapping(value="infyinterns")
@Validated
public class ProjectAllocationAPI
{
	@Autowired
	ProjectAllocationService projectAllocationService;
	
	@Autowired
	Environment environment;
	

    // add new project along with mentor details
	@PostMapping(value="/project")
    public ResponseEntity<String> allocateProject(@Valid @RequestBody ProjectDTO project) throws InfyInternException
    {
		Integer num = projectAllocationService.allocateProject(project);
		String successMessage = environment.getProperty("API.ALLOCATION_SUCCESS") + num;

		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    // get mentors based on idea owner
	@GetMapping(value="/getMentors/{numOfProjects}")
    public ResponseEntity<List<MentorDTO>> getMentors(@PathVariable("numOfProjects") Integer numberOfProjectsMentored) throws InfyInternException
    {
		List<MentorDTO> list = projectAllocationService.getMentors(numberOfProjectsMentored);

	return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // update the mentor of a project
	@PutMapping(value="/project/{projectId}/{mentorId}")
    public ResponseEntity<String> updateProjectMentor(@PathVariable Integer projectId,
    		@PathVariable @Valid Integer mentorId) throws InfyInternException
    {
		projectAllocationService.updateProjectMentor(projectId, mentorId);
		String successMessage = environment.getProperty("API.PROJECT_UPDATRE_SUCCESS");

	return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    // delete a project
	@DeleteMapping(value="/project/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) throws InfyInternException
    {
		projectAllocationService.deleteProject(projectId);
		String successMessage = environment.getProperty("API.PROJECT_DELETE_SUCCESS");
	return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

}
