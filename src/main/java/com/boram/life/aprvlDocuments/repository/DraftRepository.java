package com.boram.life.aprvlDocuments.repository;

import java.util.List;

import com.boram.life.aprvlDocuments.dto.DraftDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.boram.life.domain.Draft;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<Draft, Long> {
    @Query("SELECT new com.boram.life.aprvlDocuments.dto.DraftDTO(d.draftId, d.draftTitle, m.memberName, a.attachmentUuidName, d.draftDate) " +
            "FROM Draft d JOIN d.draftMember1 m LEFT JOIN d.attachmentsList a " +
            "WHERE d.draftStatus = 2")
    List<DraftDTO> findAllByDraftStatus(@Param("d.draftStatus") int draftStatus);
}
