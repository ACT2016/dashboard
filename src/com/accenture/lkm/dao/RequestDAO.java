package com.accenture.lkm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acceture.lkm.beans.Employee;
import com.acceture.lkm.beans.Request;
import com.acceture.lkm.beans.Step;

/**
 * @author Christophe Coenraets
 */
public class RequestDAO {

       
    public List<Request> findByFlowStep(String flowid, String stepid) {
        List<Request> list = new ArrayList<Request>();
        Connection c = null;
    	String sql = "select a.* from flowdetails a "
    			+ "left outer join "
    			+ "		steps b on a.stepId=b.stepid "
    			+ "        left outer join flows c on c.flowid=b.flowid where c.flowid='"+flowid+"'and a.stepid in ('"+stepid+"')";
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(processSummaryRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return list;
    }
    
   
    protected Request processSummaryRow(ResultSet rs) throws SQLException {
    	
    	Request request = new Request();
    	
    	request.setFlowStepId(rs.getString("flowStepId"));
    	request.setStepId(rs.getString("stepId"));
    	request.setSequence(rs.getString("sequence"));
    	request.setMethod(rs.getString("method"));
    	request.setResponeCode(rs.getString("responseCode"));
    	
    	if(rs.getString("apiUrl") == null) {
    		request.setApiUrl("URL is not available");
    	}    		
    	else {
    		request.setApiUrl(rs.getString("apiUrl"));
    	}
    	
    	return request;
    }
    
}
