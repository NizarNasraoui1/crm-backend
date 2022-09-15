package com.crm.Crm.repository;

import com.crm.Crm.entity.Opportunity;
import com.crm.Crm.enumeration.OpportunityStageEnum;
import javafx.stage.Stage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends CrmBaseEntityRepository {
    public List<Opportunity> findAllByStage(OpportunityStageEnum stage);

    //public List<Opportunity> findAllBy;

}
