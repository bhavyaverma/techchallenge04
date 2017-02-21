package Dao;
import bean.Bean;
import ravi.util.DBConnectionManager;
import java.sql.*;

public class OauthDao {
	public void create(Bean bean) throws SQLException{
       Connection con = (Connection) DBConnectionManager.getConnection();
       PreparedStatement ps=null;
       String query1 = "insert into marketplace(Part, Baseurl, uuid, Oid, Emailid) VALUES (?,?,?,?,?)";
       String query2= "insert into company(uuid,Name,Emailid,PhoneNo,Website,Country,m_uuid) VALUES (?,?,?,?,?,?,?) ";
       ps = (PreparedStatement) con.prepareStatement(query1);
       ps.setString(1, bean.getMarketplace().getPartner());
       ps.setString(2, bean.getMarketplace().getBaseUrl());
       ps.setString(3, bean.getCreator().getUuid());
       ps.setString(4, bean.getCreator().getOpenId());
       ps.setString(5, bean.getCreator().getEmail());
       ps.executeUpdate();
       ps = (PreparedStatement) con.prepareStatement(query2);
       ps.setString(1, bean.getPayload().getCompany().getUuid());
       ps.setString(2, bean.getPayload().getCompany().getName());
       ps.setString(3, bean.getPayload().getCompany().getEmail());
       ps.setString(4, bean.getPayload().getCompany().getPhoneNumber());
       ps.setString(5, bean.getPayload().getCompany().getWebsite());
       ps.setString(6, bean.getPayload().getCompany().getCountry());
       ps.setString(7, bean.getCreator().getUuid());
       ps.executeUpdate();
	}
}
