import java.util.Random;
import java.util.Arrays;
public class Totoloto {

	public static void main(String[] args) {
		int a[]= geraApostas();
		Arrays.sort(a);
		System.out.print("Aposta Gerada: ");
		for (int aposta:a)
			System.out.print(aposta + " ");
	}
	// Gera as apostas 
	public static int[] geraApostas(){
		int[] a= new int[6];
		Random r=new Random();
		for (int i=0; i<6; i++)
			do {
			a[i]=r.nextInt(49)+1;
			} while(existe(a, i,a[i]));
		return a;
	}
	// Verificar se um elemento existe num array, até n posições
	public static boolean existe(int[] ar, int n, int ele){
		for (int i=0; i<n; i++)
			if(ele==ar[i]) return true;
		return false;
	}

}
