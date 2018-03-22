package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.CandidatoRepository;
import br.com.fiap.to.CandidatoTO;

public class ListarView 
{
	public static void main(String[] args) 
	{
		CandidatoRepository service = new CandidatoRepository();
		
		try
		{
			// Pesquisa o candidato do webservice
			List<CandidatoTO> to = service.listar();
			
			for(CandidatoTO t: to)
			{
				System.out.println(t.getApelido());
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

}
