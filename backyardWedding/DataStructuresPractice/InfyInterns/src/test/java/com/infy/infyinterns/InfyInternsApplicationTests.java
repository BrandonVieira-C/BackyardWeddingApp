package com.infy.infyinterns;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.infyinterns.dto.MentorDTO;
import com.infy.infyinterns.dto.ProjectDTO;
import com.infy.infyinterns.entity.Mentor;
import com.infy.infyinterns.repository.MentorRepository;
import com.infy.infyinterns.service.ProjectAllocationService;
import com.infy.infyinterns.service.ProjectAllocationServiceImpl;

@SpringBootTest
public class InfyInternsApplicationTests {

	@Mock
	private MentorRepository mentorRepository;

	@InjectMocks
	private ProjectAllocationService projectAllocationService = new ProjectAllocationServiceImpl();

	@Test
	public void allocateProjectCannotAllocateTest() throws Exception {

		Mentor mentor = new Mentor();
		mentor.setNumberOfProjectsMentored(5);
		MentorDTO mentorDTO = new MentorDTO();
		mentorDTO.setNumberOfProjectsMentored(5);
		mentorDTO.setMentorId(9999);
		mentorDTO.setMentorName("Bobby");
	
		
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setMentorDTO(mentorDTO);
		
		Mockito.when(mentorRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(mentor));
		
		Exception exception = Assertions.assertThrows(Exception.class, () -> projectAllocationService.allocateProject(projectDTO));
		Assertions.assertEquals("Service.CANNOT_ALLOCATE_PROJECT", exception.getMessage());

	}

	
	public void allocateProjectMentorNotFoundTest() throws Exception {
	
		

	}
}