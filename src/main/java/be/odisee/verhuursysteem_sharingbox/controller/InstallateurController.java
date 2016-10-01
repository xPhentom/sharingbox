package be.odisee.verhuursysteem_sharingbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import be.odisee.verhuursysteem_sharingbox.converter.AanvraagToVerhuring;
import be.odisee.verhuursysteem_sharingbox.converter.BasicOpdracht;
import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Afbraak;
import be.odisee.verhuursysteem_sharingbox.domain.Installatie;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;
import be.odisee.verhuursysteem_sharingbox.service.SharingboxService;
import be.odisee.verhuursysteem_sharingbox.service.UserContextService;

@Controller
public class InstallateurController {

	@Autowired
	protected SharingboxService sharingboxService = null; // ready for
															// dependency
															// injection

	@Autowired
	protected UserContextService userContextService = null;

	@RequestMapping(value = { "/installateur/index.html", "/installateur/home.html",
			"/installateur/lijst.html" }, method = RequestMethod.GET)
	public String index(ModelMap model) {

		Installatie deinstallatie = new Installatie();
		model.addAttribute("deinstallatie", deinstallatie);
		Afbraak deafbraak = new Afbraak();
		model.addAttribute("deafbraak", deafbraak);

		List<Afbraak> delijstvanAfbraken = sharingboxService.getAllAfbraken();
		model.addAttribute("afbraken", delijstvanAfbraken);
		List<Installatie> delijstvanInstallaties = sharingboxService.getAllInstallaties();
		model.addAttribute("installaties", delijstvanInstallaties);

		return "/installateur/index";
	}
	//
	// @RequestMapping(value = { "/installateur/index.html",
	// "/installateur/home.html",
	// "/installateur/lijst.html" }, method = RequestMethod.POST)
	// public String wijzigenStatusOpdracht(@ModelAttribute("basicOpdracht")
	// BasicOpdracht basicOpdracht, ModelMap model) {
	//
	// Persoon p = userContextService.getAuthenticatedPersoon();
	//
	// return "redirect:/installateur/index.html?id="+p.getId();
	// }

	@RequestMapping(value = { "/installateur/installatie.html" }, method = RequestMethod.POST)
	public String wijzigenStatusInstallatie(@ModelAttribute("deinstallatie") Installatie installatie, ModelMap model) {

		Persoon p = userContextService.getAuthenticatedPersoon();
		
		installatie = sharingboxService.getInstallatieById(installatie.getId());
		installatie.setStatus("afgerond");
		sharingboxService.updateInstallatie(installatie);
		return "redirect:/installateur/index.html?id=" + p.getId();
	}

	@RequestMapping(value = { "/installateur/afbraak.html" }, method = RequestMethod.POST)
	public String wijzigenStatusAfbraak(@ModelAttribute("deafbraak") Afbraak afbraak, ModelMap model) {

		Persoon p = userContextService.getAuthenticatedPersoon();
		afbraak = sharingboxService.getAfbraakById(afbraak.getId());
		afbraak.setStatus("afgerond");
		sharingboxService.updateAfbraak(afbraak);
		return "redirect:/installateur/index.html?id=" + p.getId();
	}
}