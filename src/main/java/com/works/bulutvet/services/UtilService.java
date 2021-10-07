package com.works.bulutvet.services;

import com.works.bulutvet.entities.*;
import com.works.bulutvet.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilService {
    final CustomerRepository cRepo;
    final UserRepository uRepo;
    final CategoryGroupRepository cgRepo;
    final VendorRepository vRepo;
    final DepoRepository dRepo;
    final ProductRepository pRepo;
    final AnimalRepository aRepo;
    final CustomerPaySaleRepository cpRepo;
    final RetailSaleRepository rRepo;
    final BuyingRepository bRepo;
    final LaboratuvarRepository lRepo;

    final ScheduleCalendarRepository sRepo;


    public UtilService(CustomerRepository cRepo, UserRepository uRepo, CategoryGroupRepository cgRepo, VendorRepository vRepo, DepoRepository dRepo, ProductRepository pRepo, AnimalRepository aRepo, CustomerPaySaleRepository cpRepo, RetailSaleRepository rRepo, BuyingRepository bRepo, LaboratuvarRepository lRepo, ScheduleCalendarRepository sRepo) {
        this.cRepo = cRepo;
        this.uRepo = uRepo;
        this.cgRepo = cgRepo;
        this.vRepo = vRepo;
        this.dRepo = dRepo;
        this.pRepo = pRepo;
        this.aRepo = aRepo;
        this.cpRepo = cpRepo;
        this.rRepo = rRepo;
        this.bRepo = bRepo;
        this.lRepo = lRepo;
        this.sRepo = sRepo;
    }

    public List<CategoryGroup> categoryGroupList(){
        List<CategoryGroup> ls = cgRepo.findAll();
        return ls;
    }

    public List<Vendor> vendorList(){
        List<Vendor> ls1 = vRepo.findAll();
        return ls1;
    }

    public List<Depo> depoList(){
        List<Depo> depos = dRepo.findAll();
        return depos;
    }


    public List<Customer> customerList(){
       List<Customer> clist=cRepo.findAll();
       return clist;
    }

    public List<Product> producstList(){
        List<Product> plist = pRepo.findAll();
        return plist;
    }

    public  List<User> userList(){
        List<User> userList=uRepo.findAll();
        return userList;
    }
    public Customer customerDetail(String stCd){
        int cd=Integer.parseInt(stCd);
       Customer customer= cRepo.findById(cd).get();
       return customer;
    }

    public List<Animal> animalList(){
        List<Animal> animalList=aRepo.findAll();
        return animalList;
    }

    public List<ScheduleCalendar> scheduleCalendars(){
        List<ScheduleCalendar> calendars = sRepo.findAll();
        return calendars;
    }

    public int total(){

        int customer_pay = cpRepo.customerSale();
        int retail_pay = rRepo.retailSale();

        int buying_pay = bRepo.customerBuying();

        int sum = (customer_pay+retail_pay)-buying_pay;
        System.out.println(sum);
        return sum;

    }

    public int countSale(){
        int count = cpRepo.countSale();
        int count2 = rRepo.countSale();

        int sum2 = count + count2;

        return sum2;
    }

    public int countlab(){
        int countlab = lRepo.countlab();

        return countlab;

    }








}
