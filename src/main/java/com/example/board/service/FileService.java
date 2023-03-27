package com.example.board.service;

import com.example.board.controller.dto.PageRequest;
import com.example.board.controller.dto.PostPage;
import com.example.board.model.PostComment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class FileService {
    @Autowired
    SqlSession sqlSession;

    //파일 저장
    public void save(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File fileDir = new File("C:\\Upload"); 
            Files.createDirectories(fileDir.toPath());
            String fullPath = "C:\\Upload\\" + file.getOriginalFilename();
            file.transferTo(new File(fullPath));
        }
        sqlSession.insert("file.insert");
    }

    //파일목록 조회
    public PostPage getPage(PageRequest pageRequest, long id) {
        List<PostComment> posts = sqlSession.selectList("file.postsComment", id);
        
        PostPage page = new PostPage();
        page.setPostsComment(posts);

        return page;
    }

    //파일 삭제
    public void deleteById(long id) {
        sqlSession.delete("file.delete", id);
    }
}
