package ravi.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import Dao.OauthDao;
import bean.Bean;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class Oath {
	static OauthDao dao;
    static{
        dao = new OauthDao();
    }
	public static String hiteventUrl(String eventUrl){
	String responseJson = "";
	try{
		DefaultOAuthConsumer e = new DefaultOAuthConsumer("bhavyatech-151946","dQXCsfxOIlGtCNp0");
        URL url = new URL(eventUrl);
        HttpURLConnection request = (HttpURLConnection)url.openConnection();
        request.setRequestProperty("Accept", "application/json");
        e.sign(request);
        int responseCode = request.getResponseCode();
        System.out.println("Sending \'GET\' request to URL : {}" + eventUrl);
        System.out.println("Response Code : {}" + Integer.valueOf(responseCode));
        BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuffer response = new StringBuffer();

        String inputLine;
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();
        responseJson = response.toString();
        System.out.println("Response json from app direct server is - {}" + responseJson);
        Bean bean = new Bean();
        bean = new ObjectMapper().readValue(responseJson, Bean.class);
         System.out.println("*******************" + bean.getFlag());
         dao.create(bean);
    } 
	catch (Exception var9) {
    	System.out.println("Error fetching data from eventUrl - {}" +  var9.getMessage());
    
	}
    return responseJson;
		
	

	}
	}
