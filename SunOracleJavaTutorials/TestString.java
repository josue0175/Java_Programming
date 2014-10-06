
public class TestString {
	
	public static void main (String[] args) {
		isUniqueChars("abcdafgbhij");
	}
	public boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		//String str = "abccdefgg";
		for(int i=0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				System.out.println("Found duplicate");
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static boolean isUniqueChars(String str) {
		//boolean[] char_set = new boolean[256];
		int checker = 0;
                int _sizeofint = sizeof(int);
	        System.out.println("sizeofint = " + _sizeofint);
		for(int i=0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			int a = 'a';
			System.out.println("value for a = " + a);
			System.out.println("value for current char = " + str.charAt(i));
			System.out.println("value for val = " + val);
			if((checker & (1<<val)) > 0) {
				System.out.println("Found duplicate");
				return false;
			}
			checker |= (1<<val);
		}
		return true;

	}
}
