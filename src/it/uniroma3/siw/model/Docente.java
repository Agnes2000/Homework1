package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	private String cognome;
	private LocalDate dataDiNascita;
	private String luogoDiNascita;
	private String partitaIva;
	
	/*
	 * se inserisco un docente, inserisco anche il corso che insegna
	 * se elimino un docente, elimino anche il corso assumendo che un corso non possa cambiare docente
	 */

	@OneToMany(mappedBy = "corso", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List <Corso> corso;
	
	public Docente() {
		
	}
}
