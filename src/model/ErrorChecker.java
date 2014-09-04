package model;

import javax.swing.JFrame;

public class ErrorChecker {

	public static JFrame getFrame(){
		return new JFrame();
	}
	
	
	public static boolean isFloat(String number){
		boolean isFloat=true;
		int pointCount=0;
		
		for(int i=0;i<number.length();i++){
			
			if((number.charAt(i)!='0') && (number.charAt(i)!='1') && (number.charAt(i)!='2') && (number.charAt(i)!='3') && (number.charAt(i)!='4') && (number.charAt(i)!='5') && (number.charAt(i)!='6') && (number.charAt(i)!='7') && (number.charAt(i)!='8') && (number.charAt(i)!='9') && (number.charAt(i)!='.')) {
				isFloat=false;
				System.out.println(i);
			}
			if(number.charAt(i)=='.'){
				pointCount++;
				if(pointCount==2){
					isFloat=false;
					System.out.println(i);
				}
			}
		}
		
		return isFloat;
	}
	
	public static boolean isOnlyLetters(String string){
		boolean isString=true;
		
		for(int i=0;i<string.length();i++){
			if( (string.charAt(i)!=' ') && (string.charAt(i)!='a') && (string.charAt(i)!='b') && (string.charAt(i)!='c') && (string.charAt(i)!='d') && (string.charAt(i)!='e') && (string.charAt(i)!='f') && (string.charAt(i)!='a') && (string.charAt(i)!='g') && (string.charAt(i)!='h') && (string.charAt(i)!='i') && (string.charAt(i)!='j') && (string.charAt(i)!='k') && (string.charAt(i)!='l') && (string.charAt(i)!='m') && (string.charAt(i)!='n') && (string.charAt(i)!='o') && (string.charAt(i)!='p') && (string.charAt(i)!='q') && (string.charAt(i)!='r') && (string.charAt(i)!='s') && (string.charAt(i)!='t') && (string.charAt(i)!='u') && (string.charAt(i)!='v') && (string.charAt(i)!='w') && (string.charAt(i)!='x') && (string.charAt(i)!='y') && (string.charAt(i)!='z') && (string.charAt(i)!='A') && (string.charAt(i)!='B') && (string.charAt(i)!='C') && (string.charAt(i)!='D') && (string.charAt(i)!='E') && (string.charAt(i)!='F') && (string.charAt(i)!='G') && (string.charAt(i)!='H')&& (string.charAt(i)!='I') && (string.charAt(i)!='J') && (string.charAt(i)!='K') && (string.charAt(i)!='L') && (string.charAt(i)!='M') && (string.charAt(i)!='N') && (string.charAt(i)!='O') && (string.charAt(i)!='P') && (string.charAt(i)!='Q') && (string.charAt(i)!='R') && (string.charAt(i)!='S') && (string.charAt(i)!='T') && (string.charAt(i)!='U')&& (string.charAt(i)!='V') && (string.charAt(i)!='W') && (string.charAt(i)!='X') && (string.charAt(i)!='Y') && (string.charAt(i)!='Z')){
				isString=false;
			}
		
		}
		
		return isString;
	}
	
	public static boolean isPhoneNumber(String number){
		boolean isNumber=true;
		
		for(int i=0;i<number.length();i++){
			
			if( (number.charAt(i)!='0') && (number.charAt(i)!='1') && (number.charAt(i)!='2') && (number.charAt(i)!='3') && (number.charAt(i)!='4') && (number.charAt(i)!='5') && (number.charAt(i)!='6') && (number.charAt(i)!='7') && (number.charAt(i)!='8') && (number.charAt(i)!='9') && (number.charAt(i)!='-')){
				isNumber=false;
			}
		
		}
		
		
		return isNumber;
	}

	public static boolean isInteger(String integer){
		boolean isInteger=true;
		
		for(int i=0;i<integer.length();i++){
			if( (integer.charAt(i)!='0') && (integer.charAt(i)!='1') && (integer.charAt(i)!='2') && (integer.charAt(i)!='3') && (integer.charAt(i)!='4') && (integer.charAt(i)!='5') && (integer.charAt(i)!='6') && (integer.charAt(i)!='7') && (integer.charAt(i)!='8') && (integer.charAt(i)!='9')){
				isInteger=false;
			}
		}
		
		return isInteger;
	}
}
