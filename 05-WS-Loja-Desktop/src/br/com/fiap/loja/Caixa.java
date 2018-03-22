package br.com.fiap.loja;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

import br.com.fiap.loja.repository.LojaRepository;

public class Caixa {

	protected Shell shell;
	private Text txtCodigo;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Caixa window = new Caixa();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(604, 404);
		shell.setText("SWT Application");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(34, 38, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(95, 35, 76, 21);
		
		Label lblErro = new Label(shell, SWT.NONE);
		lblErro.setBounds(34, 287, 454, 15);
		
		Button btnPesquisar = new Button(shell, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				try {
					LojaRepository rep = new LojaRepository();
					int codigo = Integer.parseInt(txtCodigo.getText());
					ProdutoTO produto = rep.buscar(codigo);
					//Limpar a tabela
					table.removeAll();
					
					//Adicionar uma linha na tabela
					
					TableItem linha = new TableItem(table, 0);
					
					String[] valores = {
							String.valueOf(produto.getCodigo()) ,
							produto.getNome(),
							String.valueOf(produto.getQuantidade()),
							String.valueOf(produto.getPreco())};
					
					linha.setText(valores);
					
				}catch(Exception e1) {
					lblErro.setText(e1.getMessage());
				}
			}
		});
		btnPesquisar.setBounds(185, 33, 75, 25);
		btnPesquisar.setText("Pesquisar");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(34, 79, 511, 152);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnCdigo = new TableColumn(table, SWT.NONE);
		tblclmnCdigo.setWidth(100);
		tblclmnCdigo.setText("C\u00F3digo");
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(176);
		tblclmnNome.setText("Nome");
		
		TableColumn tblclmnQuantidade = new TableColumn(table, SWT.NONE);
		tblclmnQuantidade.setWidth(100);
		tblclmnQuantidade.setText("Quantidade");
		
		TableColumn tblclmnPreo = new TableColumn(table, SWT.NONE);
		tblclmnPreo.setWidth(118);
		tblclmnPreo.setText("Pre\u00E7o");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					LojaRepository rep = new LojaRepository();
					List<ProdutoTO> lista = rep.listar();
					
					for (ProdutoTO produto : lista) {
						TableItem linha = new TableItem(table, 0);
						
						String[] valores = {
								String.valueOf(produto.getCodigo()) ,
								produto.getNome(),
								String.valueOf(produto.getQuantidade()),
								String.valueOf(produto.getPreco())};
						
						linha.setText(valores);
					}
				}catch(Exception e2) {
					lblErro.setText(e2.getMessage());
				}
			}
		});
		btnNewButton.setBounds(266, 33, 75, 25);
		btnNewButton.setText("Listar");

	}
}
