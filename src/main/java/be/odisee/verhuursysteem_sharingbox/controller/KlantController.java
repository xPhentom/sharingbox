package be.odisee.verhuursysteem_sharingbox.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import be.odisee.verhuursysteem_sharingbox.domain.Rol;
import be.odisee.verhuursysteem_sharingbox.service.SharingboxService;
import be.odisee.verhuursysteem_sharingbox.service.UserContextService;
import be.odisee.verhuursysteem_sharingbox.service.UserContextServiceImpl;

@Controller
public class KlantController {

	@Autowired
	protected SharingboxService sharingboxService = null; // ready for
															// dependency
															// injection

	@Autowired
	protected UserContextService userContextService = null;

	@RequestMapping(value = { "/klant/index.html", "/klant/home.html" }, method = RequestMethod.GET)
	public String aanvraagFormulier(ModelMap model) {
		Aanvraag aanvraag = new Aanvraag();
		model.addAttribute("deaanvraag", aanvraag);
		return "/klant/nieuweAanvraag";
	}
	
    @RequestMapping(value={"/klant/aanvraag.html"},method=RequestMethod.GET)
    public String aanvraagDetail(@RequestParam("id") Integer id, ModelMap model){
        Aanvraag aanvraag = sharingboxService.getAanvraagById(id);
        model.addAttribute("deaanvraag", aanvraag);
        return "/klant/aanvraag";
    }

	@RequestMapping(value = { "/klant/index.html", "/klant/home.html" }, method = RequestMethod.POST)
	public String aanvraagToevoegen(@ModelAttribute("deaanvraag") @Valid Aanvraag aanvraag, BindingResult result,
			ModelMap model) {

		if (result.hasErrors())
			return "/klant/nieuweAanvraag"; // fouten op de form => form opnieuw
											// tonen

		// Get persoon details
		Persoon persoon = null;
		persoon = userContextService.getAuthenticatedPersoon();

		// Get rol details
		Rol rol = null;
		rol = sharingboxService.getRolByPersoonId(persoon.getId());

		// Create a Klant object
		Klant klant = new Klant(rol.getId(), "actief", rol.getUsernaam(), persoon);
		Aanvraag toegevoegdAanvraag = sharingboxService.addAanvraag("in behandeling", aanvraag.getDatum(), aanvraag.getAdres(),
				klant);

		return "redirect:/klant/aanvraag.html?id=" + toegevoegdAanvraag.getId();
	}
	// je zal naar de detailpagina van de toegevoegde persoon gaan

}
