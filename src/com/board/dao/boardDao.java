package com.board.dao;

import java.util.List;

import com.board.vo.boardVo;

public interface boardDao {
	public List<boardVo> selectList();
	public boardVo selectOne(int no);
	public int delete(int no);
	public int insert(String content);
	public int update(boardVo vo);
}
