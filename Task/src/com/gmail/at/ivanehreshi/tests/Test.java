package com.gmail.at.ivanehreshi.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.gmail.at.ivanehreshi.CommentCleaner;

@RunWith(Parameterized.class)
public class Test {
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][]{
			{"", ""},
			{" asdk ", " asdk "},
			{"// \n", ""}
		});
	}
	
	public String input;
	public String output;
	
	public Test(String input, String output){
		this.input = input;
		this.output = output;
	}
	
	@org.junit.Test
	public void test() {
		assertEquals(output, CommentCleaner.clean(input));
	}

}
