package com.crm.Crm.service.impl;

import com.crm.Crm.dto.StatisticsDto;
import com.crm.Crm.repository.ContactRepository;
import com.crm.Crm.repository.FileRepository;
import com.crm.Crm.repository.NoteRepository;
import com.crm.Crm.repository.OpportunityRepository;
import com.crm.Crm.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Override
    public StatisticsDto getStatistics() {
        int contactsCount= contactRepository.countContacts();
        int fileCount= fileRepository.countFiles();
        int opportunityCount=opportunityRepository.countOpportunities();
        int noteCount= noteRepository.countNotes();

        return new StatisticsDto(contactsCount,opportunityCount,noteCount,fileCount);
    }
}
