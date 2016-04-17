/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hendisantika.pasien.controller;

import com.hendisantika.pasien.domain.Pasien;
import com.hendisantika.pasien.service.PasienService;
import java.util.ArrayList;
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
public class PasienController {
    @Autowired
	PasienService pasienService;
	
	@RequestMapping(value = {"/","/savepage"}, method = RequestMethod.GET)
	public String savePage(Model model) {
		model.addAttribute("pasien", new Pasien());
		model.addAttribute("allPasiens", (ArrayList<Pasien>)pasienService.getAllPasiens());
		return "index";
	}
	
	@RequestMapping(value = {"/pasien/save"}, method = RequestMethod.POST)
	public String savePasien(@ModelAttribute("pasien") Pasien pasien,
			final RedirectAttributes redirectAttributes) {
		
		if(pasienService.savePasien(pasien)!=null) {
			redirectAttributes.addFlashAttribute("savePasien", "success");
		} else {
			redirectAttributes.addFlashAttribute("savePasien", "unsuccess");
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/pasien/{operation}/{pasienNo}", method = RequestMethod.GET)
	public String editRemovePasien(@PathVariable("operation") String operation,
			@PathVariable("pasienNo") String pasienId, final RedirectAttributes redirectAttributes,
			Model model) {
		if(operation.equals("delete")) {
			if(pasienService.deletePasien(pasienId)) {
				redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if(operation.equals("edit")){
		  Pasien editPasien = pasienService.findPasien(pasienId);
		  if(editPasien!=null) {
		       model.addAttribute("editPasien", editPasien);
		       return "editPage";
		  } else {
			  redirectAttributes.addFlashAttribute("status","notfound");
		  }
		}
		
		return "redirect:/savepage";
	}
	
	@RequestMapping(value = "/pasien/update", method = RequestMethod.POST)
	public String updatePasien(@ModelAttribute("editPasien") Pasien editPasien,
			final RedirectAttributes redirectAttributes) {
		if(pasienService.editPasien(editPasien)!=null) {
			redirectAttributes.addFlashAttribute("edit", "success");
		} else {
			redirectAttributes.addFlashAttribute("edit", "unsuccess");
		}
		return "redirect:/savepage";
	}
}
