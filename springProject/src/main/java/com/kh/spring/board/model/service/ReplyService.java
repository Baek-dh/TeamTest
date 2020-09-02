package com.kh.spring.board.model.service;

import java.util.List;

import com.kh.spring.board.model.vo.Reply;

public interface ReplyService {

	/** 댓글 조회 Service
	 * @param boardNo
	 * @return rList
	 */
	public abstract List<Reply> selectList(int boardNo);

	/** 댓글 삽입 Service
	 * @param reply
	 * @return result
	 */
	public abstract int insertReply(Reply reply);
	
	/** 답글 삽입 Service
	 * @param reply
	 * @return result
	 */
	public abstract int insertReply2(Reply reply);

}
