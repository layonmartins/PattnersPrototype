package ConcretePrototype;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import Prototype.Prototype;

/*
 * Class Campanha que implementa a interface Prototype, 
 * possibilitando que seja criadas posteriomente varias
 * outras campanhas.
 * 
 * Vamos supor que a UEMG tenha um departamento de Computação
 * cujo e responsavel por realizar varias Eventos 
 * ao longo do curso.
 * 
 * Estes eventos são identicos, pois e liberado da diretoria
 * uma verba, um local e outras coisas que são iguais 
 * a para todos os eventos.
 * 
 * Sendo assim, e mais viavel a utilização do padrão Prototype
 * para criar um novo evento apartir de um evento já existente.
 * Alterando apenas algumas informações basicas.
 * 
 * Esta classe por definir um modelo de evento geral.
 * 
 * 
 */
public class Evento implements Prototype<Evento> {
	private String nome;
	private Calendar vencimento;
	private Set<String> palavrasChave;
	private double verba = 50000;
	private int taxaInscricao = 15;
	private String enderecoInscricao = "http://wwww.eventosUEMG.com.br";

	// Construtor do evento com as informações basicas
	public Evento(String nome, Calendar vencimento, Set<String> palavrasChave) {
		this.nome = nome;
		this.vencimento = vencimento;
		this.palavrasChave = palavrasChave;
	}

	// getters e setters ********************
	public  String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public Set<String> getPalavrasChave() {
		return palavrasChave;
	}

	public void setPalavrasChave(Set<String> palavrasChave) {
		this.palavrasChave = palavrasChave;
	}

	// metodo para clonar um evento
	public Evento clone() {
		String nome = "Cópia do evento: " + this.nome;
		Calendar vencimento = (Calendar) this.vencimento.clone();
		Set<String> palavrasChave = new HashSet<String>(this.palavrasChave);
		Evento evento = new Evento(nome, vencimento, palavrasChave);

		return evento;
	}

	// Sobrescrita do metodo toString padrão dos objetos java.
	// Mostrar na tela as informações do evento
	public String toString() {

		StringBuffer buffer = new StringBuffer();
		buffer.append("\n\n##################################################\n");
		buffer.append("##############    #    EVENTO   #     ############\n");
		buffer.append("##################################################");
		buffer.append("\n");
		buffer.append("Nome: ");
		buffer.append(this.nome);
		buffer.append("\n");

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String format = simpleDateFormat.format(this.vencimento.getTime());
		buffer.append("Vencimento: " + format);
		buffer.append("\n");

		buffer.append("Palavras-chave: \n");
		for (String palavraChave : this.palavrasChave) {
			buffer.append(". " + palavraChave.toUpperCase());
			buffer.append("\n");
		}
		buffer.append("Mais informações no site: \n");
		buffer.append(enderecoInscricao);
		buffer.append("\nTaxa de inscrição: " + taxaInscricao);
		buffer.append("\n------------- // -------------------");
		buffer.append("\n");

		return buffer.toString();

	}

}
