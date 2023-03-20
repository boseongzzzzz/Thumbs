package com.boram.life.approval.repository;

import java.util.List;

import com.boram.life.approval.dto.DraftDTO;
import com.boram.life.domain.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DraftRepository extends JpaRepository<Documents, Long> {
    @Query("SELECT new com.boram.life.approval.dto.DraftDTO(d.documentNo, f.formName, d.documentStatus, d.documentTitle, m.memberName, a.attachmentUuidName, d.documentDraftDate) " +
            "FROM Documents d JOIN d.approvalMember1 m LEFT JOIN d.attachmentsList a JOIN d.form f " +
            "WHERE d.documentStatus IN (1,2,3) AND m.memberName = :memberName")
    List<DraftDTO> findAllByDraftStatusAndMemberName(@Param("memberName") String memberName);

    @Query("SELECT new com.boram.life.approval.dto.DraftDTO(d.documentNo, f.formName, d.documentStatus, d.documentTitle, m.memberName, a.attachmentUuidName, d.documentDraftDate) " +
            "FROM Documents d JOIN d.approvalMember1 m LEFT JOIN d.attachmentsList a JOIN d.form f " +
            "WHERE d.documentStatus IN (2,3) AND (d.approvalMember2 = :memberName OR d.approvalMember3 = :memberName)")
    List<DraftDTO> findAllByApprovalMember(@Param("memberName") String memberName);

    Documents findByDocumentNo(Long documentNo);
    
}
