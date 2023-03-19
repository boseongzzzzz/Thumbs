package com.boram.life.aprvlDocuments.repository;

import java.util.List;

import com.boram.life.aprvlDocuments.dto.DraftDTO;
import com.boram.life.domain.Documents;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<Documents, Long> {
    @Query("SELECT new com.boram.life.aprvlDocuments.dto.DraftDTO(d.documentNo, f.formName, d.documentTitle, m.memberName, a.attachmentUuidName, d.documentDraftDate) " +
            "FROM Documents d JOIN d.approvalMember1 m LEFT JOIN d.attachmentsList a JOIN d.form f " +
            "WHERE d.documentStatus = 2")
    List<DraftDTO> findAllByDraftStatus(@Param("d.draftStatus") int draftStatus);

    Documents findByDocumentNo(Long documentNo);
    
}
