package dados.robo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "tipo")
public abstract class Robo {
	private int id;
	private String modelo;
	private double valorDiario;

	public Robo(int id, String modelo) {
		this.id = id;
		this.modelo = modelo;
	}
	public Robo() {}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getValorDiario() {
		return valorDiario;
	}

	public void setValorDiario(double valorDiario) {
		this.valorDiario = valorDiario;
	}
	public abstract double calculaLocacao(int dias);

	@Override
	public String toString() {
		return  "\n" + "Modelo: " + modelo + ", Id: " + id + ", ";
	}
}
