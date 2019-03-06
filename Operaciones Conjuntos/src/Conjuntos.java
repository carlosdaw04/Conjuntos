import java.util.ArrayList;
import java.util.Scanner;

public class Conjuntos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribe una operacion (formato : [x,x,x]+[y,y,y]): ");
		String operacion = sc.nextLine();
		
		
		ArrayList<Integer> ar1 = new ArrayList<Integer>();
		ArrayList<Integer> ar2 = new ArrayList<Integer>();
		char simbolo = ' ';
		String op1 = "";
		String op2 = "";

		for (int i = 0; i < operacion.length(); i++) {
			if (operacion.charAt(i) == '+' || operacion.charAt(i) == '*' || operacion.charAt(i) == '-') {
				simbolo = operacion.charAt(i);
				op1 = operacion.substring(1, i - 1);
				op2 = operacion.substring(i + 2, operacion.length() - 1);
			}
		}

		for (int i = 0; i < op1.length(); i++) {
			if (Character.isDigit(op1.charAt(i))) {
				ar1.add(Character.getNumericValue(op1.charAt(i)));
			}
		}

		for (int i = 0; i < op2.length(); i++) {
			if (Character.isDigit(op2.charAt(i))) {
				ar2.add(Character.getNumericValue(op2.charAt(i)));
			}
		}

		ArrayList<Integer> solucion = new ArrayList<Integer>();

		if (simbolo == '+') {
			for (int i = 0; i < ar1.size(); i++) {
				solucion.add(ar1.get(i));
			}

			for (int i = 0; i < ar2.size(); i++) {
				if (!solucion.contains(ar2.get(i))) {
					solucion.add(ar2.get(i));
				}
			}
		} else if (simbolo == '*') {
			for (int i = 0; i < ar1.size(); i++) {
				if (ar2.contains(ar1.get(i))) {
					solucion.add(ar1.get(i));
				}
			}

			for (int i = 0; i < ar2.size(); i++) {
				if (!solucion.contains(ar2.get(i))) {
					if (ar1.contains(ar2.get(i))) {
						solucion.add(ar2.get(i));
					}
				}
			}
		} else if (simbolo == '-') {
			for (int i = 0; i < ar1.size(); i++) {
				if (!ar2.contains(ar1.get(i))) {
					solucion.add(ar1.get(i));
				}
			}
		}
		
		if(solucion.size() == 1){
			System.out.println("[" + solucion.get(0) + "]");
		}else {
			for (int i = 0; i < solucion.size(); i++) {
				if (i == 0) {
					System.out.print("[" + solucion.get(i) + ", ");
				} else if (i == solucion.size() - 1) {
					System.out.print(solucion.get(i) + "]");
				} else {
					System.out.print(solucion.get(i) + ", ");
				}
			}
		}
	}
	
	
}
