package com.insurance.store.controller;

import com.insurance.store.dto.CommentDto;
import com.insurance.store.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/products/{productId}/visible")
    public ResponseEntity<Boolean> isProductVisible(@PathVariable Long productId) {
        boolean isVisible = reviewService.isProductVisible(productId);
        return ResponseEntity.ok(isVisible);
    }

    @GetMapping("/products/{productId}/users/{userId}/allowed")
    public ResponseEntity<Boolean> isCommentAllowedForProduct(
            @PathVariable Long productId,
            @PathVariable Long userId
    ) {
        boolean isAllowed = reviewService.isCommentAllowedForProduct(productId, userId);
        return ResponseEntity.ok(isAllowed);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
        CommentDto addedComment = reviewService.addComment(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedComment);
    }
}
