package com.boram.life.domain;

import com.boram.life.aprvlDocuments.controller.AprvlDocsController;
import com.boram.life.aprvlDocuments.dto.DraftDTO;
import com.boram.life.aprvlDocuments.repository.DraftRepository;
import com.boram.life.aprvlDocuments.service.AprvlDocsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class AprvlDocsControllerTest {

    @Autowired
    private AprvlDocsController aprvlDocsController;

    @Autowired
    private AprvlDocsService aprvlDocsService;

    @Autowired
    private DraftRepository draftRepository;

    @Test
    public void testGetAllDrafts() {
        // Given
//        Draft draft1 = new Draft();
//        draft1.setDraftTitle("Draft 1");
//        draft1.setDraftStatus(2);
//        draftRepository.save(draft1);
//
//        Draft draft2 = new Draft();
//        draft2.setDraftTitle("Draft 2");
//        draft2.setDraftStatus(2);
//        draftRepository.save(draft2);
//
//        Draft draft3 = new Draft();
//        draft3.setDraftTitle("Draft 3");
//        draft3.setDraftStatus(3);
//        draftRepository.save(draft3);
//
//        // When
//        Model model = new ExtendedModelMap();
//        String viewName = aprvlDocsController.getAllDrafts(model, 0, 10);
//
//        // Then
//        assertEquals("/draft", viewName);
//        List<DraftDTO> drafts = (List<DraftDTO>) model.asMap().get("drafts");
//        assertEquals(2, drafts.size());
//        assertEquals("Draft 1", drafts.get(0).getDraftTitle());
//        assertEquals("Draft 2", drafts.get(1).getDraftTitle());
    }
}

