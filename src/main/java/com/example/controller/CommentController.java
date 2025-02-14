// CommentController.java
package com.example.controller;

import com.example.pojo.Comment;
import com.example.service.CommentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;
    
    @PostMapping
    public String addComment(Comment comment, HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	Long listingId = comment.getListingId();        
    	System.out.println("---------------------------------------");
        System.out.println("Username: " + username);
    	System.out.println("---------------------------------------");
    	System.out.println("entered @PostMapping in addComment !!");
    	System.out.println("---------------------------------------");
    	System.out.println("ListingId: "+ listingId);
    	System.out.println("---------------------------------------");
    	comment.setListingId(listingId);
        commentService.addComment(comment, username);
        
        return "redirect:/viewListing?listingId=" + listingId;
    }    

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @PutMapping("/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody Comment comment, HttpSession session) {
    	String username = (String) session.getAttribute("username");
    	System.out.println("---------------------------------------");
        System.out.println("Username: " + username);
    	System.out.println("---------------------------------------");
    	System.out.println("entered @PutMapping in updateComment !!");
    	System.out.println("---------------------------------------");
        Comment existingComment = commentService.getCommentById(commentId);
        Long lid = existingComment.getListingId();
        if (existingComment != null) {
            comment.setId(commentId);
            comment.setListingId(lid);
            commentService.updateComment(comment, username);
        }
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}
