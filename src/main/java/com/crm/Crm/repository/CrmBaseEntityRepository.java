package com.crm.Crm.repository;

import com.crm.Crm.entity.CrmBaseEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface CrmBaseEntityRepository extends JpaRepository<CrmBaseEntity,Long>,JpaSpecificationExecutor<CrmBaseEntity> {
}
