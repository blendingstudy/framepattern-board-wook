package com.example.board.controller;

import com.example.board.model.PostFile;
import com.example.board.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/*
    사용자 리퀘스트 처리
 */
@Controller
public class FileController {
    @Autowired
    FileService fileService;

    /**
     * 파일 저장
     * @param post
     * @param result 검증 오류가 발생할 경우 오류 내용을 보관
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @PostMapping("/upload/{userId:\\d+}")
    public String save(MultipartFile file, PostFile postFile) throws IOException {
        fileService.save(file, postFile);
        return "redirect:/read/{userId}";
    }

    // 파일 다운로드
    @GetMapping("/download/file/{postId:\\d+}&{fileId:\\d+}")
    public String download(@PathVariable long postId, @PathVariable long fileId) {
        fileService.downloadById(fileId);
        return "redirect:/read/{postId}";
    }

    // 파일 삭제
    @GetMapping("/delete/file/{postId:\\d+}&{fileId:\\d+}")
    public String delete(@PathVariable long postId, @PathVariable long fileId) {
        fileService.deleteById(fileId);
        return "redirect:/read/{postId}";
    }
}
