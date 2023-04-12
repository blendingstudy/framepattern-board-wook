package com.example.board.controller;

import com.example.board.model.PostFile;
import com.example.board.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

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
    public void download(HttpServletResponse response, @PathVariable long postId, @PathVariable long fileId) throws Exception {
        PostFile postFile = fileService.downloadById(fileId);
        String fileName = postFile.getFileOriginalName() + "." + postFile.getExtention();
        String fileSaveName = postFile.getFileSaveName() + "." + postFile.getExtention();
        String filePath = postFile.getFilePath().substring(0, postFile.getFilePath().lastIndexOf("/")) + "/";

        File dFile = new File(filePath, fileSaveName);
        int fSize = (int) dFile.length();
        if (fSize > 0) {
            String encodedFilename = "attachment; filename*=" + "UTF-8" + "''" + URLEncoder.encode(fileName, "UTF-8");
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setHeader("Content-Disposition", encodedFilename);
            response.setContentLengthLong(fSize);

            BufferedInputStream in = null;
            BufferedOutputStream out = null;

            in = new BufferedInputStream(new FileInputStream(dFile));
            out = new BufferedOutputStream(response.getOutputStream());

            try {
                byte[] buffer = new byte[4096];
                int bytesRead = 0;
                while ((bytesRead = in .read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } finally {
                in.close();
                out.close();
            }
        }
        
        // return "redirect:/read/{postId}";
    }

    // 파일 삭제
    @GetMapping("/delete/file/{postId:\\d+}&{fileId:\\d+}")
    public String delete(@PathVariable long postId, @PathVariable long fileId) {
        fileService.deleteById(fileId);
        return "redirect:/read/{postId}";
    }
}
