package com.kh.spring.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.board.model.dao.ReplyDAO;
import com.kh.spring.board.model.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyDAO replyDAO;

	// 댓글 조회 Service 구현
	@Override
	public List<Reply> selectList(int boardNo) {
		return replyDAO.selectList(boardNo);
	}

	// 댓글 삽입 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertReply(Reply reply) {
		// 크로스 사이트 스크립팅 방지
		reply.setReplyContent(
				replaceParameter(reply.getReplyContent()));
		
		// 개행문자 처리 \n -> <br>
		reply.setReplyContent(
				reply.getReplyContent().replaceAll("\n", "<br>"));
		
		return replyDAO.insertReply(reply);
	}
	
	// 답글 삽입 Service 구현
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertReply2(Reply reply) {
		// 크로스 사이트 스크립팅 방지
		reply.setReplyContent(
				replaceParameter(reply.getReplyContent()));
		
		// 개행문자 처리 \n -> <br>
		reply.setReplyContent(
				reply.getReplyContent().replaceAll("\n", "<br>"));
		
		return replyDAO.insertReply2(reply);
	}
	
	
	
	
	
	// 크로스 사이트 스크립트 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}
	
}
