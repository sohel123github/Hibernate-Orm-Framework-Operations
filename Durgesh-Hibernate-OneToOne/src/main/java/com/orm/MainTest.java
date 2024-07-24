package com.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();

		// Insert data-
		Answer a1 = new Answer();
		a1.setId(343);
		a1.setAnswer("Java is a programming language.");

		Question q1 = new Question();
		q1.setId(1212);
		q1.setQuestion("What is java?");

		q1.setAnswer(a1);
		a1.setQuestion(q1);

		
//		session.save(q1); session.save(a1);
		

		tr.commit();

		// Fetch data using get method
		// By question table-
//		Question que = session.get(Question.class, 1212);
//		System.out.println(que.getQuestion());
//		System.out.println(que.getAnswer().getAnswer());

		// By answer table-
//		Answer ans = session.get(Answer.class, 343);
//		System.out.println(ans.getQuestion().getQuestion());
//		System.out.println(ans.getAnswer());

		session.close();
		factory.close();
		System.out.println("Record inserted sucessfully..");

	}
}
