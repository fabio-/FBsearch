import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class RandomRatingFinal {

	public ArrayList<String> evntId;
	public ArrayList<String> evnt1 ;
	public ArrayList<String> evnt2;

	public RandomRatingFinal(){
		evntId= new ArrayList<String>();
		evnt1= new ArrayList<String>(1100);
		evnt2= new ArrayList<String>(1100);
	}
	public void readEventIdFile(){
		try{
			// Create file 
			FileReader f = new FileReader("eventId.txt");
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

			System.out.println(evnt1.size());
			System.out.println(evnt2.size());
		}catch(Exception e ){}
	}

	public void createCSVFile(){
		ArrayList<String> a = new ArrayList<String>();
		readEventIdFile();

		//For Jazz users
		int userID = 2000;
		for(int i = 0 ; i < 30; i ++){
			userID = userID+i+1;
			for(int j = 0; j< 300;j  ++){
				if(j>=0 &&j<100){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
				
			}
		}

		//For Rock user
		for(int  i = 0; i< 30;i ++){
			userID = userID+i+1;
			for(int j = 0; j< 300;j ++){
				if(j>=100 &&j<200){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//For Hip Hop users
		for(int i = 0;i<30;i++){
			userID = userID+i+1;
			for(int j = 0; j< 300;j ++){
				if(j>=200 &&j<300){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//User bolzano

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 300; j< 700;j ++){
				if(j>=300 &&j<400){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}

			
		}

		//For user New York

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 300; j< 700;j ++){
				if(j>=400 &&j<500){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//For user ROME
		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 300; j< 700;j ++){
				if(j>=500 &&j<600){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//User Berlin

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 300; j< 700;j ++){
				if(j>=600 &&j<700){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//For user BMW

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 700; j< evnt1.size()&& j< evnt2.size() ;j ++){
				if(j>=700 &&j<800){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//For users AUDI

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 700; j< evnt1.size()&& j< evnt2.size();j ++){
				if(j>=800 &&j<900){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//For user Ferrari
		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 700; j< evnt1.size()&& j< evnt2.size();j ++){
				if(j>=900 &&j<1000){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}
			
		}

		//User Toyota

		for(int i =0;i<30;i++){
			userID = userID+i+1;
			for(int j = 700; j< evnt1.size()&& j< evnt2.size();j ++){
				if(j>=1000 &&j<1100){

					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(3, 5)+";"+evnt2.get(j));
				}else{
					a.add(userID+";"+evnt1.get(j)+";"+getRandomNumberBetween(1, 3)+";"+evnt2.get(j));
				}
			}

			
		}
		System.out.println(a.size());
		try{
			//String name = System.getProperty("user.name");
			FileWriter fw = new FileWriter("DataRanking.csv");
			BufferedWriter bw = new BufferedWriter(fw); 
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
		a.createCSVFile();

	}

}
