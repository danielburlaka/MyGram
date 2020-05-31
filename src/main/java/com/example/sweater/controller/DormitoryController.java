package com.example.sweater.controller;

import com.example.sweater.domain.Dormitory;
import com.example.sweater.service.DormitoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class DormitoryController {

    private DormitoryService dormitoryService;

    @Autowired
    public void setDormitoryService(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }


    @GetMapping("/dormitories")
    public String dormitoryList(Model model){
        model.addAttribute("dormitories",dormitoryService.allDormitories());
        return "dormitory/dormitory";
    }

    @GetMapping("filterDormitories")
    public String filter(@RequestParam String filterDormitories, Model model){
        model.addAttribute("dormitories", dormitoryService.getAllDormitoriesByNumber(filterDormitories));
        return "dormitory/dormitory";
    }



    @GetMapping("/editDormitory/{id}")
    public String dormEditForm(@PathVariable Long id , Model model){
        Dormitory dormitory = dormitoryService.getDormById(id);
        model.addAttribute("dormitory", dormitory);
        return "dormitory/dormEdit";
    }





    @PostMapping("/updateDormitory")
    public String editDormitory(@RequestParam Long id,
                                @RequestParam String dNum,
                               @RequestParam String dAddr,
                               @RequestParam String phone,
                               @RequestParam String conName, Model model){
        return saveOrEdit(id,dNum,dAddr,phone, conName, model, "edit");
    }



    @PostMapping("/dormitories")
    public String addDormitory(@RequestParam String dNum,
                               @RequestParam String dAddr,
                               @RequestParam String phone,
                               @RequestParam String conName, Model model){
        return saveOrEdit(null,dNum,dAddr,phone, conName, model, "save");
    }



    @GetMapping("/delDormitory/{id}")
    public String StudDelForm(@PathVariable Long id , Model model){
        Dormitory dormitory = dormitoryService.getDormById(id);
        model.addAttribute("dormitory", dormitory);
        return "dormitory/dormDel";
    }

    @PostMapping("/deleteDormitory")
    public String studDel(@RequestParam Long id){
        Dormitory dormitory = dormitoryService.getDormById(id);
        dormitoryService.delete(dormitory);

        return "redirect:/dormitories";
    }


    private String saveOrEdit(@RequestParam Long id,
                              @RequestParam String dNum,
                              @RequestParam String dAddr,
                              @RequestParam String phone,
                              @RequestParam String conName, Model model, String choice){

        Dormitory dormitory = new Dormitory();

        dormitory.setAddress(dAddr);
        dormitory.setCommFullName(conName);
        dormitory.setPhone(phone);

        if(dAddr.equals("") || phone.equals("") || conName.equals("")){
            return "errors/errorInput";
        }

        try{
            dormitory.setDormNumber(Integer.valueOf(dNum));

        }catch (NumberFormatException e ){
            return "errors/errorInput";
        }


        dormitoryService.saveDormitory(dormitory);
        List<Dormitory> dormitories = dormitoryService.allDormitories();
        model.addAttribute("dormitories",dormitories);

        if(choice.equals("save")){
            return "dormitory/dormitory";
        }
        if(choice.equals("edit")){
            Dormitory dr = dormitoryService.getDormById(id);
            dormitoryService.delete(dr);

            return "redirect:/dormitories";
        }
        return "/";

    }




}
