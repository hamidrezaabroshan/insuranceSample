package com.insurance.store.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.store.dto.CommentDto;
import com.insurance.store.exception.BadRequestException;
import com.insurance.store.model.Comment;
import com.insurance.store.model.CommenttVoteApprovalStatus;
import com.insurance.store.model.Product;
import com.insurance.store.model.User;

import jakarta.validation.constraints.NotNull;

@Service
public class ReviewService {
    private ProductService productService;
    private UserService userService;
    private OrderService orderService;
    private CommentService commentService;
    @Autowired
    public ReviewService(ProductService productService, UserService userService,
            OrderService orderService, CommentService commentService) {
        this.productService =productService;
        this.userService =userService;
        this.orderService =orderService;
        this.commentService =commentService;
    }
    public boolean isProductVisible(@NotNull Long productId) {
        return productService.findById(productId)
                .map(product -> product.isVisible())
                .get();
    }
    public boolean isCommentAllowedForProduct(@NotNull Long productId, @NotNull Long userId) {
        return productService.findById(productId)
                .flatMap(product -> userService.findById(userId)
                        .map(user -> isCommentAllowed(product, user)))
                .orElse(false);
    }

    private boolean isCommentAllowed(Product product, User user) {
        return switch (product.getCommentPolicy()) {
            case ENABLED_FOR_ALL -> true;
            case ENABLED_AFTER_PURCHASE_CONFIRMATION -> orderService.existsByUserAndProduct(user, product);
            default -> false;
        };
    }
    public CommentDto addComment(CommentDto commentDto) {
        Comment comment = new Comment();
        User user =userService.findById(commentDto.getUserId()).orElseThrow();
        Product product =productService.findById(commentDto.getProductId()).orElseThrow();
        if ( product.isVisible() && isCommentAllowed(product, user) ) {
            comment.setText(commentDto.getText());
            comment.setUser(user);
            comment.setProduct(product);
            comment.setCreatedDate(LocalDateTime.now());
            comment.setStatus(CommenttVoteApprovalStatus.PENDING_FOR_APPROVAL);
            comment =commentService.save(comment);
            commentDto.setId(comment.getId());
            return commentDto;
        } else {
            throw new BadRequestException("comment not allowed");
        }
    }
        

}