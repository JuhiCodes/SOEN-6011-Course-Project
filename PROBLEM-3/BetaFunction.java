import java.util.Scanner;

public class BetaFunction {

	private static double x,y;
	final static double PI = 3.141592653589793;
	final static double E = 2.718281828459045;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter x -> ");
		x = sc.nextDouble();

		while(!validateInput(x)) {
			System.out.println("Only positive number is allowed");
			System.out.println("Enter x -> ");
			x = sc.nextDouble();
		}


		System.out.println("Enter y -> ");
		y = sc.nextDouble();

		while(!validateInput(y)) {
			System.out.println("Enter y -> ");
			System.out.println("Only positive number is allowed");
			y = sc.nextDouble();
		}

		double z = x+y;

		System.out.println("Calculation of gamma function using Sterling's approximation");
		double gammaX = computeGamma(x);
		double gammaY = computeGamma(y);
		double gammaZ = computeGamma(z);

		System.out.println("Gamma for x -> " + gammaX);
		System.out.println("Gamma for y -> " + gammaY);
		System.out.println("Gamma for z -> " + gammaZ);

		double beta = (gammaX * gammaY)/gammaZ;
		System.out.println("Beta(" + x +", " + y +") -> " + beta);

		System.out.println("----------------------------------------------------------------------");
		System.out.println("Calculation of gamma function using factorial");
		double gammafactX = getFactorial(x,true);
		double  gammafactY = getFactorial(y,true);
		double  gammafactZ = getFactorial(z,true);
		System.out.println("Gamma x :" + gammafactX);
		System.out.println("Gamma y:" + gammafactY);
		System.out.println("Gamma z:" + gammafactZ);
		double betaFactorial = (gammafactX *  gammafactY)/gammafactZ;
		System.out.println("Beta(" + x +", " + y +") ->" + betaFactorial);
	}

	public static double getFactorial(double ele, boolean flag) {
		int temp = (int) ele;
		if (flag) {
			temp--;
		}

		if (temp <= 1) {
			return 1;
		} else {
			return temp * getFactorial(temp -1 , false);
		}

	}

	private static boolean validateInput(double number) {
		if(number<0){
			System.out.println("Negative number not allowed");
			return false;
		}
		else{return true;
		}

	}
	public static double computeGamma(double ele) {
		ele--;
		double root = (2 * PI * ele);
		double sqRoot = computeSquareRoot(root);
		double power = computePower((ele / E), ele);
		return (sqRoot) * (power);
	}


	public static double computeSquareRoot(double number) {
		double temp;
		double temp1;

		double squareRoot = number / 2;
		do {
			temp = squareRoot;
			temp1 = (temp + (number / temp));
			squareRoot = temp1 / 2;
		} while ((temp - squareRoot) != 0);

		return squareRoot;
	}


	public static double computePower(double num1,double num2) {
		double power = 1;
		int i = 0;

		while(i < num2) {
			power = power * num1;
			i++;
		}

		return power;
	}

}

