import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Operacao {
	
	private String caracter;

	public Operacao() {
		caracter = "+";
	}

	public Operacao(String caracter) {
		this.caracter = caracter;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	
	public BigDecimal realizaOperacao(BigDecimal valAnterior, BigDecimal valPosterior) {
		
		System.out.println("operacao: " + valAnterior + " " + caracter + " " + valPosterior);
		valAnterior.round(new MathContext(10));
		valPosterior.round(new MathContext(10));
		valAnterior.setScale(10,RoundingMode.HALF_UP);
		valPosterior.setScale(10, RoundingMode.HALF_UP);
		if(caracter == "+") {
			return valAnterior.add(valPosterior);
		}
		else if(caracter == "-") {
			return valAnterior.subtract(valPosterior);
		}
		else if(caracter == "*") {
			return valAnterior.multiply(valPosterior);
		}
		else{
			return valAnterior.divide(valPosterior); 
		}
	}

}
