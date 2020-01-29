package com.discoveri.heartihealth.repositoryImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.GetTotalPredictionByPeriod;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.SymptomPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Repository
public class HeartInfoRepoImpl  implements HeartInfoRepo{

	@Override
	public  List<IntervalPrediction> weeklyReport() throws HeartiExceptions {
	//	Patient emp;
		//WeeklyPrediction weeklyPrediction =new WeeklyPrediction();
		List<IntervalPrediction> weeklyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" SELECT DAYNAME(c.date) weeks, c.date as date, sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from memberinfo m inner join cardiodiagnosis c on m.member_id = c.memberinfo_member_id inner join diseasedetail d on c.cardio_id = d.cardiodiagnosis_cardio_id WHERE c.date >   DATE_SUB(NOW(), INTERVAL 10 WEEK) GROUP BY c.date  ");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction weeklyPrediction =new IntervalPrediction();
				weeklyPrediction.setInterval(rs.getString(1));
				weeklyPrediction.setPredicted(rs.getInt(3));
				weeklyPrediction.setCured(rs.getInt(4));
				weeklyPredictions.add(weeklyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return weeklyPredictions;
	}
	
	
	@Override
	public List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions {
		List<IntervalPrediction> yearlyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select year(c.date) as year,sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from cardiodiagnosis c  inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  group by year(c.date);");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction yearlyPrediction =new IntervalPrediction();
				yearlyPrediction.setInterval(rs.getString(1));
				yearlyPrediction.setPredicted(rs.getInt(2));
				yearlyPrediction.setCured(rs.getInt(3));
				yearlyPredictions.add(yearlyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return yearlyPredictions;
	}


	@Override
	public List<IntervalPrediction> monthlyReport() throws HeartiExceptions {
		List<IntervalPrediction> monthlyPredictions=new ArrayList<IntervalPrediction>();
		Connection con=null;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  MONTHNAME(STR_TO_DATE(month(c.date), '%m')) as month,sum(c.cardioarrestdetected) as predicted,sum(d.isrecovered) as cured from cardiodiagnosis c inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  and year(c.date) = 2019 group by month(c.date);");
			//emp = new Patient();
			while (rs.next()) {
				IntervalPrediction monthlyPrediction =new IntervalPrediction();
				monthlyPrediction.setInterval(rs.getString(1));
				monthlyPrediction.setPredicted(rs.getInt(2));
				monthlyPrediction.setCured(rs.getInt(3));
				monthlyPredictions.add(monthlyPrediction);
			} 
			con.close();
		} catch (Exception e) {
			throw new HeartiExceptions(e.getMessage());
		}
		return monthlyPredictions;
	}


	


	


	


	  @Override
	    public List<CardioArrestDetection> totalCardioArrestDetection(String memberid) {
	        // TODO Auto-generated method stub
	       
	        List<CardioArrestDetection> cardioArrestDetections =new ArrayList<CardioArrestDetection>();
	        Connection con=null;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select c.date,m.age,m.gender from memberinfo m inner join cardiodiagnosis c on c.memberinfo_member_id = m.member_id");
	            else
	                rs = stmt.executeQuery("select c.date,m.age,m.gender from memberinfo m inner join cardiodiagnosis c on m.member_id = c.memberinfo_member_id where m.member_id = '"+memberid+"'");
	            //emp = new Patient();
	            while (rs.next()) {
	                CardioArrestDetection cardioArrestDetection =new CardioArrestDetection();
	               
	                cardioArrestDetection.setTimestamp(rs.getString(1));
	                cardioArrestDetection.setAgeBelowThirty(rs.getInt(2) <= 30 ? true : false);
	                cardioArrestDetection.setMale(rs.getString(3).equalsIgnoreCase("1") ? true : false);
	           
	                cardioArrestDetections.add(cardioArrestDetection);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cardioArrestDetections;
	       
	    }


	

	@Override
	public List<SymptomPrediction> getChestPainDetection(String memberid) {
		// TODO Auto-generated method stub
		 List<SymptomPrediction> symptomPredictions =new ArrayList<SymptomPrediction>();
	        Connection con=null;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid ==  null)
	                 rs = stmt.executeQuery("select s.date, s.cp from symptom s inner join cardiodiagnosis c\r\n" + 
	                 		"on s.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW())  ;");
	            else
	                rs = stmt.executeQuery("select s.date, s.cp from symptom s inner join cardiodiagnosis c \r\n" + 
	                		"on s.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                		"inner join memberinfo m \r\n" + 
	                		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                		"where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW()) and m.member_id = '"+memberid+"';");
	         
	            while (rs.next()) {
	            	SymptomPrediction symptomPrediction =new SymptomPrediction();
	            	
	            	symptomPrediction.setTimestamp(rs.getString(1));
	            	symptomPrediction.setSymptomValue(rs.getInt(2));
	            	
	           
	                symptomPredictions.add(symptomPrediction);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return symptomPredictions;
	}


	@Override
	public List<SymptomPrediction> getBloodPressureDetection(String memberid) {
		// TODO Auto-generated method stub
		 List<SymptomPrediction> symptomPredictions =new ArrayList<SymptomPrediction>();
	        Connection con=null;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select b.date, b.bloodpressure from bloodtest b inner join cardiodiagnosis c \r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()) ;");
	            else
	                rs = stmt.executeQuery("select b.date, b.bloodpressure from bloodtest b inner join cardiodiagnosis c\r\n" + 
	                		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                		"inner join memberinfo m \r\n" + 
	                		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()) and m.member_id = '"+memberid+"';");
	            
	         
	            while (rs.next()) {
	            	SymptomPrediction symptomPrediction =new SymptomPrediction();
	            	
	            	symptomPrediction.setTimestamp(rs.getString(1));
	            	symptomPrediction.setSymptomValue(rs.getInt(2));
	            	
	           
	                symptomPredictions.add(symptomPrediction);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return symptomPredictions;
	}


	@Override
	public List<SymptomPrediction> getCholesterolDetection(String memberid) {
		// TODO Auto-generated method stub
		 List<SymptomPrediction> symptomPredictions =new ArrayList<SymptomPrediction>();
	        Connection con=null;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select b.date, b.serumcholesterol from bloodtest b inner join cardiodiagnosis c\r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()) ;");
	            else
	                rs = stmt.executeQuery("select b.date, b.serumcholesterol from bloodtest b inner join cardiodiagnosis c\r\n" + 
	                		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                		"inner join memberinfo m \r\n" + 
	                		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()) and m.member_id = '"+memberid+"';");
	         
	            while (rs.next()) {
	            	SymptomPrediction symptomPrediction =new SymptomPrediction();
	            	
	            	symptomPrediction.setTimestamp(rs.getString(1));
	            	symptomPrediction.setSymptomValue(rs.getInt(2));
	            	
	           
	                symptomPredictions.add(symptomPrediction);
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return symptomPredictions;
	}


	@Override
	public List<LivePrediction> getLivePrediction(String memberid) {
		// TODO Auto-generated method stub
		
		 List<LivePrediction> livePredictions =new ArrayList<LivePrediction>();
		
		 livePredictions.add(getLivePredictionBySymptom(memberid, "Chest Pain"));
		 livePredictions.add(getLivePredictionBySymptom(memberid, "Blood Pressure"));
		 livePredictions.add(getLivePredictionBySymptom(memberid, "Cholesterol"));
		 
		return livePredictions;
	}


	@Override
	public LivePrediction getLivePredictionBySymptom(String memberid, String symptomType) {
		// TODO Auto-generated method stub
		 LivePrediction livePrediction = new LivePrediction();
		 List<SymptomPrediction> symptomPredictions = new ArrayList<SymptomPrediction>();
		
		 int prevDayPredictionValue = 0;
		 int curDayPredictionValue = 0;
		 float percentage = 0;
		 
		 livePrediction.setSymptomType(symptomType);
		 
		 if(symptomType.equalsIgnoreCase("Chest Pain"))
		 {
		 symptomPredictions = getChestPainDetection(memberid);
         livePrediction.setSymptomPrediction(symptomPredictions);       
		 
		 prevDayPredictionValue = getPredictionOfChestPainValueByDay(memberid, 1);
		 curDayPredictionValue = getPredictionOfChestPainValueByDay(memberid, 0);
		 
		 if(prevDayPredictionValue > 0)
			 percentage = ((curDayPredictionValue - prevDayPredictionValue)/(prevDayPredictionValue*1.0f)) * 100.0f;
			else
			 percentage = curDayPredictionValue * 100.0f; 
		 
		 livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
		 livePrediction.setVariation(Math.round(percentage));
		 livePrediction.setUp(percentage < 0 ? false : true);
		 
 
		 }
		 else if(symptomType.equalsIgnoreCase("Blood Pressure"))
		 {
			 symptomPredictions = getBloodPressureDetection(memberid);
			 livePrediction.setSymptomPrediction(symptomPredictions);
			 
			 prevDayPredictionValue = getPredictionOfBloodPressureByDay(memberid, 1);
			 curDayPredictionValue = getPredictionOfBloodPressureByDay(memberid, 0);
			 
			 if(prevDayPredictionValue > 0)
				 percentage = ((curDayPredictionValue - prevDayPredictionValue)/(prevDayPredictionValue*1.0f)) * 100.0f;
				else
				 percentage = curDayPredictionValue * 100.0f; 
			 
			 livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
			 livePrediction.setVariation(Math.round(percentage));
			 livePrediction.setUp(percentage < 0 ? false : true);		
			 
		 }
		 else if(symptomType.equalsIgnoreCase("Cholesterol"))
		 {	

	     symptomPredictions = getCholesterolDetection(memberid);
		 livePrediction.setSymptomPrediction(symptomPredictions);
		 prevDayPredictionValue = getPredictionOfCholesterolByDay(memberid, 1);
		 curDayPredictionValue = getPredictionOfCholesterolByDay(memberid, 0);
		 
		 if(prevDayPredictionValue > 0)
			 percentage = ((curDayPredictionValue - prevDayPredictionValue)/(prevDayPredictionValue*1.0f)) * 100.0f;
			else
			 percentage = curDayPredictionValue * 100.0f; 
		 
		 livePrediction.setTodayPredictionSymptomValue(curDayPredictionValue);
		 livePrediction.setVariation(Math.round(percentage));
		 livePrediction.setUp(percentage < 0 ? false : true);
		 
		 }
		 
	
		return livePrediction;
	}


	@Override
	public List<GetTotalPredictionByPeriod> getTotaPredictionByPeriod(String interval) {
		// TODO Auto-generated method stub
		
		if(interval.equalsIgnoreCase("Weekly"))
			return getTotalPredictionByWeekly();
		else if(interval.equalsIgnoreCase("Monthly"))
			return getTotalPredictionByMonthly();
		else if(interval.equalsIgnoreCase("Yearly"))
			return getTotalPredictionByYearly();
		
		return null;
		
	}


	@Override
	public List<GetTotalPredictionByPeriod> getTotalPredictionByWeekly() {
		// TODO Auto-generated method stub
		List<GetTotalPredictionByPeriod> totalPredictionByPeriods = new ArrayList<GetTotalPredictionByPeriod>();
		Connection con=null;
		int prevPrediction = 1;
		boolean ignoreFirst = true;
		float percentage = 0;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DAYNAME(c.date),sum(c.cardioarrestdetected) as LastWeek from memberinfo m inner join cardiodiagnosis c on m.member_id = c.memberinfo_member_id inner join diseasedetail d on c.cardio_id = d.cardiodiagnosis_cardio_id WHERE c.date >   DATE_SUB(NOW(), INTERVAL 8 day) group by Date(c.date); ");
			//emp = new Patient();
			while (rs.next()) {
				GetTotalPredictionByPeriod totalPredictionByPeriod =new GetTotalPredictionByPeriod();
				totalPredictionByPeriod.setInterval(rs.getString(1));
				totalPredictionByPeriod.setTotalPrediction(rs.getInt(2));
				
				if(prevPrediction > 0)
					 percentage = ((totalPredictionByPeriod.getTotalPrediction() - prevPrediction)/(prevPrediction*1.0f)) * 100.0f;
					else
						percentage = totalPredictionByPeriod.getTotalPrediction() * 100;
				
				prevPrediction = totalPredictionByPeriod.getTotalPrediction();
				
				totalPredictionByPeriod.setVariation(Math.round(percentage));
				totalPredictionByPeriod.setUp(percentage < 0 ? false : true);
				

				 if(ignoreFirst)
	                	ignoreFirst = false;
	                else
				totalPredictionByPeriods.add(totalPredictionByPeriod);
			} 
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPredictionByPeriods;
	}


	@Override
	public List<GetTotalPredictionByPeriod> getTotalPredictionByMonthly() {
		// TODO Auto-generated method stub
		List<GetTotalPredictionByPeriod> totalPredictionByPeriods = new ArrayList<GetTotalPredictionByPeriod>();
		Connection con=null;
		int prevPrediction = 0;
		boolean ignoreFirst = true;
		float percentage = 0;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select  MONTHNAME(STR_TO_DATE(month(c.date), '%m')) as month ,year(c.date)as year,sum(c.cardioarrestdetected)as predicted from cardiodiagnosis c inner join memberinfo m  on m.member_id = c.memberinfo_member_id inner join diseasedetail d on c.cardio_id = d.cardiodiagnosis_cardio_id where Date(c.date) >  DATE_SUB(NOW(), INTERVAL 12 month) group by month(c.date),year(c.date) order by c.date asc");
			while (rs.next()) {
				GetTotalPredictionByPeriod totalPredictionByPeriod =new GetTotalPredictionByPeriod();
				totalPredictionByPeriod.setInterval(rs.getString(1));
				totalPredictionByPeriod.setTotalPrediction(rs.getInt(3));
				
				if(prevPrediction > 0)
				 percentage = ((totalPredictionByPeriod.getTotalPrediction() - prevPrediction)/(prevPrediction*1.0f)) * 100.0f;
				else
					percentage = totalPredictionByPeriod.getTotalPrediction() * 100;
					
				prevPrediction = totalPredictionByPeriod.getTotalPrediction();
				
				totalPredictionByPeriod.setVariation(Math.round(percentage));
				
				totalPredictionByPeriod.setUp(percentage < 0 ? false : true);
				
                if(ignoreFirst)
                	ignoreFirst = false;
                else
				totalPredictionByPeriods.add(totalPredictionByPeriod);
			} 
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPredictionByPeriods;
	}


	@Override
	public List<GetTotalPredictionByPeriod> getTotalPredictionByYearly() {
		// TODO Auto-generated method stub
		List<GetTotalPredictionByPeriod> totalPredictionByPeriods = new ArrayList<GetTotalPredictionByPeriod>();
		Connection con=null;
		int prevPrediction = 1;
		float percentage = 0;
		try {
			con = DataSource.getConnetion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select year(c.date) as year,sum(c.cardioarrestdetected) as predicted, sum(d.isrecovered) as cured from cardiodiagnosis c  inner join memberinfo m inner join diseasedetail d on m.member_id = c.memberinfo_member_id and c.cardio_id = d.cardiodiagnosis_cardio_id  group by year(c.date);");
			while (rs.next()) {
				GetTotalPredictionByPeriod totalPredictionByPeriod =new GetTotalPredictionByPeriod();
				totalPredictionByPeriod.setInterval(rs.getString(1));
				totalPredictionByPeriod.setTotalPrediction(rs.getInt(2));
				
				
				if(prevPrediction > 0)
					 percentage = ((totalPredictionByPeriod.getTotalPrediction() - prevPrediction)/(prevPrediction*1.0f)) * 100.0f;
					else
						percentage = totalPredictionByPeriod.getTotalPrediction() * 100;
						
				prevPrediction = totalPredictionByPeriod.getTotalPrediction();
				
				totalPredictionByPeriod.setVariation(Math.round(percentage));
				totalPredictionByPeriod.setUp(percentage < 0 ? false : true);
				

				totalPredictionByPeriods.add(totalPredictionByPeriod);
			} 
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalPredictionByPeriods;
	}


	@Override
	public int getPredictionOfChestPainValueByDay(String memberid, int curDay) {
		// TODO Auto-generated method stub
		 Connection con=null;
		 int dayPrediction = 0;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select sum(s.cp) from symptom s inner join cardiodiagnosis c on s.cardiodiagnosis_cardio_id = c.cardio_id inner join memberinfo m on m.member_id = c.memberinfo_member_id where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW() - interval "+curDay+" day) ");
	            else
	                rs = stmt.executeQuery("select sum(s.cp) from symptom s inner join cardiodiagnosis c on s.cardiodiagnosis_cardio_id = c.cardio_id inner join memberinfo m on m.member_id = c.memberinfo_member_id where c.cardioarrestdetected = 1 and  DATE(s.date) = DATE(NOW() - interval "+curDay+" day) and m.member_id = '"+memberid+"';");
	         
	            while (rs.next()) {
	            	
	            	dayPrediction = rs.getInt(1);
	            	
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return dayPrediction;
	}


	@Override
	public int getPredictionOfBloodPressureByDay(String memberid, int curDay) {
		// TODO Auto-generated method stub
		 Connection con=null;
		 int dayPrediction = 0;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select sum(b.bloodpressure) from bloodtest b inner join cardiodiagnosis c \r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW() - interval "+curDay+" day) ;");
	            else
	                rs = stmt.executeQuery("select sum(b.bloodpressure) from bloodtest b inner join cardiodiagnosis c \r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW() - interval "+curDay+" day) and m.member_id = '"+memberid+"'; ;");
	            while (rs.next()) {
	            	
	            	dayPrediction = rs.getInt(1);
	            	
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return dayPrediction;
	}


	@Override
	public int getPredictionOfCholesterolByDay(String memberid, int curDay) {
		// TODO Auto-generated method stub
		 Connection con=null;
		 int dayPrediction = 0;
	        try {
	            con = DataSource.getConnetion();
	            Statement stmt = con.createStatement();
	            ResultSet rs;
	           
	            if(memberid == null)
	                 rs = stmt.executeQuery("select sum(b.serumcholesterol) from bloodtest b inner join cardiodiagnosis c\r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()- interval "+curDay+" day) ;");
	            else
	                rs = stmt.executeQuery("select sum(b.serumcholesterol) from bloodtest b inner join cardiodiagnosis c\r\n" + 
	                 		"on b.cardiodiagnosis_cardio_id = c.cardio_id\r\n" + 
	                 		"inner join memberinfo m \r\n" + 
	                 		"on m.member_id = c.memberinfo_member_id\r\n" + 
	                 		"where c.cardioarrestdetected = 1 and  DATE(b.date) = DATE(NOW()- interval "+curDay+" day) and m.member_id = '"+memberid+"';");
	         
	            while (rs.next()) {
	            	
	            	dayPrediction = rs.getInt(1);
	            	
	            }
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return dayPrediction;
	}


	
	
}
