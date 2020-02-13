package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.boardDao;
import com.board.dao.boardDaoImpl;
import com.board.vo.boardVo;

@WebServlet("/board.do")
public class boardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		boardDao dao = new boardDaoImpl();

		String command = request.getParameter("command");
		System.out.println("command : " + command);
		if(command.equals("selectList")) {
			
			List<boardVo> list = dao.selectList();
			request.setAttribute("list", list);
			dispatch("board.jsp", request, response);
		}else if(command.equals("detail")) {
			int no = Integer.parseInt(request.getParameter("no"));
			boardVo vo = dao.selectOne(no);
			request.setAttribute("vo", vo);
			dispatch("detail.jsp", request, response);
		}else if(command.equals("insert")) {
			response.sendRedirect("insertform.jsp");
		}else if(command.equals("insertres")) {
			String content = request.getParameter("content");
			int res = dao.insert(content);
			if(res>0) {
				jsResponse("글 작성 성공", "board.do?command=selectList", response);
			}else {
				jsResponse("글 작성 실패", "insertform.jsp", response);
			}
		}else if(command.equals("delete")) {
			int no = Integer.parseInt(request.getParameter("no"));
			int res = dao.delete(no);
			if(res>0) {
				jsResponse("글 삭제 성공", "board.do?command=selectList", response);
			}else {
				dispatch("board.do?command=detail&no="+no, request, response);
			}
		}else if(command.equals("update")) {
			int no = Integer.parseInt(request.getParameter("no"));
			boardVo vo = dao.selectOne(no);
			request.setAttribute("vo", vo);
			dispatch("updateform.jsp", request, response);
		}else if(command.equals("updateres")) {
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println("no : "+no);
			boardVo vo = new boardVo();
			vo.setNo(no);
			vo.setContent(request.getParameter("content"));
			int res = dao.update(vo);
			if(res>0) {
				jsResponse("수정성공", "board.do?command=detail&no="+no, response);
			}else {
				jsResponse("수정실패", "board.do?command=update&no="+no, response);
			}
		}

	}

	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('" + msg + "');");
		out.println("location.href='" + url + "';");
		out.println("</script>");
	}
}
