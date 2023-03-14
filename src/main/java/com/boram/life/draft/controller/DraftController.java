package com.boram.life.draft.controller;

import com.boram.life.draft.dto.DraftDTO;
import com.boram.life.draft.service.DraftService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/drafts")
public class DraftController {

    private final DraftService draftService;

    public DraftController(DraftService draftService) {
        this.draftService = draftService;
    }

    @GetMapping
    public ResponseEntity<List<DraftDTO>> getDrafts() {
        List<DraftDTO> drafts = draftService.findDrafts();
        return ResponseEntity.ok(drafts);
    }

}

