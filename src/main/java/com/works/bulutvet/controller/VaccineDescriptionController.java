package com.works.bulutvet.controller;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.FarmStockRepository;
import com.works.bulutvet.repositories.FarmVaccineRepository;
import com.works.bulutvet.repositories.PetStockRepository;
import com.works.bulutvet.repositories.PetVaccineRepository;
import com.works.bulutvet.services.UtilService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/vaccineDescription")
@Controller
public class VaccineDescriptionController {
    final UtilService uService;
    final PetVaccineRepository pRepo;
    final FarmVaccineRepository fRepo;
    final PetStockRepository psRepo;
    final FarmStockRepository fsRepo;


    public VaccineDescriptionController(UtilService uService, PetVaccineRepository pRepo, FarmVaccineRepository fRepo, PetStockRepository psRepo, FarmStockRepository fsRepo) {
        this.uService = uService;
        this.pRepo = pRepo;
        this.fRepo = fRepo;
        this.psRepo = psRepo;
        this.fsRepo = fsRepo;
    }
    PetStock petStockUpdate = new PetStock();
    FarmStock farmStockUpdate = new FarmStock();
    @GetMapping("")
    public String vaccineDescription(Model model){
        model.addAttribute("ls",uService.categoryGroupList());
        model.addAttribute("ls1",uService.vendorList());
        model.addAttribute("depos",uService.depoList());
        return "vaccineDescription";
    }

    @ResponseBody
    @PostMapping("/petVaccineAdd")
    public PetVaccine addPetVaccine(@RequestBody PetVaccine petVaccine){

        PetVaccine p = pRepo.save(petVaccine);

        return p;

    }
    @ResponseBody
    @PostMapping("/farmVaccineAdd")
    public FarmVaccine addFarmVaccine(@RequestBody FarmVaccine farmVaccine){

        FarmVaccine f = fRepo.save(farmVaccine);

        return f;

    }

    @ResponseBody
    @GetMapping("/petList")
    public List<PetVaccine> listPet(){

        return pRepo.findAll();

    }

    @ResponseBody
    @GetMapping("/farmList")
    public List<FarmVaccine> listFarm(){

        return fRepo.findAll();

    }

    @ResponseBody
    @DeleteMapping("/delete/{stPid}")
    public String deletePet(@PathVariable String stPid){
        String status = "0";
        System.out.println("stPid: " + stPid);
        try {
            int pet_vaccine_id = Integer.parseInt(stPid);
            pRepo.deleteById(pet_vaccine_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }

    @ResponseBody
    @DeleteMapping("/{stFid}")
    public String deleteFarm(@PathVariable String stFid){
        String status = "0";
        System.out.println("stFid: " + stFid);
        try {
            int farm_vaccine_id = Integer.parseInt(stFid);
            fRepo.deleteById(farm_vaccine_id);
            status = "1";
        } catch (Exception e) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!" + e);
        }
        return status;
    }

    @ResponseBody
    @PostMapping("/addPetStock")
    public PetStock addPetStock(@RequestBody PetStock petStock){
        try {
            if ( petStockUpdate.getPsid() != null && petStockUpdate.getPsid() > 0  ) {
                petStock.setPsid(petStockUpdate.getPsid());
            }
            psRepo.saveAndFlush(petStock);
            petStockUpdate = new PetStock();
        }catch (Exception ex) {

            System.err.println("Bu mail adresi daha önceden kayıt edilmiş!");
        }
        return petStockUpdate;

    }

    @ResponseBody
    @GetMapping("/petStockDepo/{stDid}")
    public List<PetStockJoinDepo> petStockJoinDepos(Model model, @PathVariable String stDid){

        int depo_id = Integer.parseInt(stDid);
        List<PetStockJoinDepo> petStockJoinDepos = psRepo.petStockJoinDepo(depo_id);
        model.addAttribute("ls3",petStockJoinDepos);

        return petStockJoinDepos;

    }

    @ResponseBody
    @GetMapping("/petStockUpdate/{stPsid}")
    public String petStockUpdate(@PathVariable String stPsid){
        try {
            int psid = Integer.parseInt(stPsid);
            petStockUpdate = psRepo.findById(psid).get();
        }catch (Exception ex) {
            System.err.println( "Update işlemi sırasında bir hata oluştu!");
        }
        return "redirect:/vaccineDescription";
    }

    @ResponseBody
    @DeleteMapping("/petStockDelete/{stPsid}")
    public String petStockDelete(@PathVariable String stPsid){
        String status = "0";
        try {
            int psid = Integer.parseInt(stPsid);
            psRepo.deleteById(psid);
            petStockUpdate = new PetStock();
            status = "1";
        }catch (Exception ex) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!");
        }
        return status;

    }



    @ResponseBody
    @PostMapping("/addFarmStock")
    public FarmStock addFarmStock(@RequestBody FarmStock farmStock){
        try {
            if ( farmStockUpdate.getFsid() != null && farmStockUpdate.getFsid() > 0  ) {
                farmStock.setFsid(farmStockUpdate.getFsid());
            }
            fsRepo.saveAndFlush(farmStock);
            farmStockUpdate = new FarmStock();
        }catch (Exception ex) {

            System.err.println("Bu mail adresi daha önceden kayıt edilmiş!");
        }
        return farmStockUpdate;

    }

    @ResponseBody
    @GetMapping("/farmStockDepo/{stWid}")
    public List<FarmStockJoinDepo> farmStockJoinDepos(Model model, @PathVariable String stWid){

        int depo_id = Integer.parseInt(stWid);
        List<FarmStockJoinDepo> farmStockJoinDepos = fsRepo.farmStockJoinDepo(depo_id);
        model.addAttribute("ls4",farmStockJoinDepos);

        return farmStockJoinDepos;

    }

    @ResponseBody
    @GetMapping("/farmStockUpdate/{stFsid}")
    public String farmStockUpdate(@PathVariable String stFsid){
        try {
            int fsid = Integer.parseInt(stFsid);
            farmStockUpdate = fsRepo.findById(fsid).get();
        }catch (Exception ex) {
            System.err.println( "Update işlemi sırasında bir hata oluştu!");
        }
        return "redirect:/vaccineDescription";
    }

    @ResponseBody
    @DeleteMapping("/farmStockDelete/{stFsid}")
    public String farmStockDelete(@PathVariable String stFsid){
        String status = "0";
        try {
            int fsid = Integer.parseInt(stFsid);
            fsRepo.deleteById(fsid);
            farmStockUpdate = new FarmStock();
            status = "1";
        }catch (Exception ex) {
            System.err.println("Silme işlemi sırasında bir hata oluştu!");
        }
        return status;

    }



}
