package com.gmail.at.ivanehreshi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentCleaner {

	public static String clean(String fileContent) {
		String result;
		
		Pattern singleComment = 
				Pattern.compile("^[ \t;]*//.*?\n", Pattern.DOTALL + Pattern.MULTILINE);
		Matcher singleCommentMatcher = singleComment.matcher(fileContent);
		result = singleCommentMatcher.replaceAll("");
		
		Pattern multiLineComment = 
				Pattern.compile("^([ \t;]*/\\*.*?\\*/)", Pattern.DOTALL + Pattern.MULTILINE);
		Matcher multiLineMatcher = multiLineComment.matcher(result);
		 result = multiLineMatcher.replaceAll("");
		
		return result;
	}
	
	
	
}