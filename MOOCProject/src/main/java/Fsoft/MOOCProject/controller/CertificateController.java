package Fsoft.MOOCProject.controller;

import Fsoft.MOOCProject.entities.ResponseAPI;
import Fsoft.MOOCProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.CertificateResponse;
import Fsoft.MOOCProject.services.service_interface.CertificateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping("/list")
    public List<CertificateResponse> list(){
        return this.certificateService.getAll();
    }

    @PostMapping("/addComplex/{eid}")
    public CertificateResponse addComplex(@RequestBody CertificateRequest certificateRequest,@PathVariable int eid){
        return this.certificateService.addComplex(certificateRequest, eid);
    }

    @PostMapping("/add/{eid}")
    public ResponseAPI add(@RequestBody CertificateRequest certificateRequest,@PathVariable int eid){
        return this.certificateService.add(certificateRequest, eid);
    }

    @PutMapping("/update/{id}")
    public ResponseAPI update(@RequestBody CertificateRequest certificateRequest,@PathVariable int id){
        return this.certificateService.update(certificateRequest, id);
    }

    @DeleteMapping("/delete")
    public ResponseAPI delete(@PathVariable int id){
        return this.certificateService.delete(id);
    }
}
