package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.CandidatoRepository;
import br.com.fiap.to.CandidatoTO;

public class AtualizarView 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Código: ");
		int codigo = scan.nextInt();
		System.out.println("Nome: ");
		String nome = scan.next() + scan.nextLine();
		System.out.println("Apelido: ");
		String apelido = scan.next() + scan.nextLine();
		System.out.println("Número: ");
		int numero = scan.nextInt();
		System.out.println("Ficha limpa: ");
		boolean ficha = scan.nextBoolean();
		
		CandidatoTO to = new CandidatoTO(codigo, nome, apelido, ficha, numero);
		
		CandidatoRepository repository = new CandidatoRepository();
		
		try
		{
			repository.atualizar(to);
			System.out.println("Atualizado com sucesso!");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		scan.close();
	}
}
