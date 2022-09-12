package com.crm.Crm.Repository;

import com.crm.Crm.entity.CrmBaseEntity;
import com.crm.Crm.generic.GenericEntity;
import com.crm.Crm.generic.GenericPagingAndFilteringRepo;
import com.crm.Crm.generic.GenericRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CrmBaseEntityRepo extends GenericRepository<CrmBaseEntity>, GenericPagingAndFilteringRepo<CrmBaseEntity>, JpaSpecificationExecutor<CrmBaseEntity> {
}
