// CommentService.java
package com.example.service;

import java.util.List;

import com.example.pojo.Comment;

public interface CommentService {
    void addComment(Comment comment, String username);
    Comment getCommentById(Long commentId);
    List<Comment> getCommentsByListingId(Long listingId);
    void updateComment(Comment comment, String username);
    void deleteComment(Long commentId);
}
