package com.orm;

import java.util.ArrayList;
import java.util.List;
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

		// Set question-
		Question q1 = new Question();
		q1.setId(1);
		q1.setQuestion("What is java?");

		// Set answers-
		Answer a1 = new Answer();
		a1.setId(101);
		a1.setAnswer("Java is a programing language..");
		a1.setQuestion(q1);

		Answer a2 = new Answer();
		a2.setId(102);
		a2.setAnswer("Java has different frameworks..");
		a2.setQuestion(q1);

		Answer a3 = new Answer();
		a3.setId(103);
		a3.setAnswer("Java is platform independent language..");
		a3.setQuestion(q1);

		List<Answer> listAns = new ArrayList();

		listAns.add(a1);
		listAns.add(a2);
		listAns.add(a3);

		q1.setAnswer(listAns);

//		session.save(q1);

		// Fetch data by using get method from question-

//		Question que = session.get(Question.class, 1);
//		System.out.println(que.getId());
//		System.out.println(que.getQuestion());
//		for (Answer i : que.getAnswer()) {
//			System.out.println(i.getAnswer());
//		}

		// Fetch data by using get method from answer-
		/*
		 * Answer ans1=session.get(Answer.class, 101); Answer
		 * ans2=session.get(Answer.class, 102); Answer ans3=session.get(Answer.class,
		 * 103); System.out.println(ans1.getId());
		 * System.out.println(ans1.getQuestion().getQuestion());
		 * System.out.println(ans1.getAnswer());
		 * 
		 * System.out.println(ans2.getId());
		 * System.out.println(ans2.getQuestion().getQuestion());
		 * System.out.println(ans2.getAnswer());
		 * 
		 * System.out.println(ans3.getId());
		 * System.out.println(ans3.getQuestion().getQuestion());
		 * System.out.println(ans3.getAnswer());
		 */

		tr.commit();
		session.close();
		factory.close();

		System.out.println("Record inserted successfully..");

	}
}
