package com.kh.spring.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.board.model.vo.Reply;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	/** 댓글 조회 DAO
	 * @param boardNo
	 * @return rList
	 */
	public List<Reply> selectList(int boardNo) {
		return sqlSession.selectList("replyMapper.selectList", boardNo);
	}


	/** 댓글 삽입 DAO
	 * @param reply
	 * @return result
	 */
	public int insertReply(Reply reply) {
		return sqlSession.insert("replyMapper.insertReply", reply);
	}
	
	/** 답글 삽입 DAO
	 * @param reply
	 * @return result
	 */
	public int insertReply2(Reply reply) {
		return sqlSession.insert("replyMapper.insertReply2", reply);
	}
	
	
	
	
	
}
