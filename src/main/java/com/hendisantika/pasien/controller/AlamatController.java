/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.controller;

import com.hendisantika.pasien.domain.Alamat;
import com.hendisantika.pasien.service.AlamatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author hendi.santika
 */
@Controller
@ComponentScan
public class AlamatController {
    @Autowired
    private AlamatService alamatService;
    
    @RequestMapping(value = {"/alamat", "/savealamat"}, method = RequestMethod.GET)
    public String savePage(Model model){
        model.addAttribute("alamat", new Alamat());
        model.addAttribute("allAlamats", alamatService.getAllAlamats());
        return "alamat";
    }
    
    @RequestMapping(value = {"/alamat/save"}, method = RequestMethod.POST)
    public String saveAlamat(@ModelAttribute("alamat") Alamat alamat,
            final RedirectAttributes redirectAttributes) {

        if (alamatService.saveAlamat(alamat) != null) {
            redirectAttributes.addFlashAttribute("saveAlamat", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveAlamat", "unsuccess");
        }

        return "redirect:/savealamat";
    }
    
    @RequestMapping(value = "/alamat/{operation}/{Id}", method = RequestMethod.GET)
    public String editRemoveAlamat(@PathVariable("operation") String operation,
            @PathVariable("Id") Integer Id, final RedirectAttributes redirectAttributes,
            Model model) {
        if (operation.equals("delete")) {
            if (alamatService.deleteAlamat(Id)) {
                redirectAttributes.addFlashAttribute("deletion", "success");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "unsuccess");
            }
        } else if (operation.equals("edit")) {
            Alamat editAlamat = alamatService.findAlamat(Id);
            if (editAlamat != null) {
                model.addAttribute("editAlamat", editAlamat);
                return "editAlamat";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }

        return "redirect:/savealamat";
    }

    @RequestMapping(value = "/alamat/update", method = RequestMethod.POST)
    public String updateAlamat(@ModelAttribute("editAlamat") Alamat editAlamat,
            final RedirectAttributes redirectAttributes) {
        if (alamatService.editAlamat(editAlamat) != null) {
            redirectAttributes.addFlashAttribute("edit", "success");
        } else {
            redirectAttributes.addFlashAttribute("edit", "unsuccess");
        }
        return "redirect:/savealamat";
    }

}
