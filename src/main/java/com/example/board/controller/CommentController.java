package com.example.board.controller;

import com.example.board.model.PostComment;
import com.example.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/*
    사용자 리퀘스트 처리
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    // 댓글 삭제
    @GetMapping("/delete/comment/{postId:\\d+}&{commentId:\\d+}")
    public String delete(@PathVariable long postId, @PathVariable long commentId) {
        commentService.deleteById(commentId);
        return "redirect:/read/{postId}";
    }

    /**
     * 댓글 저장
     * @param post
     * @param result 검증 오류가 발생할 경우 오류 내용을 보관
     * @return
     */
    @PostMapping("/saveComment/{userId:\\d+}")
    public String save(@Valid PostComment postComment, BindingResult result) {
        commentService.save(postComment);
        return "redirect:/read/{userId}";
    }
}
