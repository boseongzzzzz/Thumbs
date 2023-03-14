package com.boram.life.draft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boram.life.domain.Draft;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface DraftRepository extends JpaRepository<Draft, Long> {

    List<Draft> findAllByDraftStatus(String draftStatus);
}
