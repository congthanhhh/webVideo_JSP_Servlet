package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/index", "/favorites", "/history"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static final int VIDEO_MAX_PAGE_SIZE = 2;
    private VideoService videoService = new VideoServiceImpl(); 
    private HistoryService historyService = new HistoryServiceImpl();
    
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String path = req.getServletPath();
		switch (path) {
		case "/index":
			doGetIndex(req, resp);
			break;
		case "/favorites":
			doGetFavorite(session, req, resp);
			break;
		case "/history":
			doGetHistory(session, req, resp);
			break;
		}
		
	}

	private void doGetIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<Video> countVideo = videoService.findAll();
//		//10 video muon chia mot trang co 4 video => 10/4=2.5 >> 3 trang
//		int maxPage = (int)Math.ceil(countVideo.size() / (double)VIDEO_MAX_PAGE_SIZE);
//		req.setAttribute("maxPage", maxPage);
//		
//		List<Video> videos; 
//		String pageNumber = req.getParameter("page");
//		if (pageNumber == null) {
//			videos = videoService.findAll(1, VIDEO_MAX_PAGE_SIZE);
//			req.setAttribute("currentPage", 1);
//		} else {
//			videos = videoService.findAll(Integer.valueOf(pageNumber), VIDEO_MAX_PAGE_SIZE);
//			req.setAttribute("currentPage", Integer.valueOf(pageNumber));
//		}
		
		List<Video> videos = videoService.findAll();
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("view/user/index.jsp").forward(req, resp);
		
	}
	private void doGetFavorite(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> history = historyService.findByUserAndIsLiked(user.getUsername());
		List<Video> videos = new ArrayList<>();
		
		history.forEach(item -> videos.add(item.getVideo()));
		/*
		  for (int i = 0; i < histoty.size(); i++) {
		  		videos.add(history.get(i).getVideo();
		  */
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("view/user/favorites.jsp").forward(req, resp);
		
	}
	private void doGetHistory(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		List<History> history = historyService.findByUser(user.getUsername());
		List<Video> videos = new ArrayList<>();
		
		history.forEach(item -> videos.add(item.getVideo()));
		
		req.setAttribute("videos", videos);
		req.getRequestDispatcher("view/user/history.jsp").forward(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
