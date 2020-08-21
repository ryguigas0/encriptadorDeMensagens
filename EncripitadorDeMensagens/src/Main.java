import javax.swing.JOptionPane;

public class Main {
	
	
	public static void main(String[] args) {
		StringBuilder alfabeto = new StringBuilder(26); //Cria um fazedor de string do tamanho de letras do alfabeto
		
		alfabeto.append("abcdefghijklmnopqrstuvwxyz"); //Coloca no fazedor de strings
		
		
		
		while(true) {
			String optionIn = JOptionPane.showInputDialog(null, "Encriptar(1) Decriptar(2) Sair(3)",
				"Encriptador De mensagens", 1); //Cria a caixa de input
			int optionOut = Integer.parseInt(optionIn); //Pega o imput
		
			if(optionOut == 1) {	//Roda o código de acordo com o input
				Encriptar(alfabeto);
			} else if(optionOut == 2) {
				Decriptar(alfabeto);
			} else if(optionOut == 3) {
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Tchau!!");
	}
	
	public static void Encriptar(StringBuilder a) {
	
		String msgUsr = JOptionPane.showInputDialog(null,
				"Escreva abaixo a mensagem a ser encriptada"
				, "Encripitador de mesagens", 1);
		StringBuilder msgEncr = new StringBuilder(msgUsr.length()); //Pega a mensagem
		
		String numUsrIn = JOptionPane.showInputDialog(null,
			"Escreva abaixo o número da cifra(1 a 25)"
			, "Encripitador de mesagens", 1);
		int numUsrOut = Integer.parseInt(numUsrIn); //Pega o número da cifra
	
	
		for(int j = 0;j < msgUsr.length() ;j++) { //Troca as letras
			for(int i = 0; i < a.length(); i++ ) { //Para cada letra na mesagem
				if(msgUsr.charAt(j) == a.charAt(i)) {//Se encontrou a letra no alfabeto
					if(i + numUsrOut > 25) {
						msgEncr.append(a.charAt(i + numUsrOut - 26)); //Se o número da letra mais da cifra for maior que 26, tira 25 e junta a letra na posição do que sobra
					} else {
						msgEncr.append(a.charAt(i + numUsrOut)); //se não junta a letra na posição da soma direto
					}
				}
			}		
		}
	
	
//		msgEncr.append(numUsrOut);
		
		if(numUsrOut > 9) { //Se tiver um dígito
			msgEncr.append(numUsrOut); //coloca na mesagem
		} else {
			msgEncr.append("0" + numUsrOut); //se não coloca um 0 do lado do número
		}
		
		JOptionPane.showMessageDialog(null, "A mensgaem ficou encriptada assim: " + msgEncr); //escreve a mensagem
	}
	
	
	public static void Decriptar(StringBuilder a) {
		String msgUsr = JOptionPane.showInputDialog(null,
				"Escreva abaixo a mensagem a ser decriptada"
				, "Encripitador de mesagens", 1); //Pega a mensagem
		
		int tamanhoMsg = msgUsr.length() -1;
		
		StringBuilder msgEncr = new StringBuilder(tamanhoMsg);
		
		//Pegar a mensgaem em letras
		
		for (int i = 0; i < tamanhoMsg; i++) {
			msgEncr.append(msgUsr.charAt(i));
		}
		
		//Numero da cifra
		
		String cifraStr = msgUsr.substring(msgUsr.length() - 2);
		int cifra = Integer.parseInt(cifraStr);
		
		StringBuilder msg = new StringBuilder(msgUsr.length() -1 );
		
		for(int j = 0;j < msgUsr.length() ;j++) {
			for(int i = 0; i < a.length(); i++ ) {
				if(msgUsr.charAt(j) == a.charAt(i)) {
					if(i - cifra < 0) {
						msg.append(a.charAt(i - cifra + 26));
					} else {
						msg.append(a.charAt(i - cifra));
					}
				}
			}		
		}
		
		JOptionPane.showMessageDialog(null, "A mensagem decifrada é: " + msg);
		
	}
}