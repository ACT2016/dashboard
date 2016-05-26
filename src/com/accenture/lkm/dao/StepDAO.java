package com.accenture.lkm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acceture.lkm.beans.Employee;
import com.acceture.lkm.beans.Step;

/**
 * @author Christophe Coenraets
 */
public class StepDAO {

       
    public List<Step> findStepsByName(String id) {
        List<Step> list = new ArrayList<Step>();
        Connection c = null;
    	String sql = "select * from steps where flowid='"+id+"'";
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
    

    public Employee save(Employee employee)
	{
		return employee.getId() > 0 ? update(employee) : create(employee);
	}    
    
    public Employee create(Employee employee) {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = ConnectionHelper.getConnection();
            ps = c.prepareStatement("INSERT INTO employee (firstName, lastName, title, department, managerId, city, officePhone, cellPhone, email, picture) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                new String[] { "ID" });
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getTitle());
            ps.setString(4, employee.getDepartment());
            ps.setInt(5, employee.getManager() == null ? 0 : employee.getManager().getId());
            ps.setString(6, employee.getCity());
            ps.setString(7, employee.getOfficePhone());
            ps.setString(8, employee.getCellPhone());
            ps.setString(9, employee.getEmail());
            ps.setString(10, employee.getPicture());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            // Update the id in the returned object. This is important as this value must be returned to the client.
            int id = rs.getInt(1);
            employee.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return employee;
    }

    public Employee update(Employee employee) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("UPDATE employee SET firstName=?, lastName=?, title=?, deptartment=?, managerId=?, city=?, officePhone, cellPhone=?, email=?, picture=? WHERE id=?");
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getTitle());
            ps.setString(4, employee.getDepartment());
            ps.setInt(5, employee.getManager().getId());
            ps.setString(6, employee.getCity());
            ps.setString(7, employee.getOfficePhone());
            ps.setString(8, employee.getCellPhone());
            ps.setString(9, employee.getEmail());
            ps.setString(10, employee.getPicture());
            ps.setInt(11, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
        return employee;
    }

    public boolean remove(Employee employee) {
        Connection c = null;
        try {
            c = ConnectionHelper.getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, employee.getId());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
    }

 
    
    protected Step processSummaryRow(ResultSet rs) throws SQLException {
    	Step step = new Step();
    	step.setStepId(rs.getString("stepId"));
    	step.setExpectedResult(rs.getString("expectedResult"));
    	step.setStepDescription(rs.getString("stepDescription"));
    	step.setStepName(rs.getString("stepName"));
    	step.setFlowId(rs.getString("flowId"));
    	return step;
    }
    
}
