package Fsoft.MockProject.repository;

import Fsoft.MockProject.entities.entitiesDTO.response.EmployeeResponse;
import Fsoft.MockProject.entities.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE e.fullName like %?1%")
    List<Employee> searchEmployeeByName(String keyword);

    @Query("select e from Employee e where e.type = ?1")
    List<Employee> getEmployeeByType(String type);

    @Query("select  e from Employee e order by e.type")
    List<Employee> getEmployeeOrderByType();

    @Query("select  e from Employee e order by e.fullName")
    List<Employee> getEmployeeOrderByFullName();

    @Query("select e from Employee e")
    List<EmployeeResponse> test();
}
