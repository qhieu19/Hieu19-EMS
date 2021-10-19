package Fsoft.MockProject.repository;


import Fsoft.MockProject.entities.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    @Query("select c from Certificate c where c.eId = ?1")
    List<Certificate> getCertificateByEId(int eid);
}
