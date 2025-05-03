package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Department;
import exception.DeptNotFoundException;
import util.DBcon;

public class Departmentserviceimpl implements Departmentservice {

    @Override
    public List<Department> getAllDepartmentss() {
        List<Department> list = new ArrayList<>();
        String query = "SELECT * FROM Department";

        try (Connection con = DBcon.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Department dept = new Department();
                dept.setDeptid(rs.getInt("deptid"));
                dept.setDeptname(rs.getString("deptname"));
                list.add(dept);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
	public Department getDepartmentById(int deptid) {
 
			String sql = "SELECT * FROM Department WHERE deptid = ?";
			Department dept = null;
	        try(Connection conn = DBcon.getConnection();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, deptid);
	            ResultSet rs = stmt.executeQuery();
	            int departmentID=0;
	            if(rs!=null)
	            {
	            while(rs.next())
 
				{
 
	            departmentID = rs.getInt("deptid");
	            String departmentName = rs.getString("deptname");
	            System.out.println("ID: " + departmentID + ", Name: " + departmentName);
 
				}
 
	            }
	            if(departmentID != deptid)
		            throw new DeptNotFoundException("Department with depid: " + deptid + " not found");
		            return dept;
	        }
	        catch (DeptNotFoundException e) {
	        	System.out.println(e.getMessage());
	        }
	        catch (Exception e) {
	            System.out.println("Error Occurred : " + e.getMessage());
 
	        }
	           /* if(departmentID != deptid)
	            throw new Exception("Department with depid: " + deptid + " not found");
	            return dept;
	        } catch (SQLException e) {
	            System.out.println("Error Occurred 2: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error Occurred : " + e.getMessage());
	
	        }*/
	        return null;
 
		
	}
    public boolean deleteDepartmentById(int deptid) {
        String checkSql = "SELECT * FROM Department WHERE deptid = ?";
        String deleteSql = "DELETE FROM Department WHERE deptid = ?";

        try (Connection con = DBcon.getConnection()) {
            // Check if department exists
            PreparedStatement checkStmt = con.prepareStatement(checkSql);
            checkStmt.setInt(1, deptid);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                throw new DeptNotFoundException("Department with deptid: " + deptid + " not found");
            }

            // Department exists, delete it
            PreparedStatement deleteStmt = con.prepareStatement(deleteSql);
            deleteStmt.setInt(1, deptid);
            int affected = deleteStmt.executeUpdate();

            return affected > 0;

        } catch (DeptNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error occurred while deleting department: " + e.getMessage());
        }

        return false;
    }

	@Override
	public boolean deleteDepartment(int deptid) {
		// TODO Auto-generated method stub
		return false;
	}

    
 
	
}

