package com.crm.Crm.repository;

import com.crm.Crm.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
    List<Note> findAllByCrmBaseEntityId(Long id);

}
