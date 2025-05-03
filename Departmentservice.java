package dao;

import java.util.List;
import Model.Department;

public interface Departmentservice {
    List<Department> getAllDepartmentss();
    Department getDepartmentById(int id); 
    public boolean deleteDepartment(int deptid);
}
