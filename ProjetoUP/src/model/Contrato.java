package model;

public class Contrato {
	
	private Servico serv;
	private Cliente cli;
	private PrestadorServico ps;
	
	public Contrato() {
		this.serv = new Servico();
		this.cli = new Cliente();
		this.ps = new PrestadorServico();
	}
	
	public Cliente getCli() {
		return cli;
	}
	public Servico getServ() {
		return serv;
	}
	public PrestadorServico getPs() {
		return ps;
	}   
	
}
