package no.hvl.dat108.js.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import no.hvl.dat108.js.model.Deltager;

@RestController
@RequestMapping("/api/deltagere")
public class DeltagerController {

	private List<Deltager> deltagere = new ArrayList<>();

	@PostMapping("/registrer")
	public Deltager registrerDeltager(@RequestBody Deltager deltager) {
		deltagere.add(deltager);
		return deltager;
	}

	@GetMapping("/vis")
	public List<Deltager> visDeltagere(@RequestParam(required = false) String fra,
			@RequestParam(required = false) String til) {
		List<Deltager> filtrerte = deltagere;

		if (fra != null && til != null) {
			filtrerte = deltagere.stream()
					.filter(d -> d.getSluttid().compareTo(fra) >= 0 && d.getSluttid().compareTo(til) <= 0).toList();
		}

		filtrerte.sort(Comparator.comparing(Deltager::getSluttid));
		return filtrerte;
	}

}
