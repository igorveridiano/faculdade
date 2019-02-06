package Teste;

public class Criptografia {
	public static final int ALFABETO=62;
	public static final char[] alpha ={'Q','A','Z','W','S','X','E','D','C','R','F','V'
	,'1','T','G','B','Y','H','N','U','M','3','J','2','I','K','L','O','P','4','5','p'
	,'l','m','k','o','n','6','j','i','b','h','7','u','v','g','y','c','f','t','x','d',
	'8','r','z','9','s','e','a','w','0','q'};
	protected char[] encrypt=new char[ALFABETO];
	protected char[] decrypt=new char[ALFABETO];
	public Criptografia(){
		for (int i = 0; i <ALFABETO; i++) {
			encrypt[i]=alpha[((i+4)%ALFABETO)];

		}
	
		for (int j = 0; j <ALFABETO; j++) {
			decrypt[encrypt[j]-'Q']=alpha[j];
			
		
		}
	}
	public String encrypt (String secret){
		char[] mess =secret.toCharArray();
		for (int i = 0; i < mess.length; i++) {
			if (Character.isUpperCase(mess[i])) {
				mess[i]=encrypt[mess[i]-'Q'];
			}
		}
		return new String(mess);
	}
	public String decrypt (String secret){
		char[] mess =secret.toCharArray();
		for (int i = 0; i < mess.length; i++) {
			if (Character.isUpperCase(mess[i])) {
				mess[i]=decrypt[mess[i]-'Q'];
			}
		}
		return new String(mess);
	}


}
