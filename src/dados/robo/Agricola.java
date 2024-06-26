package dados.robo;

import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("agricola")
public class Agricola extends Robo{
	private double area;
	private String uso;

	public Agricola(int id, String modelo, double area, String uso) {
		super(id, modelo);
		this.area = area;
		this.uso = uso;
		determinaValorDiario();
	}
	public Agricola() {

	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getUso() {
		return uso;
	}

	public void setUso(String uso) {
		this.uso = uso;
	}

	@Override
	public double calculaLocacao(int dias) {
		return dias * getValorDiario();
		}

	@Override
	public String toString() {
		return "\n" + super.toString() + "Uso = " + this.uso + " | Area = " + this.area + " m2";
	}
	private void determinaValorDiario() {
		setValorDiario(area*10);
	}
}
