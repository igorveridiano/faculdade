package GerenciadorShow;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Scanner leia;
	private static Date datashow;
	private static Gravadora lista2;
	private static Main lista1;
	private static Main lista3;
	private static Show lista4;
	private ArrayList<EmpresaEventos> ListaEmpresa;
	private ArrayList<Gravadora> ListaGravadora;
	private static Main verificador;
	
	public Main(){
		new ArrayList<Gravadora>();
		new ArrayList<EmpresaEventos>();
	}
	
	public  boolean AdicionarGravadora(String gravadoraAdicionar){
		boolean GravadoraValida = false;
		Gravadora gravadora = null;
		for (Gravadora gravadoraadicionada: this.ListaGravadora){
			if (gravadoraadicionada.getNome() == gravadoraAdicionar){
				GravadoraValida = true;
				gravadora = gravadoraadicionada;
			}
		}
		if (GravadoraValida){
			System.out.println("Gravadora adicionada");
			this.ListaGravadora.add(gravadora);
			return true;
		}else {
			System.out.println("A gravadora não pode ser adicionada");
			return false;
		}
	}
	
	public boolean AdicionarEmpresa(String empresa, int cnpj){
		boolean EmpresaValida = false;
		EmpresaEventos empresaadicionar = null;
		for (EmpresaEventos empresaeventos : this.ListaEmpresa){
			if ((empresaeventos.getCnpj() == cnpj) && (empresaeventos.getNome() == empresa)){
				EmpresaValida = true;
				empresaadicionar = empresaeventos;
			}
		}
		if (EmpresaValida){
			System.out.println("Empresa criada");
			this.ListaEmpresa.add(empresaadicionar);
			return true;
		}else {
			System.out.println("Empresa não pode ser criada");
			return false;
		}
	}
	
	public static int GerarCodigo(){
		int codigo = 0;
		int x = 1;
		int numero;
		Random sorteio = new Random();
		for (int i = 1; i <= 8; i++){
			 numero = sorteio.nextInt(9) + 1;
			 codigo += (numero * x);
			 x *= 10;
		}
		return codigo;
	}
	
	public ArrayList<Gravadora> getListaGravadora() {
		return ListaGravadora;
	}

	public ArrayList<EmpresaEventos> getListaEmpresa() {
		return ListaEmpresa;
	}
	
	public static void main(String[] args) throws ParseException {
		leia = new Scanner(System.in);
		String Verificador1, Verificador2, Verificador3 = null, NomeGravadora, SedeGravadora, NomeEmpresa, DataShow;
		String ArtistaShow, ArtistaNome, NacionalidadeArtista, GeneroTitulo, DescricaoTitulo, ArtistaTitulo;
		String EmpresaShow, GravadoraArtista, CidadeShow, GravadoraAdicionar, EmpresaAdicionar;
		double ValorShowArtista;
		int QuantidadeArtistas, CNPJempresa, qtdMaxShow, CodigoShow, CodigoArtista, AnoLancamentoTitulo;
		int CodigoTitulo, AnoTitulo, CNPJEmpresa;
		lista1 = null;
		lista2 = null;
		lista3 = null;
		Cidade cidadeshow = null;
		Artista artistashow = null;
		Artista artistanome = null;
		verificador = null;
		do {
		System.out.print("Deseja criar gravadora, adicionar gravadora, criar empresa de eventos, adicionar empresa de eventos, "
		+ "\ncontratar show, contratar artista, demitir artista, vender show, lançar titulo, excluir titulo, "
		+ "\nbuscar titulo, ver a quantdade de um titulo, ver o artista que mais realizou show ou deseja sair: ");
		Verificador1 = leia.nextLine();
		switch (Verificador1){
		case "criar gravadora" :
			System.out.print("Nome da gravadora: ");
			NomeGravadora = leia.nextLine();
			System.out.print("Sede da gravadora: ");
			SedeGravadora = leia.nextLine();
			System.out.print("Quantidade de artita que a gravadora podera ter: ");
			QuantidadeArtistas = leia.nextInt();
			Gravadora gravadora = new Gravadora(NomeGravadora, SedeGravadora, QuantidadeArtistas);
			break;
		case "adicionar gravadora" :
			System.out.print("Nome da gravadora: ");
			GravadoraAdicionar = leia.nextLine();
			verificador.AdicionarGravadora(GravadoraAdicionar);
			break;
		case "criar empresa de eventos" :
			System.out.print("Nome da empresa: ");
			NomeEmpresa = leia.nextLine();
			System.out.print("CNPJ da empresa (apenas numeros): ");
			CNPJempresa = leia.nextInt();
			System.out.println("Quantidade maxima de shows que empresa realiza: ");
			qtdMaxShow = leia.nextInt();
			EmpresaEventos empresa = new EmpresaEventos(NomeEmpresa, CNPJempresa, qtdMaxShow);
			break;
		case "adicionar empresa eventos" :
			System.out.print("Nome da empresa: ");
			EmpresaAdicionar = leia.nextLine();
			System.out.print("CNPJ da empresa: ");
			CNPJEmpresa = leia.nextInt();
			verificador.AdicionarEmpresa(EmpresaAdicionar, CNPJEmpresa);
			break;	
		case "contratar show" :
			System.out.print("Codigo do show: ");
			CodigoShow = leia.nextInt();
			System.out.print("Data do show: ");
			DataShow = leia.nextLine();
			DateFormat data=DateFormat.getInstance();
			try {
                datashow = data.parse(DataShow);
            } catch (ParseException ex) {
                ex.printStackTrace();    
            }
			System.out.print("Artista do show: ");
			ArtistaShow = leia.nextLine();
			for (Artista artista : lista2.getListaArtista()){
				if (artista.getNome() == ArtistaShow){
					artistashow = artista;
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			System.out.print("Cidade do show: ");
			CidadeShow = leia.nextLine();
			for (Cidade cidade : lista4.getListaCidade()){
				if (cidade.getNome() == CidadeShow){
					cidadeshow = cidade;
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			Show show = new Show(CodigoShow, datashow, artistashow, cidadeshow);
			System.out.print("Contratar show para qual empresa de eventos: ");
			EmpresaShow = leia.nextLine();
			for (EmpresaEventos empresaeventos : lista1.getListaEmpresa()){
				if (empresaeventos.getNome() == EmpresaShow){
					empresaeventos.ContratarShow(show);
				} else {
					System.out.println("Empresa não encontrado");
				}
			}   
			break;
		case "contratar artista" :
			System.out.print("Nome do artista: ");
			ArtistaNome = leia.nextLine();
			System.out.print("Valor do show do artista: ");
			ValorShowArtista = leia.nextDouble();
			System.out.print("Nacionalidade do artista: ");
			NacionalidadeArtista = leia.nextLine();
			Artista artista = new Artista(ArtistaNome, ValorShowArtista, NacionalidadeArtista);
			System.out.print("Contratar artista para qual gravadora: ");
			GravadoraArtista = leia.nextLine();
			for (Gravadora gravadoraartista : lista3.getListaGravadora()){
				if (gravadoraartista.getNome() == GravadoraArtista){
					gravadoraartista.ContratarArtista(artista);
				} else {
					System.out.print("Gravadora não encontrado");
				}
			}
			break;
		case "demitir artista" :
			System.out.print("Codigo do artista: ");
			CodigoArtista = leia.nextInt();
			System.out.print("demitir artista de qual gravadora: ");
			GravadoraArtista = leia.nextLine();
			for (Gravadora gravadoraartista : lista3.getListaGravadora()){
				if (gravadoraartista.getNome() == GravadoraArtista){
					gravadoraartista.DemitirArtista(CodigoArtista);
				} else {
					System.out.print("Gravadora não encontrado");
				}
			}
			break;
		case "vender show" :
			System.out.print("Codigo do artista: ");
			CodigoArtista = leia.nextInt();
			System.out.print("Vender show de qual gravadora: ");
			GravadoraArtista = leia.nextLine();
			for (Gravadora gravadoraartista : lista3.getListaGravadora()){
				if (gravadoraartista.getNome() == GravadoraArtista){
					gravadoraartista.VenderShow(CodigoArtista);
				} else {
					System.out.print("Gravadora não encontrado");
				}
			}
			break;
		case "lançar titulo" :
			System.out.print("Genero do titulo: ");
			GeneroTitulo = leia.nextLine();
			System.out.print("Descrição do titulo: ");
			DescricaoTitulo = leia.nextLine();
			System.out.print("Ano de lançamento do titulo: ");
			AnoLancamentoTitulo = leia.nextInt();
			Titulo titulo = new Titulo(GeneroTitulo, DescricaoTitulo, AnoLancamentoTitulo);
			System.out.print("Artista que recebera o titulo: ");
			ArtistaTitulo = leia.nextLine();
			for (Artista artistas : lista2.getListaArtista()){
				if (artistas.getNome() == ArtistaTitulo){
					artistas.LancarTitulo(titulo);
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			break;
		case "excluir titulo" :
			System.out.print("Codigo do titulo: ");
			CodigoTitulo = leia.nextInt();
			System.out.print("Artista que tera o titulo excluido: ");
			ArtistaTitulo = leia.nextLine();
			for (Artista artistas : lista2.getListaArtista()){
				if (artistas.getNome() == ArtistaTitulo){
					artistas.ExcluirTitulo(CodigoTitulo);
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			break;
		case "buscar titulo" :
			System.out.print("Codigo do titulo: ");
			CodigoTitulo = leia.nextInt();
			System.out.print("Em qual artista deseja buscar: ");
			ArtistaTitulo = leia.nextLine();
			for (Artista artistas : lista2.getListaArtista()){
				if (artistas.getNome() == ArtistaTitulo){
					artistas.BuscarTitulo(CodigoTitulo);
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			break;
		case "ver a quantidade de um titulo" :
			System.out.print("Deseja ver a quantidade de titulos de um ano ou de um genero: ");
			Verificador2 = leia.nextLine();
			switch (Verificador2){
			case "ano" :
				System.out.print("Ano do titulo: ");
				AnoTitulo = leia.nextInt();
				System.out.print("De qual artista deseja ver: ");
				ArtistaTitulo = leia.nextLine();
				for (Artista artistas : lista2.getListaArtista()){
					if (artistas.getNome() == ArtistaTitulo){
						artistas.QuantidadeTitulos(AnoTitulo);
					} else {
						System.out.print("Artista não encontrado");
					}
				}
				break;
			case "genero" :
				System.out.print("Genero do titulo: ");
				GeneroTitulo = leia.nextLine();
				System.out.print("De qual artista deseja ver: ");
				ArtistaTitulo = leia.nextLine();
				for (Artista artistas : lista2.getListaArtista()){
					if (artistas.getNome() == ArtistaTitulo){
						artistas.QuantidadeTitulos(GeneroTitulo);
					} else {
						System.out.print("Artista não encontrado");
					}
				}
				break;
			default : 
				System.out.print("\nA opção escolhida não existe");
				break;
			}
			break;
		case "ver o artista que mais realizou show" :
			System.out.print("Nome do artista: ");
			ArtistaNome = leia.nextLine();
			for (Artista artistanomes : lista2.getListaArtista()){
				if (artistanomes.getNome() == ArtistaNome){
					artistanome = artistanomes;
				} else {
					System.out.print("Artista não encontrado");
				}
			}
			System.out.print("Artista de qual gravadora: ");
			GravadoraArtista = leia.nextLine();
			for (Gravadora gravadoraartista : lista3.getListaGravadora()){
				if (gravadoraartista.getNome() == GravadoraArtista){
					gravadoraartista.ArtistaShow(artistanome);
				} else {
					System.out.print("Gravadora não encontrado");
				}
			}
			break;
		case "sair" :
			System.out.print("Saindo");
			Verificador3 = "sair";
			break;
		default:
			System.out.print("\nA opção escolhida não existe");
			break;
		}
		}while (Verificador3 != "sair");
		System.out.print("\nPrograma encerrado");
	}
}
