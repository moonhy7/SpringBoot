package com.springbook.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.mapper.BoardMapper;
import com.springbook.service.BoardService;
import com.springbook.vo.BoardFileVO;
import com.springbook.vo.BoardVO;


@Service("boardService")
/*
 * 업무로직 처리를 담당하는 클래스
 * ex) 계좌이체 기능 처리할 때 DB입력은 DAO 하게 되는데 
 * 	   DB입력 전 필요한 작업들(계좌암호화, 금액 컴마 추가...) 하는 로직들을 ServiceImpl클래스에서 처리해주면 됨 
 * */
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper boardMapper;
	
	public void insertBoard(BoardVO vo) {
		//객체 생성 시에 필드 변수의 int타입들은 0으로 초기화 됨		
//		if(vo.getSeq() == 0) { 
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다."); 
//		}
		boardMapper.insertBoard(vo);
		/* boardDAO.insertBoard(vo); */
	}
	
	public void updateBoard(BoardVO vo) {
		boardMapper.updateBoard(vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		boardMapper.deleteBoard(vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return boardMapper.getBoard(vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardMapper.getBoardList(vo);
	}
	
	public int getBoardSeq() {
		return boardMapper.getBoardSeq();
	}
	
	public void insertBoardFileList(List<BoardFileVO> fileList) {
		for(BoardFileVO vo : fileList) {
			boardMapper.insertBoardFileList(vo);
		}
	}
	
	public List<BoardFileVO> getBoardFileList(int seq) {
		return boardMapper.getBoardFileList(seq);
	}
	
	public void deleteFile(BoardFileVO vo) {
		boardMapper.deleteFile(vo);
	}
	
	public void deleteFileList(int seq) {
		boardMapper.deleteFileList(seq);
	}
}
