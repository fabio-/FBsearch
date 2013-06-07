package Random_Rating;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class RandomRatingFinal {

	public ArrayList<String> evntId;
	public ArrayList<String> evnt1;
	public ArrayList<String> evnt2;

	public RandomRatingFinal(){
		evntId= new ArrayList<String>();
		evnt1= new ArrayList<String>();
		evnt2= new ArrayList<String>();
	}
	public void readEventIdFile(){
		try{
			// Create file 
			FileReader f = new FileReader("C:/Users/LITON/Desktop/eventId.txt");
			BufferedReader br = new BufferedReader(f);

			String n;

			while( (n = br.readLine()) != null ){
				
				String firstSplit = n.substring(0, 7);
				evnt1.add(firstSplit);
				String secSplit = n.substring(7, 15);	
				evnt2.add(secSplit);
				//String toAdd = firstSplit+";"+secSplit;
				//	evntId.add(toAdd);
			}
			br.close();
			f.close();
		}catch(Exception e ){}
	}

	public void createCSVFile(){
		ArrayList<String> a = new ArrayList<String>();
		readEventIdFile();

		//For Jazz users
		int userID = 2000+1;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j  ++){
			if(j>=0 &&j<100){

				a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userRock = 2000+2;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=100 &&j<200){

				a.add(userRock+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userRock+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userHipHop = 2000+3;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=200 &&j<300){

				a.add(userHipHop+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userHipHop+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userBolzano = 2000+4;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=300 &&j<400){

				a.add(userBolzano+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userBolzano+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userNewYork = 2000+5;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=400 &&j<500){

				a.add(userNewYork+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userNewYork+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userRome = 2000+6;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=500 &&j<600){

				a.add(userRome+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userRome+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userBerlin = 2000+7;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=600 &&j<700){

				a.add(userBerlin+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userBerlin+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userBMW = 2000+8;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=700 &&j<800){

				a.add(userBMW+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userBMW+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userAudi = 2000+9;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=800 &&j<900){

				a.add(userAudi+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userAudi+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userFerrari = 2000+10;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=900 &&j<1000){

				a.add(userFerrari+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userFerrari+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}

		int userToyota = 2000+11;
		for(int j = 0; j< evnt1.size()&& j<evnt2.size();j ++){
			if(j>=1000 &&j<1100){

				a.add(userToyota+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
			}else{
				a.add(userToyota+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
			}
		}
		System.out.println(a.size());
		try{
			//String name = System.getProperty("user.name");
			FileWriter fw = new FileWriter("C:/wamp/www/DataRanking.csv");
			BufferedWriter bw = new BufferedWriter(fw); 
			bw.newLine();
			for(int i = 0; i<a.size();i++){
				bw.append(a.get(i));
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		}catch(Exception e){}
	}
	public int getRandomNumberBetween(int min, int max) {
		Random foo = new Random();
		int randomNumber = foo.nextInt((max + 1) - min) + min;

		return randomNumber;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomRatingFinal a = new RandomRatingFinal();
		//		for(int i = 0 ; i <1000;i++){
		//			System.out.println(a.getRandomNumberBetween(1, 3));
		//		}
		a.createCSVFile();

	}

}
