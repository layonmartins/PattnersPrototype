/*
 * Classe Client para testes
 * ela ira gerar um evento
 * e depois fazer outros clones deste mesmo evento.
 */
package Client;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import ConcretePrototype.Evento;

//classe Client
public class TestaPrototype {

	public static void main(String[] args) {

		// ######### CRIANDO UM EVENTO #########################
		Calendar vencimento = Calendar.getInstance();
		vencimento.add(Calendar.DATE, 30);
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("Concurso");
		hashSet.add("Software");
		hashSet.add("Prêmios");
		
		Evento evento = new Evento("CONCURSO DE SOFTWARE", vencimento, hashSet);
		System.out.println(evento);

		/*
		 * Para criar um novo evento faço um clone do evento antigo passo
		 * algumas novas informações e exibo ele para os usuarios
		 */

		// ######### CRIANDO UM NOVO EVENTO #########################
		Evento clone = evento.clone();
		clone.setNome("MARATONA DE PROGRAMAÇÃO");
		vencimento.add(Calendar.DATE, 40);
		clone.setVencimento(vencimento);
		hashSet = new HashSet<String>();
		hashSet.add("Competição");
		hashSet.add("Software");
		hashSet.add("Prêmios");
		clone.setPalavrasChave(hashSet);
		System.out.println(clone);

		// ######### CRIANDO UMA NOVO EVENTO #########################
		Evento clone2 = evento.clone();
		clone2.setNome("SEMANA ACADÊMICA DE TI");
		vencimento.add(Calendar.DATE, 20);
		clone2.setVencimento(vencimento);
		hashSet = new HashSet<String>();
		hashSet.add("Palestras");
		hashSet.add("Minicursos");
		hashSet.add("Workshops");
		clone2.setPalavrasChave(hashSet);
		System.out.println(clone2);

		// ######### CRIANDO UMA NOVO EVENTO, SEM INFORMAÇÕES NOVAS
		// #########################
		System.out.println("\n\n NOVO EVENTO SEM NOVAS INFORMAÇÕES");
		Evento clone3 = clone2.clone();
		System.out.println(clone3);
		
		
	}

}
