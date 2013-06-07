

	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.AveragingPreferenceInferrer;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
	 
	public class Mahout {

		public static void main(String... args) throws FileNotFoundException, TasteException, IOException, Exception {
			long lastUserId;
	        ArrayList<String> data = new ArrayList<String>();
	        // create data source (model) - from the csv file  
			FileReader fr = new FileReader("C:/wamp/www/DataRanking.csv");
			BufferedReader br  = new BufferedReader(fr);
			
			br.readLine();
			String n ;
			
			while((n=br.readLine())!=null){
				data.add(n);
			}
			
			br.close();
			fr.close();
			
			String[] test = data.get(data.size()-1).split(",");
			lastUserId = Long.parseLong(test[0]);
			
			FileWriter fw = new FileWriter("C:/wamp/www/DataRanking.csv");
			BufferedWriter bw  = new BufferedWriter(fw);
			
			for(int i= 0; i< data.size();i++){
				
				bw.append(data.get(i));
				bw.newLine();
				
			}
			
			bw.close();
			fw.close();
			
	        File ratingsFile = new File("C:/wamp/www/DataRanking.csv");                        
	        DataModel model = new FileDataModel(ratingsFile);
	        
	        //Ashraf Modification
	        UserSimilarity usersimilarity = new PearsonCorrelationSimilarity(model);
	        
	        usersimilarity.setPreferenceInferrer(new AveragingPreferenceInferrer(model));
	        
	        UserNeighborhood nei= new NearestNUserNeighborhood(3,usersimilarity,model);
	        
	        Recommender rec = new GenericUserBasedRecommender(model,nei,usersimilarity);
	        
	        Recommender cach = new CachingRecommender(rec);
	        System.out.println(model.getNumUsers());
	        System.out.println(model.getMaxPreference());
	        model.getItemIDs();
	        List<RecommendedItem> recs = cach.recommend(lastUserId, 10);
	 
	        FileWriter fwMahout = new FileWriter("C:/wamp/www/mahout.txt");
			BufferedWriter bwMahout  = new BufferedWriter(fwMahout);            
            // print the list of recommendations for each 
            for (RecommendedItem recommendedItem : recs) {
            	bwMahout.append(recommendedItem.getItemID()+"");
                System.out.println(recommendedItem.getItemID());
                bwMahout.newLine();
            }
            
            bwMahout.close();
            fwMahout.close();
	             
	    }
		
	}

