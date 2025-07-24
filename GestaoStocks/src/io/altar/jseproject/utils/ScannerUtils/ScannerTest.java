package io.altar.jseproject.utils.ScannerUtils;


public class ScannerTest {

	public static void main(String[] args) {
		ScannerUtils sc = new ScannerUtils();
		
		System.out.println(sc.getInt("Escreva a sua idade?"));
		
		int[] ivas = {23,13,6};
		System.out.println(sc.getValidInt("Escreva um valor de iva valido.", ivas));
		
		int max = 50;
		int min = 1;
		System.out.println(sc.getValidInt("Escreva um numero.", min, max));
	}
}