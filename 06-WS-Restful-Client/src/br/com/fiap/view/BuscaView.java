package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.CandidatoRepository;
import br.com.fiap.to.CandidatoTO;

public class BuscaView 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Código: ");
		int codigo = scan.nextInt();
		
		CandidatoRepository service = new CandidatoRepository();
		
		try
		{
			// Pesquisa o candidato do webservice
			CandidatoTO to = service.buscar(codigo);
			System.out.println("Nome: " + to.getNome());
			System.out.println("Apelido: " + to.getApelido());
			System.out.println("Número: " + to.getNumero());
			System.out.println("Ficha limpa: " + to.isFichaLimpa());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		scan.close();
	}

}
