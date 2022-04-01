package com.infy.infyinterns.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.infyinterns.dto.MentorDTO;
import com.infy.infyinterns.dto.ProjectDTO;
import com.infy.infyinterns.entity.Mentor;
import com.infy.infyinterns.entity.Project;
import com.infy.infyinterns.exception.InfyInternException;
import com.infy.infyinterns.repository.MentorRepository;
import com.infy.infyinterns.repository.ProjectRepository;

@Service("projectService")
@Transactional
public class ProjectAllocationServiceImpl implements ProjectAllocationService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	MentorRepository mentorRepository;
	
	@Override
	public Integer allocateProject(ProjectDTO project) throws InfyInternException {

		Mentor mentor = mentorRepository.findById(project.getMentorDTO().getMentorId())
				.orElseThrow(() -> new InfyInternException("Service.MENTOR_NOT_FOUND"));
		Project project2 = new Project();
		if (mentor.getNumberOfProjectsMentored() >= 3) {
		throw new InfyInternException("Service.CANNOT_ALLOCATE_PROJECT");
		} else {
		Project newProject = new Project();
		newProject.setIdeaOwner(project.getIdeaOwner());
		newProject.setMentor(mentor);
		newProject.setProjectName(project.getProjectName());
		newProject.setReleaseDate(project.getReleaseDate());
		newProject.setProjectId(project.getProjectId());
		
		mentor.setNumberOfProjectsMentored(mentor.getNumberOfProjectsMentored()+1);
		
		projectRepository.save(newProject);
		project2 = projectRepository.save(newProject);
		}
		
		
		return project2.getProjectId();
		}


	
	@Override
	public List<MentorDTO> getMentors(Integer numberOfProjectsMentored) throws InfyInternException {
		List<Mentor> mentors = mentorRepository.findByNumberOfProjectsMentored(numberOfProjectsMentored);
		
		if (mentors.isEmpty() || mentors == null) {
			throw new InfyInternException("Service.MENTOR_NOT_FOUND");
		}
		
		List<MentorDTO> mentorDTOs = mentors.stream()
											 .map(mentorEntity -> {
												 MentorDTO dto = new MentorDTO();
												 dto.setMentorId(mentorEntity.getMentorId());
												 dto.setMentorName(mentorEntity.getMentorName());
												 dto.setNumberOfProjectsMentored(mentorEntity.getNumberOfProjectsMentored());
												 return dto;
											 })
											 .collect(Collectors.toList());
		
		return mentorDTOs;
	}


	@Override
	public void updateProjectMentor(Integer projectId, Integer mentorId) throws InfyInternException {
		
		Mentor mentor = mentorRepository.findById(mentorId).orElseThrow(() -> new InfyInternException("Service.MENTOR_NOT_FOUND"));
		
		if (mentor.getNumberOfProjectsMentored() >= 3) {
			throw new InfyInternException("Service.CANNOT_ALLOCATE_PROJECT");
		}
		
		Project project = projectRepository.findById(projectId).orElseThrow(() -> new InfyInternException("Service.PROJECT_NOT_FOUND"));
		
		project.setMentor(mentor);
		mentor.setNumberOfProjectsMentored(mentor.getNumberOfProjectsMentored()+1);

		
	}

	@Override
	public void deleteProject(Integer projectId) throws InfyInternException {
		Project project = projectRepository.findById(projectId).orElseThrow(() -> new InfyInternException("Service.PROJECT_NOT_FOUND"));
		if (project.getMentor() == null) {
			projectRepository.deleteById(projectId);
		} else {
			project.getMentor().setNumberOfProjectsMentored(project.getMentor().getNumberOfProjectsMentored()-1);
			
		}
		
	}
}