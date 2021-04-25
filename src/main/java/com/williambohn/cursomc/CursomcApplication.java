package com.williambohn.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import com.williambohn.cursomc.domain.Categoria;
import com.williambohn.cursomc.domain.Cidade;
import com.williambohn.cursomc.domain.Cliente;
import com.williambohn.cursomc.domain.Endereco;
import com.williambohn.cursomc.domain.Estado;
import com.williambohn.cursomc.domain.ItemPedido;
import com.williambohn.cursomc.domain.Pagamento;
import com.williambohn.cursomc.domain.PagamentoComBoleto;
import com.williambohn.cursomc.domain.PagamentoComCartao;
import com.williambohn.cursomc.domain.Pedido;
import com.williambohn.cursomc.domain.Produto;
import com.williambohn.cursomc.domain.enums.EstadoPagamento;
import com.williambohn.cursomc.domain.enums.TipoCliente;
import com.williambohn.cursomc.repository.CategoriaRepository;
import com.williambohn.cursomc.repository.CidadeRepository;
import com.williambohn.cursomc.repository.ClienteRepository;
import com.williambohn.cursomc.repository.EnderecoRepository;
import com.williambohn.cursomc.repository.EstadoRepository;
import com.williambohn.cursomc.repository.ItemPedidoRepository;
import com.williambohn.cursomc.repository.PagamentoRepository;
import com.williambohn.cursomc.repository.PedidoRepository;
import com.williambohn.cursomc.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
 
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório" );
		
		Produto p1 =  new Produto(null, "Computador", 200.00);
		Produto p2 =  new Produto(null, "Impressora", 800.00);
		Produto p3 =  new Produto(null, "Mouse", 80.0);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	//==============================================================	
    //==============================================================
		Estado e1 = new Estado(null,"Minas Gerais");
		Estado e2 = new Estado(null,"São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(e1,e2));
			cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
	//==============================================================	
	//==============================================================
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "644.411.560-49", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("0000-0000"));
		Cliente cli2 = new Cliente(null, "Carlos Breu", "carlod@gmail.com", "55.577.094/0001-58", TipoCliente.PESSOAJURIDICA);
		cli2.getTelefones().addAll(Arrays.asList("1111-1111"));

		Endereco end1 = new Endereco(null,"Rua Flores", "300", "Apto 303", "Jardim"	, "3237283723", cli1, c1);
		Endereco end2 = new Endereco(null,"Rua enaide", "320", "Casa", "Floresta"	, "YEG6AE23", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
	//==============================================================
	//==============================================================	
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Pedido ped1 = new Pedido(null, simpleDateFormat.parse("21/04/2021 20:38"), cli1, end1);
		Pedido ped2 = new Pedido(null, simpleDateFormat.parse("21/04/2021 20:38"), cli1, end2);

		Pagamento pagamento1 = new PagamentoComCartao(null, 6, EstadoPagamento.QUITADO, ped1);
		ped1.setPagamento(pagamento1);

		Pagamento pagamento2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,ped2, simpleDateFormat.parse("20/10/2020 00:00"), null);
		ped2.setPagamento(pagamento2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagamento1,pagamento2));

	//==============================================================	
	//==============================================================

		ItemPedido ip1 =  new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 =  new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 =  new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));

	}
}
