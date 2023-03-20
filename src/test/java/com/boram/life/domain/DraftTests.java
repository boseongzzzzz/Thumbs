package com.boram.life.domain;

import com.boram.life.approval.repository.DraftRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import static org.junit.Assert.assertEquals;

@Rollback(value = false)
@Slf4j
@Transactional
@SpringBootTest
public class DraftTests {

    @PersistenceContext
    EntityManager em;

    @Autowired
    private DraftRepository draftRepository;

    @Test
    void testFindDrafts() {
        // given
        Draft draft = new Draft();
        Attachments attachments1 = new Attachments();

       // draft.setDraftId(1323121232L);
        draft.setDraftTitle("테스트기안1");
        attachments1.setAttachmentUuidName("첨부파일1");
        draft.getAttachmentsList().add(attachments1);
        draft.setDraftDate(new Date());
//        System.out.println("draft =========================================== " + draft);

        draftRepository.save(draft);


        // when
//        Draft savedDraft1 = draftRepository.findById(draft1.getDraftId()).orElse(null);
//        Draft savedDraft2 = draftRepository.findById(draft2.getDraftId()).orElse(null);



        // then
        Draft actualDraft = draftRepository.findById(10L).orElse(null);
        assertEquals("테스트기안1", actualDraft.getDraftTitle());
        assertEquals(1, actualDraft.getAttachmentsList().size());
        assertEquals("첨부파일1", actualDraft.getAttachmentsList().get(0).getAttachmentUuidName());

    }
}
