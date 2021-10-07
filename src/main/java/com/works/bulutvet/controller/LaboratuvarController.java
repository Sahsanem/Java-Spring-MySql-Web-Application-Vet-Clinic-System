package com.works.bulutvet.controller;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.AnimalRepository;
import com.works.bulutvet.repositories.CustomerRepository;
import com.works.bulutvet.repositories.LaboratuvarRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/laboratuvar")
public class LaboratuvarController {

    final private String UPLOAD_DIR="src/main/resources/static/uploads/";

    final UtilService utilService;
    final CustomerRepository cRepo;
    final AnimalRepository aRepo;
    final LaboratuvarRepository lRepo;
    public LaboratuvarController(UtilService utilService, CustomerRepository cRepo, AnimalRepository aRepo, LaboratuvarRepository lRepo) {
        this.utilService = utilService;
        this.cRepo = cRepo;
        this.aRepo = aRepo;
        this.lRepo = lRepo;
    }

    @GetMapping("")
    public String laboratuvar(Model model){
        model.addAttribute("clist",utilService.customerList());
        model.addAttribute("laboratuvar",new LabInterlayer());
        return "laboratuvar";
    }
    @ResponseBody
    @GetMapping("/detail/{stCid}")
    public Optional<Customer> customerDetail(Model model, @PathVariable String stCid){
        int cid=Integer.parseInt(stCid);
        Optional<Customer> ls= cRepo.findById(cid);
        model.addAttribute("ls",ls);
        return ls;
    }

    @ResponseBody
    @GetMapping("/animalLabCustomer/{Stcus_no}")
    public List<AnimalCustomer> animalLaboratuvarCustomers(Model model, @PathVariable String Stcus_no){
        int cus_no=Integer.parseInt(Stcus_no);
        List<AnimalCustomer> animalCustomers =aRepo.animalCustomer(cus_no);
        model.addAttribute("ls4", animalCustomers);
        return animalCustomers;
    }

    @ResponseBody
    @PostMapping("/labResult/add")
    public Laboratuvar labResultAdd(@RequestBody Laboratuvar laboratuvar){


        Laboratuvar lab=lRepo.save(laboratuvar);

        return lab;
    }
    @ResponseBody
    @GetMapping("/labResultAdd/list")
    public List<AnimalLaboratuvarCustomer> labResultList(){

        return lRepo.animalLaboratuvarCustomer();
    }

    @PostMapping("/imageUpload")
    public String resultAdd(@RequestParam("imageName") MultipartFile file, @ModelAttribute("laboratuvar") LabInterlayer laboratuvar){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String ext = fileName.substring(fileName.length()-5, fileName.length());
        System.out.println(ext);
        String uui = UUID.randomUUID().toString();
        fileName = uui + ext;
        try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            System.out.println(fileName);
            System.out.println(path);

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Laboratuvar laboratuvar1 = new Laboratuvar();
        laboratuvar1.setImageName(fileName);
        laboratuvar1.setLab_type(laboratuvar.getLab_type());
        laboratuvar1.setAnimalName(laboratuvar.getAnimalName());
        laboratuvar1.setDiagnosis(laboratuvar.getDiagnosis());
        laboratuvar1.setCus_no(laboratuvar.getCus_no());

        lRepo.save(laboratuvar1);

        return "redirect:/laboratuvar";
    }

    @ResponseBody
    @DeleteMapping("/delete/{stLid}")
    public String delete(@PathVariable String stLid){
        String status = "0";
        try {
            int lid = Integer.parseInt(stLid);
            lRepo.deleteById(lid);

            status = "1";
        }catch (Exception ex) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!");
        }
        return status;

    }



}
