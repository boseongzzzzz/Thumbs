package com.boram.life.admin.service;

import com.boram.life.admin.dto.AdditionalMemberInfoDTO;
import com.boram.life.admin.dto.EssentialMemberInfoDTO;
import com.boram.life.admin.repository.ManageMemberRepository;
import com.boram.life.domain.Member;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminService {
    private static final Logger log = LoggerFactory.getLogger(AdminService.class);

    private final ManageMemberRepository manageMemberRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AdminService(ManageMemberRepository manageMemberRepository, ModelMapper modelMapper) {

        this.manageMemberRepository = manageMemberRepository;
        this.modelMapper = modelMapper;
    }

    // 필수 정보로 회원가입
    @Transactional
    public int registerMember(EssentialMemberInfoDTO eMemberInfo) {

        log.info("[AdminService] 회원 등록 메소드 시작 ===================================");
        log.info("[AdminService] 회원 필수 정보 : " + eMemberInfo);

        int result = 0;

        try {

            // 필수 정보 등록
            Member registerMember = modelMapper.map(eMemberInfo, Member.class);
            manageMemberRepository.save(registerMember);

            result = 1;

        } catch (
                Exception e) {

            log.info("[AdminService] 회원 등록 메소드에서 예외 발생!!");
            throw new RuntimeException(e);

        }

        log.info("[AdminService] 회원 등록 메소드 종료 : 결과값 " + result + " 를 반환.");

        return result;

    }

    // 부가 정보로 업데이트
    @Transactional
    public int registerMember(EssentialMemberInfoDTO eMemberInfo, AdditionalMemberInfoDTO aMemberInfo) {

        log.info("[AdminService] 회원 등록(추가정보) 메소드 시작 ===================================");
        log.info("[AdminService] 회원 필수 정보 : " + eMemberInfo);
        log.info("[AdminService] 회원 부가 정보 : " + aMemberInfo);

        int result = 0;

        try {

            // 부가 정보가 있을 시 등록
            if (aMemberInfo != null) {

                Member registerMember = modelMapper.map(aMemberInfo, Member.class);

                Member updateMember = manageMemberRepository.findById(registerMember.getMemberNo().intValue()).get();

                if (aMemberInfo.getMemberId() == updateMember.getMemberId()) {

                    // 이메일
                    if (aMemberInfo.getMemberEmail() != null) {
                        updateMember.setMemberEmail(aMemberInfo.getMemberEmail());
                    }

                    // 주소
                    if (aMemberInfo.getMemberAddress() != null) {
                        updateMember.setMemberAddress(aMemberInfo.getMemberAddress());
                    }

                    // 소개
                    if (aMemberInfo.getMemberIntroduction() != null) {
                        updateMember.setMemberIntroduction(aMemberInfo.getMemberIntroduction());
                    }

                    result = 2;

                }
            }

        } catch (Exception e) {

            log.info("[AdminService] 회원 등록 메소드에서 예외 발생!!");
            throw new RuntimeException(e);

        }

        log.info("[AdminService] 회원 등록 메소드 종료 : 결과값 " + result + " 를 반환.");
        return result;

    }
}
