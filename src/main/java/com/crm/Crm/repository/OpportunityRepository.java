package com.crm.Crm.repository;

import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity,Long> {
    public List<Opportunity> findAllByStage(OpportunityStageEnum stage);

    @Query("select count(*) from Opportunity")
    int countOpportunities();

}
