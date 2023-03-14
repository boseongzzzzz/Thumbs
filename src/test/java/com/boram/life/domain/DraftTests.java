package com.boram.life.domain;

import com.boram.life.draft.repository.DraftRepository;
import com.boram.life.draft.service.DraftService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


import static org.junit.Assert.assertEquals;


@DataJpaTest
public class DraftTests {

//    @Autowired
//    private DraftService draftService;

    @PersistenceContext
    EntityManager em;

    @Autowired
    private DraftRepository draftRepository;

    @Test
    void testFindDrafts() {
        // given
        Draft draft = new Draft();
        Attachments attachments1 = new Attachments();

        draft.setDraftId(1323121232L);
        draft.setDraftTitle("제목1");
        attachments1.setAttachmentUuidName("첨부파일1");
        draft.getAttachmentsList().add(attachments1);
        draft.setDraftDate(new Date());
        System.out.println("draft =========================================== " + draft);
        draftRepository.save(draft);


        // when
//        Draft savedDraft1 = draftRepository.findById(draft1.getDraftId()).orElse(null);
//        Draft savedDraft2 = draftRepository.findById(draft2.getDraftId()).orElse(null);



        // then
//        Draft actualDraft = draftRepository.findById(1323121232L).orElse(null);
//        assertEquals("제목1", actualDraft.getDraftTitle());
//        assertEquals(1, actualDraft.getAttachmentsList().size());
//        assertEquals("첨부파일1", actualDraft.getAttachmentsList().get(0).getAttachmentUuidName());

    }
}
