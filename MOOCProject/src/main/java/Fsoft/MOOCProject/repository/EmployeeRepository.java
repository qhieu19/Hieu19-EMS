package Fsoft.MOOCProject.repository;

import Fsoft.MOOCProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MOOCProject.entities.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.fullName like %?1%")
    List<EmployeeResponse> searchEmployeeByName(String keyword);

    @Query("select e from Employee e where e.type = ?1")
    List<EmployeeResponse> getEmployeeByType(String type);

    @Query("select  e from Employee e order by e.type")
    List<EmployeeResponse> getEmployeeOrderByType();

    @Query("select  e from Employee e order by e.fullName")
    List<EmployeeResponse> getEmployeeOrderByFullName();
}
