package be.odisee.verhuursysteem_sharingbox.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;

import be.odisee.verhuursysteem_sharingbox.domain.Aanvraag;
import be.odisee.verhuursysteem_sharingbox.domain.Klant;
import be.odisee.verhuursysteem_sharingbox.domain.Persoon;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuring;
import be.odisee.verhuursysteem_sharingbox.domain.Verhuurder;
import be.odisee.verhuursysteem_sharingbox.service.SharingboxService;
import be.odisee.verhuursysteem_sharingbox.service.UserContextService;

public class RestControllerProvide {

	
	@Autowired
	protected SharingboxService sharingboxService=null; // ready for dependency injection
	
	@Autowired
	protected UserContextService userContextService=null;

    @RequestMapping("/pickitup.html")
    public String pickitup(){
    	return "pickitup";
    }
    
    // REST GET ... breng de toestand van bestaande resource van de server naar de client (één object)
    	
      @RequestMapping(value={"/verhuurder/verhuring/{id}"},method=RequestMethod.GET)
    	    public @ResponseBody Verhuring getVerhuring(@PathVariable("id") Integer id)
    	  		{
    	    	Verhuring verhuring = sharingboxService.getVerhuringById(id);
    	        return verhuring;
    	  		}	
    	
    
    
   // REST GET ... breng de toestand van bestaande resources van de server naar de client (lijst van objecten)
    
    @RequestMapping(value={"/verhuurder/verhuring"},method=RequestMethod.GET)
    public @ResponseBody List<Verhuring> getVerhuring(){
    	
    	List<Verhuring> verhuringen = sharingboxService.getAllVerhuringen();
    	return verhuringen;
    }
	
    
    // REST POST ... hiermee wordt een resource gecreeerd

    @RequestMapping(value={"/verhuurder/verhuring"},method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Verhuring createVerhuring(@RequestBody Verhuring verhuring, HttpServletResponse response) 
    		throws BindException{
    	
//    	Persoon p = userContextService.getAuthenticatedPersoon();
//		Klant k = (Klant) sharingboxService.getRolById(p.getId());
//		Aanvraag a = sharingboxService.addAanvraag("in behandeling",, adres, k)
//    	
//    	sharingboxService.addAanvraag(status, datum, adres, m_Klant)
//    	sharingboxService.addVerhuring(status, sharingbox_id, tevredenheidsscore, m_aanvraag, m_verhuurder)
//        
    	return verhuring;
    
     }
    }
