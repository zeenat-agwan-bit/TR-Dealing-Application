package com.zee;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void saveBooking(Booking booking) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(booking);
		transaction.commit();
		session.close();

	}

	public void updateBooking(Booking booking) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.update(booking);
		transaction.commit();
		session.close();
	}

	public List<Booking> getAllBookings(String from, String to){
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Booking.class);
		Criterion crt1=Restrictions.eq("sourceCity", from);
		Criterion crt2=Restrictions.eq("destCity", to);
		cr.add(crt1); cr.add(crt2);
		List<Booking> bookings=cr.list();
		session.close();
		return bookings;
	}
	
	public List<Booking> getAllBookingByTransporter(String email) {
		Session session=sessionFactory.openSession();
		/*
		 * Query query=session.
		 * createQuery("from Bookings where vehicle.transporter.email=:email");
		 * query.setParameter("email", email); List<Booking> bookings=query.list();
		 */
		Criteria cr=session.createCriteria(Booking.class);
		Criterion crt=Restrictions.eq("vehicle.transporter.email", email);
		cr.add(crt);
		List<Booking> bookings=cr.list();
		
		session.close();
		return bookings;
	}
	

	public List<Booking> getAllBookings() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Booking");
		List<Booking> bookings = query.list();
		session.close();
		return bookings;
		/*
		 * Session session=sessionFactory.openSession(); Criteria
		 * cr=session.createCriteria(Booking.class); List<Booking> bookings=cr.list();
		 * System.out.println(bookings.get(0).getVehicle().getTransporter().getEmail());
		 * session.close(); return bookings;
		 */
	}

	public List<Booking> getAllBookings(String date) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			Date bookingdate=null;
			try{
				bookingdate=(Date) df.parse(date);
			}catch(Exception e) {}
			
			Session session=sessionFactory.openSession();
			Criteria cr=session.createCriteria(Booking.class);
			Criterion crt1=Restrictions.ge("date", bookingdate);
			cr.add(crt1); 
			List<Booking> bookings=cr.list();
			session.close();
			return bookings;
		}
		
	}
	
	


