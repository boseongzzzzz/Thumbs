package com.boram.life.draft.service;

import com.boram.life.domain.Draft;
import com.boram.life.draft.dto.DraftDTO;
import com.boram.life.draft.repository.DraftRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DraftService {
    private final DraftRepository draftRepository;
    private final ModelMapper modelMapper;

    public DraftService(DraftRepository draftRepository) {
        this.draftRepository = draftRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<DraftDTO> findDrafts() {
        List<Draft> drafts = draftRepository.findAll();
        return drafts.stream().map(draft -> modelMapper.map(draft, DraftDTO.class)).collect(Collectors.toList());
    }
}



