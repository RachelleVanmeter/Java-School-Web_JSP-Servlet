package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	
	BoardService bs = new BoardService();
	
	private void doProsess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("요청이 들어옴");
		String requestUri = request.getRequestURI();
		System.out.println(requestUri);
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		
		String commnad = requestUri.substring(contextPath.length());
		System.out.println(commnad);
		
		if(commnad.equals("/boardList.bo")) {
			System.out.println("게시물 목록 요청");
			response.sendRedirect(contextPath + "/board/board_list.jsp");
		} else if(commnad.equals("/boardWrite.bo")) {
			System.out.println("게시물 작성 요청");
			RequestDispatcher rd = request.getRequestDispatcher("/board/board_write.jsp");
			rd.forward(request, response);
		} else if(commnad.equals("/boradWriteSubmit.bo")) {
			System.out.println("게시글 입력 요청");
			bs.regArticle(request);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProsess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProsess(request, response);
	}
}
