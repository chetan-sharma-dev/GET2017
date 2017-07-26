package oops_session3;

import java.util.HashMap;

public class test {
public static void main(String...s)
{
	HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
	a.put(1, 0);
	a.put(2, 0);
	a.put(3, 0);
	System.out.println(a.keySet().toString());
	String sp=a.keySet().toString().replace("[", "");
	System.out.println(sp);
	sp=sp.replace("]", "");
	String[] spl=sp.split("\\, ");
	System.out.println(spl[0]+spl[1]+spl[2]);
	
	}
}
