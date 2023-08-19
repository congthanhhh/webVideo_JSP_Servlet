package com.poly.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.util.JpaUtil;

public class TestConnection {
	
	public static void findByUserIdAndVideoId(int userId, int videoId) {
		EntityManager em = JpaUtil.getEntityManager();
		String sql = "SELECT o FROM History o WHERE o.user.id = ?0 AND o.video.id =? 1"
				+ " AND o.video.isActive = 1";
		try {
			em.getTransaction().begin();
			TypedQuery<History> query = em.createQuery(sql, History.class);
			query.setParameter(0, userId);
			query.setParameter(1, videoId);
			List<History> list = query.getResultList();
			
			for (History h : list) {
				System.out.println("------------------------------");
				System.out.println("id " +h.getId());
				System.out.println("userid " +h.getUser().getId());
				System.out.println("videoid " +h.getVideo().getId());
				System.out.println("isLiked " +h.getIsLiked());
				System.out.println("viewDate " +h.getViewDate());
				System.out.println("likeDate " +h.getLikeDate());
				System.out.println("------------------------------");
			}
			System.out.println("thanh cong");
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("that bai");
			e.printStackTrace();
		}
		
	}
	public static void findByUserHistory(String username) {
		EntityManager em = JpaUtil.getEntityManager();
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 "
				+ " AND o.isLiked = 1"
				+ " AND o.video.isActive = 1"
				+ " ORDER BY o.viewDate DESC";
		
		try {
			em.getTransaction().begin();
			TypedQuery<History> query = em.createQuery(sql, History.class);
			query.setParameter(0, username);
			
			List<History> list = query.getResultList();
			
			for (History h : list) {
				System.out.println("------------------------------");
				System.out.println("id " +h.getId());
				System.out.println("userid " +h.getUser().getId());
				System.out.println("videoid " +h.getVideo().getId());
				System.out.println("isLiked " +h.getIsLiked());
				System.out.println("viewDate " +h.getViewDate());
				System.out.println("likeDate " +h.getLikeDate());
				System.out.println("------------------------------");
			}
			System.out.println("thanh cong");
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("that bai");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
//		findByUserIdAndVideoId(2, 1);
//		findByUserHistory("thanh");
		String newPass = String.valueOf((int)(Math.random() * ((9999 - 1000) + 1)) +1000);
		System.out.println("new pass word: "+newPass);
	}
}
