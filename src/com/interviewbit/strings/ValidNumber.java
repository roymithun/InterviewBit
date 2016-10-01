package com.interviewbit.strings;

public class ValidNumber {

	public static void main(String[] args) {
		// (1) " . " , "." true, "1.e2" false.
		// (2) " e ", ".e1" false, "1e.1" false, "1e1.1" false, "2.3e" false.
		// (3) "+/-", "+1.e+5" true.

		System.out.println(isNumber("1.e1"));
	}

	static public int isNumber(String s) {
		int start = 0, end = s.length() - 1;
		boolean dot = false, exp = false, digit = false;
		while (start <= end && (s.charAt(start) == ' '))
			++start;
		while (start <= end && (s.charAt(end) == ' '))
			--end;
		if (start <= end && (s.charAt(start) == '+' || s.charAt(start) == '-'))
			++start;
		if (start > end)
			return 0;
		for (; start <= end; ++start) {
			if (Character.isDigit(s.charAt(start)))
				digit = true;
			else if (s.charAt(start) == 'e' || s.charAt(start) == 'E') {
				if (exp == true || digit == false || start == end)
					return 0;
				exp = true;
			} else if (s.charAt(start) == '.') {
				if (start == end)
					return 0;
				if (start + 1 >= 0 && start + 1 <= end)
					if (!Character.isDigit(s.charAt(start + 1)))
						return 0;
				if (start - 1 >= 0 && start - 1 <= end)
					if (!Character.isDigit(s.charAt(start - 1)))
						return 0;
				if (dot == true || exp == true)
					return 0;
				if (digit == false && start == end)
					return 0;
				dot = true;
			} else if (s.charAt(start) == '+' || s.charAt(start) == '-') {
				if (start == end)
					return 0;
				if (s.charAt(start - 1) != 'e' && s.charAt(start - 1) != 'E')
					return 0;
			} else
				return 0;
		}
		return 1;
	}
}
