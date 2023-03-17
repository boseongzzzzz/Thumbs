package com.boram.life.aprvlDocuments.service;

import com.boram.life.domain.Draft;
import com.boram.life.aprvlDocuments.dto.DraftDTO;
import com.boram.life.aprvlDocuments.repository.DraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AprvlDocsService {
    private final DraftRepository draftRepository;
    private final ModelMapper modelMapper;

    public AprvlDocsService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<DraftDTO> findAllByDraftStatus(Pageable pageable) {
        List<DraftDTO> drafts = draftRepository.findAllByDraftStatus(2);
        System.out.println("drafts =0000000000000 " + drafts);
        return drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }

}



