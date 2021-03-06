package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.CandidatoRepository;
import br.com.fiap.to.CandidatoTO;

public class CadastrarView 
{
	public static void main(String[] args) 
	{	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nome: ");
		String nome = sc.next() + sc.nextLine();
		System.out.println("Apelido: ");
		String apelido = sc.next() + sc.nextLine();
		System.out.println("N�mero: ");
		int numero = sc.nextInt();
		System.out.println("Ficha limpa: ");
		boolean fichaLimpa = sc.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(nome, apelido, fichaLimpa, numero);
		
		
		CandidatoRepository repository = new CandidatoRepository();
		try
		{
			repository.cadastrar(to);
			System.out.println("Candidato cadastrado com sucesso!");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
