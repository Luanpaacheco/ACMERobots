package dados.cliente;

import aplicacao.ACMERobots;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")

public abstract class Cliente {
	private int codigo;
	private String nome;

	public Cliente(int codigo, String nome){
		this.codigo=codigo;
		this.nome=nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome(){
		return nome;
	}

	public abstract double calculaDesconto();
	@Override
	public String toString() {
		return "\n" + nome + ", Codigo: " + codigo + ", ";
	}
}
