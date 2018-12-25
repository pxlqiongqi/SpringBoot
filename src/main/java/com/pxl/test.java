package com.pxl;

import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] args) {
		String a[]=new String[] {"aaaaa","bbbbb","cccccccc"};
		List b=Arrays.asList(a);
		String join = String.join("utf-8", a);
		System.out.println(join);
	}
}
