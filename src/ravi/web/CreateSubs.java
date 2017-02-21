package ravi.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import ravi.model.MySubs;
import ravi.services.Oath;
@WebServlet(name = "CreateSubs")
public class CreateSubs extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String eventUrl = (String) request.getParameter("eventUrl");
        String hitUrl = Oath.hiteventUrl(eventUrl);
        
        //System.out.println(hitUrl);
        System.out.println(eventUrl);
        ObjectMapper mapper = new ObjectMapper();
        MySubs s = new MySubs("786xyz", "true");
        
        
        System.out.println("#############"+eventUrl);
       
        String OauthData = Oath.hiteventUrl(eventUrl);
        System.out.println(OauthData);
        String json = mapper.writeValueAsString(s);
        out.print(json);
        
/*
        BufferedReader reader = request.getReader();
        User user1 = mapper.readValue(reader, User.class);
*/

        // TestJson testJson = new TestJson();
        // testJson.setEventUrl(eventUrl);
   //    testJson.setUser(user1);

        
}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
       // User u1 = new User(1, "ravi");
       
        //System.out.println(s); 
        
        
         
    }
}