package be.odisee.verhuursysteem_sharingbox.controller;

import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import be.odisee.verhuursysteem_sharingbox.domain.Rol;
import be.odisee.verhuursysteem_sharingbox.domain.Sharingbox;
import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuurder;
import be.odisee.verhuursysteem_sharingbox.service.*;
import be.odisee.verhuursysteem_sharingbox.testJSON.JsonResponse;
import be.odisee.verhuursysteem_sharingbox.testJSON.Person;
import be.odisee.verhuursysteem_sharingbox.converter.AanvraagToVerhuring;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class VerhuurController {

	@Autowired
	protected SharingboxService sharingboxService = null; // ready for
															// dependency
															// injection
	@Autowired
	protected UserContextService userContextService = null;

	@RequestMapping(value = { "/verhuurder/home.html", "/verhuurder/index.html",
			"/verhuurder/lijst.html" }, method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<Verhuring> lijstVanVerhuring = sharingboxService.getAllVerhuringen();
		model.addAttribute("verhuringen", lijstVanVerhuring);
		return "/verhuurder/index";
	}

	@RequestMapping(value = { "/verhuurder/verhuring.html" }, method = RequestMethod.GET)
	public String verhuringDetail(@RequestParam("id") Integer id, ModelMap model) {

		Verhuring verhuring = sharingboxService.getVerhuringById(id);
		model.addAttribute("verhuring", verhuring);
		return "/verhuurder/verhuring";
	}

	@RequestMapping(value = { "/verhuurder/updateVerhuring.html" }, method = RequestMethod.GET)
	public String verhuringUpdatenFormulier(@RequestParam("id") Integer id, ModelMap model) {
		Verhuring verhuring = sharingboxService.getVerhuringById(id);
		model.addAttribute("verhuring", verhuring);
		System.out.println("de id is nu :" + verhuring.getId());
		return "/verhuurder/updateVerhuring";
	}

	@RequestMapping(value = { "/verhuurder/updateVerhuring.html" }, method = RequestMethod.POST)
	public String verhuringUpdaten(@ModelAttribute("verhuring") Verhuring verhuring, ModelMap model) {

		Verhuring updateVerhuring = sharingboxService.updateVerhuring(verhuring);
		System.out.println("DEBUG de verhuring voor  : " + verhuring.getM_aanvraag().getDatum() + " is geupdate en id :"
				+ verhuring.getId());
		return "redirect:/verhuurder/verhuring.html?id=" + updateVerhuring.getId();
	}

	@RequestMapping(value = { "/verhuurder/nieuweVerhuring.html" }, method = RequestMethod.GET)
	public String verhuringFormulier(ModelMap model) {

		AanvraagToVerhuring aanvraagToVerhuring = new AanvraagToVerhuring();
		model.addAttribute("aanvraagToVerhuring", aanvraagToVerhuring);

		ArrayList<Aanvraag> deLijstVanAanvragen = sharingboxService.getAllAanvragenAndKlantName();
		model.addAttribute("aanvragen", deLijstVanAanvragen);

		List<Sharingbox> deLijstVanSharingboxen = sharingboxService.getAllAvailableSharingboxen();
		model.addAttribute("sharingboxen", deLijstVanSharingboxen);

		return "/verhuurder/nieuweVerhuring";
	}

	@RequestMapping(value = { "/verhuurder/nieuweVerhuring.html" }, method = RequestMethod.POST)
	public String verhuringToevoegen(@ModelAttribute("aanvraagToVerhuring") AanvraagToVerhuring aanvraagToVerhuring,
			ModelMap model) {
		{
			Persoon p = userContextService.getAuthenticatedPersoon();
			Verhuurder v = (Verhuurder) sharingboxService.getRolByPersoonId(p.getId());
			Aanvraag a = sharingboxService.getAanvraagById(aanvraagToVerhuring.getAanvraag_id());

			// Send verhuring to DB
			sharingboxService.addVerhuring("actief", aanvraagToVerhuring.getSharingbox_id(), "empty", a, v);
			// Set status van aanvraag op processed
			a.setStatus("in verhuring");
			sharingboxService.updateAanvraag(a);

			return "redirect:/verhuurder/index.html?rolid=" + v.getId();
		}
	}

	@RequestMapping(value = { "/verhuurder/deleteAanvraag.html" }, method = RequestMethod.GET)
	public String aanvraagWeigerenFormulier(ModelMap model) {

		Aanvraag deaanvraag = new Aanvraag();
		model.addAttribute("deaanvraag", deaanvraag);
		ArrayList<Aanvraag> deLijstVanAanvragen = sharingboxService.getAllAanvragenAndKlantName();
		model.addAttribute("aanvragen", deLijstVanAanvragen);

		return "/verhuurder/deleteAanvraag";
	}

	@RequestMapping(value = { "/verhuurder/deleteAanvraag.html" }, method = RequestMethod.POST)
	public String aanvraagWeigeren(@ModelAttribute("deaanvraag") Aanvraag deaanvraag, BindingResult result, ModelMap model) {
		{
			// Delete de aanvraag uit DB
			sharingboxService.deleteAanvraag(deaanvraag);
			Persoon p = userContextService.getAuthenticatedPersoon();
			Verhuurder v = (Verhuurder) sharingboxService.getRolByPersoonId(p.getId());
			return "redirect:/verhuurder/index.html?rolid=" + v.getId();
		}
	}
}
