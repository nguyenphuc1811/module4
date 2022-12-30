package com.codegym.furama.controller;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @GetMapping("")
    public String displayList(@RequestParam(name = "name", defaultValue = "") String name,
                              @RequestParam(name = "facilityType", defaultValue = "") String customerType,
                              @PageableDefault(size = 5) Pageable pageable,
                              Model model) {
        Page<Facility> facilities = facilityService.findAll(name, customerType, pageable);
        model.addAttribute("facilityTypeList", facilityService.facilityTypeList());
        model.addAttribute("rentTypeList", facilityService.rentTypeList());
        model.addAttribute("facilityList", facilities);
        return "views/facility/listFacility";
    }

    @PostMapping("/delete")
    public String deleteFacility(int id) {
        facilityService.deleteFacility(id);
        return "redirect:/facility";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Facility facility = new Facility();
        model.addAttribute("facility", facility);
        model.addAttribute("facilityTypeList", facilityService.facilityTypeList());
        model.addAttribute("rentTypeList", facilityService.rentTypeList());
        return "views/facility/formAdd";
    }

    @PostMapping("/add")
    public String addConfirm(Facility facility, RedirectAttributes attributes) {
        if (facilityService.addFacility(facility)) {
            attributes.addFlashAttribute("mess", "Thêm mới thành công");
        } else {
            attributes.addFlashAttribute("mess", "Thêm mới không thành công");
        }
        return "redirect:/facility";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("facility", facilityService.findById(id));
        model.addAttribute("facilityTypeList", facilityService.facilityTypeList());
        model.addAttribute("rentTypeList", facilityService.rentTypeList());
        return "views/facility/edit";
    }

    @PostMapping("/edit")
    public String editConfirm(Facility facility, RedirectAttributes attributes) {
        facilityService.editFacility(facility);
        attributes.addFlashAttribute("mess", "Sửa thành công");
        return "redirect:/facility";
    }
}
