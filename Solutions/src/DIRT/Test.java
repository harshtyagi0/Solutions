package DIRT;

import java.lang.reflect.*;

public class Test {
	static Class C;

	public static void methodsName(String s) throws ClassNotFoundException {
		C = Class.forName(s);
		Method[] m = C.getDeclaredMethods();
		if (m.length == 0)
			System.out.println("0 Methods");
		else {
			for (int i = 0; i < m.length; i++) {
				Method method = m[i];
				System.out.println("Method Name:- " + method.getName());
				System.out.println("Declared Class :- " + method.getDeclaringClass());
				Class p[] = method.getParameterTypes();
				for (int j = 0; j < p.length; j++) {
					System.out.println("\tParameters :- " + p[j].getName());
				}
				System.out.println("Return Type :- " + method.getReturnType());
				int mm = method.getModifiers();
				System.out.println("Modifiers :- " + Modifier.toString(mm));
				System.out.println("##############################################################################");
			}
		}
	}

	public static void attributesDetails(String s) throws ClassNotFoundException {
		C = Class.forName(s);
		Field[] f = C.getDeclaredFields();
		if (f.length == 0)
			System.out.println("Doesn't have any Attribute");
		else {
			for (int i = 0; i < f.length; i++) {
				Field field = f[i];
				System.out.println("Fields Name:- " + field.getName());
				System.out.println("Declared Class :- " + field.getDeclaringClass());
				System.out.println("DataType:- " + field.getType());
				System.out.println("##############################################################################");
			}
		}

	}
	public static Object instanceCreation(String s) throws ClassNotFoundException {
		try {
			return Class.forName(s).newInstance();
		} catch (Exception E) {
		}
		System.out.println("Unable to Instance");
		return null;
	}

	public static void constructersDetails(String s) throws ClassNotFoundException {
		C = Class.forName(s);
		Constructor[] constructors = C.getDeclaredConstructors();
		for (Constructor cons : constructors) {
			System.out.println("Constructor Name: " + cons.getName());
			int modifier = cons.getModifiers();
			String mod = Modifier.toString(modifier);
			System.out.println("Modifier: " + mod);
			System.out.println("Parameters: " + cons.getParameterCount());
			Class p[] = cons.getParameterTypes();
			if (p.length == 0) {
				System.out.println("\t0 Parametarised Constructor ");
				System.out.println("##############################################################################");
			} else {
				for (int j = 0; j < p.length; j++) {
					System.out.println("\tParameters :- " + p[j].getName());
				}
				System.out.println("##############################################################################");
			}
		}
	}

	public static void main(String[] args) throws ClassNotFoundException {
		for (int i = 0; i < args.length; i++) {

			System.out.println("##############################################################################");
			System.out.println("\t\tMethods Details");
			System.out.println("##############################################################################");
			methodsName(args[i]);
			System.out.println("\n-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- End Of Method -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");

			System.out.println("\n##############################################################################");
			System.out.println("\t\tAttributes Details");
			System.out.println("##############################################################################");
			attributesDetails(args[i]);
			System.out.println("\n-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- End Of Method -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");

			System.out.println("\n##############################################################################");
			System.out.println("\t\tConstructors Details");
			System.out.println("##############################################################################");
			constructersDetails(args[i]);
			System.out.println("\n-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- End Of Method -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");

			System.out.println("\n##############################################################################");
			System.out.println("\t\tInstance Details");
			System.out.println("##############################################################################");
			try {
				Object O = instanceCreation(args[i]);
				System.out.println(O.hashCode());
				System.out.println(O.toString());
			} catch (Exception E) {
			}
			System.out.println("\n-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x- End Of Method -x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
		}
	}

}
