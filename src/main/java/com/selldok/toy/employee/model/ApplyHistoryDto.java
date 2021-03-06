package com.selldok.toy.employee.model;

import java.sql.Timestamp;

import com.querydsl.core.annotations.QueryProjection;
import com.selldok.toy.employee.entity.ApplyHistory.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ApplyHistory용 create/update, select DTO
 * @author DongSeok,Kim
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ApplyHistoryDto {
    private Long id;
    private Long applicantId;
    private String name;
    private String email;
    private String phoneNumber;
    private Long employmentBoardId;
    private String boardTitle;
    private String companyName;
    private String companyLogoUrl;
    private Timestamp appliedDate;
    private Status status;
    private String recommendStatus;
    private Long offset = 0L;
    private Long limit = 10L;

    public String getStatusName() {
        return status.friendlyName;
    }

    @QueryProjection
    public ApplyHistoryDto(String name, String email, String phoneNumber, String companyName, String boardTitle, Timestamp appliedDate, Status status) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.boardTitle = boardTitle;
        this.appliedDate = appliedDate;
        this.status = status;
    }
}
