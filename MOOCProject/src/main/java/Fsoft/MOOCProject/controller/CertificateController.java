package Fsoft.MOOCProject.controller;

import Fsoft.MOOCProject.entities.entitiesDTO.request.CertificateRequest;
import Fsoft.MOOCProject.entities.entitiesDTO.response.CertificateResponse;
import Fsoft.MOOCProject.entities.model.Certificate;
import Fsoft.MOOCProject.services.service_interface.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certificate")
public class CertificateController {
//    @Autowired
//    private CertificateService certificateService;
//
//    @PostMapping("/add")
//    public CertificateResponse add(@RequestBody CertificateRequest certificate, @RequestParam("eid") int eid){
//       return certificateService.add(certificate,eid);
//    }
//
//    @GetMapping("/list")
//    public List<CertificateResponse> list(){
//        return certificateService.list();
//    }
//
//    @GetMapping("/listbyemp")
//    public List<Certificate> listByEmp(@RequestParam int eid){return certificateService.getAllByEid(eid);}
//
//    @PutMapping("/update")
//    public String update(@RequestBody Certificate certificate, @RequestParam("id") int id){
//        return certificateService.update(certificate, id);
//    }
//
//    @DeleteMapping("/delete")
//    public String delete(@RequestParam int id){
//        return certificateService.delete(id);
//    }
}
