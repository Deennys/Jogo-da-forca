package Funcoes;

public class Forca {

	private String palavra;
	private String letra = "";
	private int erros;
	private String boneco =  " \"\"\""
			+ "|";

	public Forca(String palavra) {
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra += " " + letra.toUpperCase().substring(0) + ",";
	}

	public int getErros() {
		return erros;
	}
	
	public String getBoneco() {
		return boneco;
	}
	
	public void errou() {
		erros++;
		if(erros == 1) {
			boneco += "\n      O";
		}
		if(erros == 2) {
			boneco += "\n       |";
		}
		if(erros == 3) {
			boneco = " \"\"\""
					+ "|\n    " 
					+ "\\ "
					+ "O\n       |";
		}
		if(erros == 4) {
			boneco = " \"\"\""
					+ "|\n    " 
					+ "\\ "
					+ "O /\n       |";
		}
		if(erros == 5) {
			boneco += "\n    /";
		}
		if(erros == 6) {
			boneco += "    \\" ;
		}
	}
	
	public String ocutar(String palavra) {
		String aux = "";
		for (int i = 0; i < palavra.length(); i++) {
			aux += "* ";
		}
		return aux;
	}

	public String verificar(String letra, String palavra, String segredo) {
		String aux = "";
		for (int i = 0; i < palavra.length(); i++) {
			if (letra.equals(palavra.substring(i, i + 1))) {
				aux += letra + " ";
			} else {
				aux += segredo.charAt(i * 2) + " ";
			}
		}
		return aux;
	}

	public boolean letraRepetida(String letra) {
		for (int i = 0; i < this.letra.length(); i++) {
			if (letra.equals(this.letra.substring(i, i + 1))) {
				return true;
			}

		}
		return false;
	}

	public boolean venceu(String segredo) {
		for (int i = 0; i < segredo.length(); i++) {
			if('*' == segredo.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
}
