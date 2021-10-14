package Fsoft.MOOCProject.services.service_interface;

import Fsoft.MOOCProject.entities.ResponseAPI;
import Fsoft.MOOCProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.CertificateResponse;

import java.util.List;

public interface CertificateService {
    List<CertificateResponse> getAll();
    CertificateResponse addComplex(CertificateRequest certificateRequest, int eid);
    ResponseAPI add(CertificateRequest certificateRequest, int eid);
    ResponseAPI update(CertificateRequest certificateRequest, int id);
    ResponseAPI delete(int id);
}
