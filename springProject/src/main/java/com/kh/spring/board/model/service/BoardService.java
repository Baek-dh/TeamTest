package com.kh.spring.board.model.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.kh.spring.board.model.vo.Attachment;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.board.model.vo.Search;

public interface BoardService {

	/** 페이징 처리를 위한 Servicce
	 * @param type
	 * @param cp
	 * @return pInfo
	 */
	public abstract PageInfo pagination(int type, int cp);
	
	/** 게시글 목록 조회 Service
	 * @param pInfo
	 * @return boardList
	 */
	public abstract List<Board> selectList(PageInfo pInfo);

	/** 게시글 상세조회 Service
	 * @param boardNo
	 * @return board
	 */
	public abstract Board selectBoard(int boardNo);

	/** 게시글 등록 Service
	 * @param board
	 * @param savePath 
	 * @param images 
	 * @return result
	 */
	public abstract int insertBoard(Board board, List<MultipartFile> images, String savePath);

	/** 게시글 삭제 Service
	 * @param boardNo
	 * @return result
	 */
	public abstract int deleteBoard(int boardNo);

	/** 게시글 수정 Service
	 * @param upBoard
	 * @param images 
	 * @param savePath 
	 * @param deleteImages 
	 * @return result
	 */
	public abstract int updateBoard(Board upBoard, String savePath, List<MultipartFile> images, boolean[] deleteImages);

	/** 게시글 이미지 조회 Service
	 * @param boardNo
	 * @return files
	 */
	public abstract List<Attachment> selectFiles(int boardNo);
 
	/** 게시글 썸네일 목록 조회 Service
	 * @param boardList
	 * @return thList
	 */
	public abstract List<Attachment> selectThumbnailList(List<Board> boardList);

	/** // 게시판 조회수 높은 게시글 조회 Service
	 * @param type
	 * @return list
	 */
	public abstract List<Board> selectTopViews(int type);

	/** 검색 조건이 추가된 페이징 처리 Service
	 * @param type
	 * @param cp
	 * @param search
	 * @return pInfo
	 */
	public abstract PageInfo pagination(int type, int cp, Search search);

	
	/** 검색 목록 조회 Service
	 * @param pInfo
	 * @param search
	 * @return boardList
	 */
	public abstract List<Board> selectSearchList(PageInfo pInfo, Search search);
	
	

	
	
}
