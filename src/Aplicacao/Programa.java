package Aplicacao;

import javax.swing.JOptionPane;

import Funcoes.Forca;

public class Programa {

	public static void main(String[] args) {

		String palavra = JOptionPane.showInputDialog("Digite a palavra:").toUpperCase();
		String dica = JOptionPane.showInputDialog("Insira uma dica(Opicional):");
		String segredoNew;

		Forca f = new Forca(palavra);

		String segredo = f.ocutar(palavra);
		segredo = f.verificar(" ", palavra, segredo);

		while (f.getErros() < 6 && f.venceu(segredo)) {
			String letra = JOptionPane.showInputDialog(segredo
					+ "\nDica: "
					+ dica
					+ "\n"
					+ f.getBoneco()
					+ "\nLetras tentadas: " 
					+ f.getLetra() 
					+ "\nDigite uma letra:").toUpperCase().substring(0, 1);
			if (f.letraRepetida(letra)) {
				JOptionPane.showMessageDialog(null, "Letra repetida!!!");
			} else {
				f.setLetra(letra);
				segredoNew = f.verificar(letra, palavra, segredo);
				if (segredo.equals(segredoNew)) {
					f.errou();
				}
				segredo = segredoNew;
			}
		}
		
		if(!f.venceu(segredo)) {
			JOptionPane.showMessageDialog(null, "Parabéns!!! \nVocê venceu!!! \nA palavra era: " + palavra );
		}else {
			JOptionPane.showMessageDialog(null, "Você foi enforcado!!! \n" + f.getBoneco() + "\nA palavra era: " + palavra);
		}
		
	}

}
