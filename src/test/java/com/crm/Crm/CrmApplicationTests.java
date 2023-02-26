package com.crm.Crm;

import com.crm.Crm.dto.ContactDto;
import com.crm.Crm.entity.Contact;
import com.crm.Crm.mapper.ContactMapper;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.service.ContactService;
import com.crm.Crm.service.impl.ContactServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ComponentScan
@RunWith(SpringRunner.class)

class CrmApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private ContactServiceImpl contactService;

	@Mock
	private ContactRepository contactRepository;

//	@Autowired
//	private ContactMapper contactMapper;

//	@Test
//	public void testUpdateContactDetails() {
//		// Create a mock Contact object
//		Contact mockContact = new Contact();
//		mockContact.setId(1L);
//		mockContact.setFirstName("John");
//		mockContact.setLastName("Doe");
//		mockContact.setAddress("123 Main St");
//		mockContact.setEmail("john.doe@example.com");
//
//		// Create a mock ContactDto object
//		ContactDto mockContactDto = new ContactDto();
//		mockContactDto.setFirstName("Jane");
//		mockContactDto.setLastName("Doe");
//		mockContactDto.setAddress("456 Main St");
//		mockContactDto.setEmail("jane.doe@example.com");
//
//		// Set up the mock ContactRepository to return the mock Contact when findById is called
//		when(contactRepository.findById(1L)).thenReturn(Optional.of(mockContact));
//
//		// Call the updateContactDetails method
//		ContactDto updatedContactDto = contactService.updateContactDetails(1L, mockContactDto);
//
//		// Verify that the ContactRepository was called with the correct ID
//		//verify(contactRepository).findById(1L);
//
//		// Verify that the mock Contact was updated with the values from the mock ContactDto
//		assertEquals("Jane", mockContact.getFirstName());
//		assertEquals("Doe", mockContact.getLastName());
//		assertEquals("456 Main St", mockContact.getAddress());
//		assertEquals("jane.doe@example.com", mockContact.getEmail());
//
//		// Verify that the ContactMapper was called with the mock Contact object
//		//verify(contactMapper).toDto(mockContact);
//
//		// Verify that the ContactDto returned by the method matches the mock ContactDto
//		assertEquals("Jane", updatedContactDto.getFirstName());
//		assertEquals("Doe", updatedContactDto.getLastName());
//		assertEquals("456 Main St", updatedContactDto.getAddress());
//		assertEquals("jane.doe@example.com", updatedContactDto.getEmail());
//	}

}
