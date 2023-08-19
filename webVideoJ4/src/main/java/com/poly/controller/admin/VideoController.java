package com.poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.VideoService;
import com.poly.service.impl.VideoServiceImpl;

@WebServlet(urlPatterns = ("/admin/video"), name = "VideoControllerOfAdmin")
public class VideoController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3968414433292121855L;
	
	private VideoService videoService = new VideoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		if (currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
			String action = req.getParameter("action");
			switch (action) {
			case "view": 
				doGetOverView(req, resp);
			}
		} else {
			resp.sendRedirect("index");
		}
		super.doGet(req, resp);
	}
	
	private void doGetOverView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Video> video = videoService.findAll();
		req.setAttribute("videos", video);
	    req.getRequestDispatcher("/view/admin/video-overview.jsp").forward(req, resp);
	}
	

}
