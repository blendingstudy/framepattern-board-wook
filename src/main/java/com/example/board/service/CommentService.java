package com.example.board.service;

import com.example.board.controller.dto.PageRequest;
import com.example.board.controller.dto.PostPage;
import com.example.board.model.PostComment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    SqlSession sqlSession;

    //댓글 저장
    public void save(PostComment postComment) {
        sqlSession.insert("comment.insert", postComment);
    }

    //댓글목록 조회
    public PostPage getPage(PageRequest pageRequest, long id) {
        List<PostComment> posts = sqlSession.selectList("comment.postsComment", id);
        
        PostPage page = new PostPage();
        page.setPostsComment(posts);

        return page;
    }

    //댓글 삭제
    public void deleteById(long id) {
        sqlSession.delete("comment.delete", id);
    }
}
