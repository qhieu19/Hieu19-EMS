package Fsoft.MockProject.services.service_interface;

import Fsoft.MockProject.entities.ResponseAPI;
import Fsoft.MockProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MockProject.entities.entitiesDTO.response.CertificateResponse;

import java.util.List;

public interface CertificateService {
    List<CertificateResponse> getAll();
    List<CertificateResponse> getById(int eid);
    CertificateResponse addComplex(CertificateRequest certificateRequest, int eid);
    ResponseAPI add(CertificateRequest certificateRequest, int eid);
    ResponseAPI update(CertificateRequest certificateRequest, int id);
    ResponseAPI delete(int id);
}
