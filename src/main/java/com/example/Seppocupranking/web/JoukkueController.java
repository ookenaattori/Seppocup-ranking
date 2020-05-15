package com.example.Seppocupranking.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Seppocupranking.domain.Joukkue;
import com.example.Seppocupranking.domain.JoukkueRepository;
import com.example.Seppocupranking.domain.Ottelu;
import com.example.Seppocupranking.domain.OtteluRepository;
import com.example.Seppocupranking.domain.Valmentaja;
import com.example.Seppocupranking.domain.ValmentajaRepository;

@Controller
public class JoukkueController {

	@Autowired
	private JoukkueRepository repository;

	@Autowired
	private ValmentajaRepository vrepository;

	@Autowired
	private OtteluRepository orepository;
	
	

	// Näytä kaikki joukkueet pisteiden mukaan
	@RequestMapping("/ranking")
	public String joukkueList(Model model) {
		model.addAttribute("joukkueet", repository.findByOrderByPisteetDesc());

		return "ranking";

	}

	// Login endpoint
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Ottelut välilehti / endpoint
	@RequestMapping("/ottelut")
	public String otteluList(Model model) {
		model.addAttribute("joukkueet", repository.findAll());
		model.addAttribute("ottelut", orepository.findAll());

		return "ottelut";

	}

	// Lisää uusi joukkue
	@RequestMapping(value = "/add")
	public String addJoukkue(Model model) {
		model.addAttribute("joukkue", new Joukkue());
		model.addAttribute("valmentajat", vrepository.findAll());

		return "lisaajoukkue";
	}

	// Muokkaa joukkuetta
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editRank(@PathVariable("id") Long joukkueId, Model model) {
		model.addAttribute("joukkue", repository.findById(joukkueId));
		model.addAttribute("valmentajat", vrepository.findAll());

		return "editranking";
	}

	// Tallenna joukkue / muutos
	@RequestMapping(value = "/savejoukkue", method = RequestMethod.POST)
	public String save1(Joukkue joukkue) {
		repository.save(joukkue);

		return "redirect:ranking";
	}

	// Poista joukkue
	@RequestMapping(value = "/deletejoukkue/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteJoukkue(@PathVariable("id") Long joukkueId, Model model) {
		repository.deleteById(joukkueId);

		return "redirect:../ranking";
	}

	// Muokkaa ottelua
	@RequestMapping(value = "/editottelu/{id}", method = RequestMethod.GET)
	public String editOttelu(@PathVariable("id") Long otteluId, Model model) {
		model.addAttribute("ottelu", orepository.findById(otteluId));

		return "editottelu";
	}

	// Lisää uusi ottelu
	@RequestMapping(value = "/lisaaottelu")
	public String addOttelu(Model model) {
		model.addAttribute("ottelu", new Ottelu());

		return "lisaaottelu";
	}

	// Tallenna joukkue / muutos
	@RequestMapping(value = "/saveottelu", method = RequestMethod.POST)
	public String save2(Ottelu ottelu) {
		orepository.save(ottelu);

		return "redirect:ottelut";
	}

	// Poista ottelu
	@RequestMapping(value = "/deleteottelu/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteOttelu(@PathVariable("id") Long otteluId, Model model) {
		orepository.deleteById(otteluId);

		return "redirect:../ottelut";
	}

	// RESTful service jolla haetaan kaikki joukkueet
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/joukkueet", method = RequestMethod.GET)
	public @ResponseBody List<Joukkue> joukkueListRest() {
		return (List<Joukkue>) repository.findAll();
	}

	// RESTful service jolla haetaan joukkue id:n perusteella
	@RequestMapping(value = "/joukkue/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Joukkue> findStudentRest(@PathVariable("id") Long joukkueId) {
		return repository.findById(joukkueId);
	}
	// RESTful service jolla haetaan kaikki ottelut
		@RequestMapping(value = "/ottelutapi", method = RequestMethod.GET)
		public @ResponseBody List<Ottelu> otteluListRest() {
			return (List<Ottelu>) orepository.findAll();
		}
}