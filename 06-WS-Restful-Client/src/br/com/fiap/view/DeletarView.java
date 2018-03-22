package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.CandidatoRepository;

public class DeletarView {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Código: ");
		int codigo = scan.nextInt();
		
		CandidatoRepository repository = new CandidatoRepository();
		
		try
		{
			repository.deletar(codigo);
			System.out.println("Deletado!");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		
		scan.close();
	}

}
