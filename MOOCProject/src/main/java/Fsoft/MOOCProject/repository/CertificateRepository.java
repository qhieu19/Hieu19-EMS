package Fsoft.MOOCProject.repository;


import Fsoft.MOOCProject.entities.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}
