package wsht.runtime.expressions.sbql.ast.operators.wsht.utils;

import java.util.Map;
import java.util.TreeMap;

public class OperatorUtils {

	public static int dominator(Boolean[] booleans) {
		int count = 0, result = 0;
		for (int i = 0; i < booleans.length; i++) {
			if (booleans[i] == booleans[result]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result = i;
				count++;
			}
		}
		return result;
	}
	
	public static boolean isMajority(Boolean A[], boolean cand, float percent) {
		int i, count = 0;
		for (i = 0; i < A.length; i++)
			if (A[i] == cand)
				count++;
		if ((count / A.length) * 100 > percent)
			return true;
		else
			return false;
	}

	
	public static int dominator(String[] A) {
		int count = 0, result = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i].equals(A[result])) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result = i;
				count++;
			}
		}
		return result;
	}
	
	public static boolean isMajority(String A[], String cand, float percent) {
		int i, count = 0;
		for (i = 0; i < A.length; i++)
			if (A[i].equals(cand))
				count++;
		if ((count / A.length) * 100 > percent)
			return true;
		else
			return false;
	}
	
	
	public static String occurence(String[] A, boolean most) {
		String string = null;
		int count = 0;
		
		if(A.length == 0) {
			return "";
		}
		
		TreeMap<String, Integer> occur = new TreeMap<String, Integer>();
		for (int i = 0; i < A.length; i++) {
			String s = A[i];
			if (occur.containsKey(s)) {
				int val = occur.get(s);
				val++;
				occur.put(s, val);
				if (val > count)
				{
					string = s;
					count = val;
				}
			} else {
				occur.put(s, 1);
			}
		}
		
		if(!most) {
			count = 0;
			for(Map.Entry<String, Integer> entry : occur.entrySet()) {
				if(count == 0 || entry.getValue() < count) {
					string = entry.getKey();
					count = entry.getValue();
				}
			}
		}
		
		for(Map.Entry<String, Integer> entry : occur.entrySet()) {
			if(!entry.getKey().equals(string) && entry.getValue() == count) {
				return "";
			}
		}
		
		return string;
	}
	

}