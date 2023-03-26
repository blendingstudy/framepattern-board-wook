package com.example.board.service;

import com.example.board.controller.dto.PageRequest;
import com.example.board.controller.dto.PostPage;
import com.example.board.model.PostComment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    SqlSession sqlSession;

    public void save(PostComment postComment) {
        if (postComment.getId() == null) {
            sqlSession.insert("comment.insert", postComment);
        } else {
            sqlSession.update("comment.update", postComment);
        }
    }

    /*
        bean 으로 파라미터 전달하는 샘플
     */
//    @Transactional(readOnly = true) // 트랜젝션을 읽기 전용 모드로 설정
//    public PostPage getPage(PageRequest pageRequest) {
//        int totalCount = sqlSession.selectOne("board.totalCount");
//        List<Post> posts = sqlSession.selectList("board.posts", pageRequest);
//
//        PostPage page = new PostPage();
//        page.setPageSize(pageRequest.getPageSize());
//        page.setPageNo(pageRequest.getPageNo());
//        page.setTotalCount(totalCount);
//        page.setPosts(posts);
//
//        return page;
//    }

    /*
        bean 대신에 Map 으로 파라미터 전달하는 샘플
     */
    @Transactional(readOnly = true) // 트랜젝션을 읽기 전용 모드로 설정
    public PostPage getPage(PageRequest pageRequest) {
        List<PostComment> posts = sqlSession.selectList("comment.postsComment");
        
        PostPage page = new PostPage();
        page.setPostsComment(posts);

        return page;
    }

    public PostComment findById(long id) {
        return sqlSession.selectOne("comment.postComment", id);
    }

    public void deleteById(long id) {
        sqlSession.delete("comment.delete", id);
    }
}
