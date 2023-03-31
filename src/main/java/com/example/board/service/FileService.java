package com.example.board.service;

import com.example.board.controller.dto.PageRequest;
import com.example.board.controller.dto.PostPage;
import com.example.board.model.PostFile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileService {
    @Autowired
    SqlSession sqlSession;

    //파일 저장
    public void save(MultipartFile file, PostFile postFile) throws IOException {
        if (!file.isEmpty()) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHddss");
            String dateStr = simpleDateFormat.format(date);
            //서버에 저장
            File fileDir = new File("C:\\Upload"); 
            String fileName = file.getOriginalFilename();
            String fileCutName = fileName.substring(0, fileName.lastIndexOf("."));
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
            String saveFileName = fileCutName + "_" + dateStr;
            String fullPath = "C:\\Upload\\" + saveFileName + "." + fileExt;
            Files.createDirectories(fileDir.toPath());
            file.transferTo(new File(fullPath));
            //DB에 저장
            postFile.setFileOriginalName(fileCutName);
            postFile.setFileSaveName(saveFileName);
            postFile.setExtention(fileExt);
            postFile.setFilePath(fullPath);
            postFile.setSize(file.getSize());
            sqlSession.insert("file.insert", postFile);
        }
    }
    
    //파일목록 조회
    public PostPage getPage(PageRequest pageRequest, long id) {
        List<PostFile> posts = sqlSession.selectList("file.postsFile", id);
        
        PostPage page = new PostPage();
        page.setPostsFile(posts);

        return page;
    }
    
    //파일 다운로드
    public void downloadById(long id) {
        //Todo 
    }

    //파일 삭제
    public void deleteById(long id) {
        sqlSession.delete("file.delete", id);
    }
}
