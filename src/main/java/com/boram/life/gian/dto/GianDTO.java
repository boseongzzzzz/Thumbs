package com.boram.life.gian.dto;

import com.boram.life.domain.Attachments;
import com.boram.life.domain.Documents;
import com.boram.life.domain.Member;
import com.boram.life.domain.Reject;

import java.util.Date;

public class GianDTO {

    private Long draftId;

    private String draftTitle;

    private String draftDetails;

    private Date draftDate;

    private String draftStatus;

    private Date draftFinalApprove;

    private Reject DraftReject;

    private Documents document;

    private String attachmentsUrl;

    private Member draftMember1;

    private String draftMember2;

    private String draftMember3;

    public Long getDraftId() {
        return draftId;
    }

    public void setDraftId(Long draftId) {
        this.draftId = draftId;
    }

    public String getDraftTitle() {
        return draftTitle;
    }

    public void setDraftTitle(String draftTitle) {
        this.draftTitle = draftTitle;
    }

    public String getDraftDetails() {
        return draftDetails;
    }

    public void setDraftDetails(String draftDetails) {
        this.draftDetails = draftDetails;
    }

    public Date getDraftDate() {
        return draftDate;
    }

    public void setDraftDate(Date draftDate) {
        this.draftDate = draftDate;
    }

    public String getDraftStatus() {
        return draftStatus;
    }

    public void setDraftStatus(String draftStatus) {
        this.draftStatus = draftStatus;
    }

    public Date getDraftFinalApprove() {
        return draftFinalApprove;
    }

    public void setDraftFinalApprove(Date draftFinalApprove) {
        this.draftFinalApprove = draftFinalApprove;
    }

    public Reject getDraftReject() {
        return DraftReject;
    }

    public void setDraftReject(Reject draftReject) {
        DraftReject = draftReject;
    }

    public Documents getDocument() {
        return document;
    }

    public void setDocument(Documents document) {
        this.document = document;
    }

    public String getAttachmentsUrl() {
        return attachmentsUrl;
    }

    public void setAttachmentsUrl(String attachmentsUrl) {
        this.attachmentsUrl = attachmentsUrl;
    }

    public Member getDraftMember1() {
        return draftMember1;
    }

    public void setDraftMember1(Member draftMember1) {
        this.draftMember1 = draftMember1;
    }

    public String getDraftMember2() {
        return draftMember2;
    }

    public void setDraftMember2(String draftMember2) {
        this.draftMember2 = draftMember2;
    }

    public String getDraftMember3() {
        return draftMember3;
    }

    public void setDraftMember3(String draftMember3) {
        this.draftMember3 = draftMember3;
    }

    public GianDTO() {
    }

    public GianDTO(Long draftId, String draftTitle, String draftDetails, Date draftDate, String draftStatus, Date draftFinalApprove, Reject draftReject, Documents document, String attachmentsUrl, Member draftMember1, String draftMember2, String draftMember3) {
        this.draftId = draftId;
        this.draftTitle = draftTitle;
        this.draftDetails = draftDetails;
        this.draftDate = draftDate;
        this.draftStatus = draftStatus;
        this.draftFinalApprove = draftFinalApprove;
        DraftReject = draftReject;
        this.document = document;
        this.attachmentsUrl = attachmentsUrl;
        this.draftMember1 = draftMember1;
        this.draftMember2 = draftMember2;
        this.draftMember3 = draftMember3;
    }

    @Override
    public String toString() {
        return "GianDTO{" +
                "draftId=" + draftId +
                ", draftTitle='" + draftTitle + '\'' +
                ", draftDetails='" + draftDetails + '\'' +
                ", draftDate=" + draftDate +
                ", draftStatus='" + draftStatus + '\'' +
                ", draftFinalApprove=" + draftFinalApprove +
                ", DraftReject=" + DraftReject +
                ", document=" + document +
                ", attachmentsUrl='" + attachmentsUrl + '\'' +
                ", draftMember1=" + draftMember1 +
                ", draftMember2='" + draftMember2 + '\'' +
                ", draftMember3='" + draftMember3 + '\'' +
                '}';
    }
}

