package no.hvl.dat108.js.model;

public class Deltager {

	private int startnummer;
	private String navn;
	private String sluttid;

	public Deltager(int startnummer, String navn, String sluttid) {
		this.setStartnummer(startnummer);
		this.setNavn(navn);
		this.setSluttid(sluttid);

	}

	public int getStartnummer() {
		return startnummer;
	}

	public void setStartnummer(int startnummer) {
		this.startnummer = startnummer;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getSluttid() {
		return sluttid;
	}

	public void setSluttid(String sluttid) {
		this.sluttid = sluttid;
	}

}
