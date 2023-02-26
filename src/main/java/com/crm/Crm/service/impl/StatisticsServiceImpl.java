package com.crm.Crm.service.impl;

import com.crm.Crm.dto.StatisticsDto;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.repository.FileRepository;
import com.crm.Crm.repository.NoteRepository;
import com.crm.Crm.repository.OpportunityRepository;
import com.crm.Crm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private ContactService contactService;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private NoteService noteService;
    @Autowired
    private OpportunityService opportunityService;
    @Override
    public StatisticsDto getStatistics() {
        int contactsCount= contactService.countContacts();
        int fileCount= fileUploadService.countFiles();
        int opportunityCount=opportunityService.countOpportunities();
        int noteCount= noteService.countNotes();
        return new StatisticsDto(contactsCount,opportunityCount,noteCount,fileCount);
    }
}
