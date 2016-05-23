/**
 * 
 */
package com.adam.spring.task;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

/**
 * @author awang
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/adam/spring/beans/beans.xml");
		OffersDAO offersDao = (OffersDAO) context.getBean("offersDAO");
		Offer offerupdate = new Offer(90,"Claire","cawe@gmail.com","web degsign to firt");
		if(offersDao.update(offerupdate)){
			System.out.println("===============");
			System.out.println("Offer updated!");
			System.out.println("===============");
		}else{
			System.out.println("Cannot update offer");
		}
		
		try {
			/*Offer offer1 = new Offer("Dave", "dave@gaik.com","code in java");
			Offer offer2 = new Offer("Davis", "asd@gaik.com","coad in python");
			
			if(offersDao.create(offer1)){
				System.out.println("Created offer 1");
			};
			if(offersDao.create(offer2)){
				System.out.println("Created offer 2");
			};
			*/
			List<Offer> offerslist = new ArrayList<Offer>();
			offerslist.add(new Offer("Dave","dave@saasd.com","Cash for acr"));
			offerslist.add(new Offer("James","dasde@saasd.com","Aas for cat"));
			//offersDao.delete(88);
			
			int[] rvals = offersDao.create(offerslist);
			for(int value: rvals){
				System.out.println("Update " + value + " rows.");
			}
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			Offer offer = offersDao.getOffer(2);
			System.out.println("Should be Mike: " + offer);
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}
		
		

		((ClassPathXmlApplicationContext) context).close();
	}

}
