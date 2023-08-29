public class Nome{
	public static boolean scan(String s){
		int state=0;
		int i=0;

		while(state >= 0 && i < s.length()){
				final char ch = s.charAt(i++);

				switch(state){
					case 0:
						if(ch==109){
							state=1;
						}
						else{
							if(ch>=97 && ch<=108 || ch>109 && ch<=122){
								state=7;
							}

						}
					break;
					case 1://M
						if(ch==97){
							state=2;
						}
						else{
							if(ch>97 &&ch<=122){
								state=8;
							}
						}
					break;
					case 2://a
						if(ch==116){
							state=3;
						}
						else{
							if(ch>=97 && ch<116 ||ch>116 && ch<=122){
								state=9;
							}
						}
					break;
					case 3://t
						if(ch==116){
							state=4;
						}
						else{
							if(ch>=97 && ch<116 ||ch>116 && ch<=122){
								state=10;
							}
						}
					break;
					case 4://t
						if(ch==101){
							state=5;
						}

					break;
					case 5://e
						if(ch==111){
							state=6;
						}
					break;
					case 7:
						if(ch==97){
							state=2;
						}
					break;
					case 8:
						if(ch==116){
							state=3;
						}
					break;
					case 9:
						if(ch==116){
							state=4;
						}
					break;
					case 10:
						if(ch==101){
							state=5;
						}
					break;

				}
		}
		return state==6;
	}
	public static void main(String[] args){
		System.out.println(scan(args[0]) ? "OK" : "NOPE");
	}
}