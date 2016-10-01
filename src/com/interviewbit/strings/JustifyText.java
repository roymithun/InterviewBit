package com.interviewbit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JustifyText {

	public static void main(String[] args) {
		String[] s = { "ThisThisThisThis", "is", "an", "example", "of", "text", "justification." };
		fullJustify(new ArrayList<>(Arrays.asList(s)), 16);
	}

	static public List<String> fullJustify(ArrayList<String> words, int L) {
		List<String> res = new ArrayList<String>();
		int firstIdx = 0, N = words.size();
		while (firstIdx < N) {
			int length = words.get(firstIdx).length();
			int lastIdx = firstIdx + 1;

			// check max length of words that could be added and adjust index
			while (lastIdx < N && length + words.get(lastIdx).length() + (lastIdx - firstIdx) <= L) {
				length += words.get(lastIdx++).length();
			}

			StringBuilder s = new StringBuilder(words.get(firstIdx));

			// lastLine reduces effort see as done for if (L - s.length() > 0)
			boolean isLastLine = (lastIdx == N);
			boolean oneWord = (lastIdx == firstIdx + 1);
			
			int spaceLength = (isLastLine || oneWord) ? 1 : (L - length) / (lastIdx - firstIdx - 1);
			int extraSpace = (isLastLine || oneWord) ? 0 : (L - length) % (lastIdx - firstIdx - 1);
			for (int wordsIdx = firstIdx + 1; wordsIdx < lastIdx; ++wordsIdx) {
				char[] space = new char[extraSpace > 0 ? spaceLength + 1 : spaceLength];
				Arrays.fill(space, ' ');
				s.append(space);
				s.append(words.get(wordsIdx));
				extraSpace--;
			}

			if (L - s.length() > 0) {
				char[] tmp = new char[L - s.length()];
				Arrays.fill(tmp, ' ');
				s.append(tmp);
			}
			res.add(s.toString());
			firstIdx = lastIdx;
		}
		return res;
	}
}
