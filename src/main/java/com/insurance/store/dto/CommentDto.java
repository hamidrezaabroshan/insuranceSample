package com.insurance.store.dto;

import java.time.LocalDateTime;

import com.insurance.store.model.CommenttVoteApprovalStatus;

import lombok.Data;

@Data
public class CommentDto {
    private Long id; 
    private String text;
    private Long userId;
    private Long productId;
    private CommenttVoteApprovalStatus status;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdatedDate;


}
