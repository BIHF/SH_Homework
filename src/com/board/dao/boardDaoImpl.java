package com.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.vo.boardVo;

public class boardDaoImpl extends SqlMapConfig implements boardDao {
	String namespace = "board.";

	@Override
	public List<boardVo> selectList() {
		List<boardVo> list = null;

		SqlSession session = null;

		try {
			session = getSqlSessionactory().openSession();
			list = session.selectList(namespace + "selectList");
		} catch (Exception e) {
			System.out.println("[error] : selectList");
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("번호 : " + list.get(0).getNo());
		System.out.println("내용 : " + list.get(0).getContent());
		return list;
	}
	@Override
	public boardVo selectOne(int no) {
		boardVo vo = null;
		SqlSession session = null;
		try {
			session = getSqlSessionactory().openSession();
			vo = session.selectOne(namespace + "selectOne",no);
			
		} catch (Exception e) {
			System.out.println("[error] : selectOne");
			e.printStackTrace();
		} finally {
			session.close();
		}
		return vo;
		
	}
	@Override
	public int delete(int no) {
		int res =0;
		SqlSession session = null;
		try {
			session = getSqlSessionactory().openSession();
			res = session.delete(namespace + "delete",no);
			
		} catch (Exception e) {
			System.out.println("[error] : delete");
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int insert(String content) {
		int res =0;
		SqlSession session = null;
		try {
			session = getSqlSessionactory().openSession();
			res = session.insert(namespace + "insert",content);
			
		} catch (Exception e) {
			System.out.println("[error] : insert");
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	@Override
	public int update(boardVo vo) {
		int res = 0;
		SqlSession session = null;
		try {
			session = getSqlSessionactory().openSession();
			res = session.update(namespace + "update",vo);
			
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return res;
	}

	

}
