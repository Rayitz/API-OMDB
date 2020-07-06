package com.raymundo.gonet.utilities;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.raymundo.gonet.bean.MessageBean;
import com.raymundo.gonet.bean.RatingMovieBean;

public class Utilities {
	
	public static String ratingListToJson(List<RatingMovieBean> rList){
		
        ObjectMapper Obj = new ObjectMapper(); 
        String jsonStr = null;
        try { 
            jsonStr = Obj.writeValueAsString(rList); 
  
            System.out.println(jsonStr); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
   	
		return jsonStr;
	}
	
	public static String objectToJson(Object object){
		
        ObjectMapper Obj = new ObjectMapper(); 
        String jsonStr = null;
        try { 
            jsonStr = Obj.writeValueAsString(object); 
  
            System.out.println(jsonStr); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
   	
		return jsonStr;
	}
	
	public static String mensajeToJson(MessageBean bean){
		
        ObjectMapper Obj = new ObjectMapper(); 
        String jsonStr = null;
        try { 
            jsonStr = Obj.writeValueAsString(bean); 
  
            System.out.println(jsonStr); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
   	
		return jsonStr;
	}

}
