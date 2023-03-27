package com.example.board.controller;

import com.example.board.model.PostComment;
import com.example.board.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

import javax.validation.Valid;

/*
    사용자 리퀘스트 처리
 */
@Controller
public class FileController {
    @Autowired
    FileService fileService;

    // 파일 삭제
    @GetMapping("/delete/file/{postId:\\d+}&{commentId:\\d+}")
    public String delete(@PathVariable long postId, @PathVariable long commentId) {
        fileService.deleteById(commentId);
        return "redirect:/read/{postId}";
    }

    /**
     * 파일 저장
     * @param post
     * @param result 검증 오류가 발생할 경우 오류 내용을 보관
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @PostMapping("/upload/{userId:\\d+}")
    public String save(MultipartFile file) throws IOException {
        fileService.save(file);
        return "redirect:/read/{userId}";
    }
}
