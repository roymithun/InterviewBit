package com.interviewbit.stacks;

import java.util.LinkedList;
import java.util.Stack;

public class SimplifyDirectoryPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b/../../c/"));
	}
	
	static public String simplifyPath(String directoryPath) {
	    Stack<String> stack = new Stack<String>();
	 
	    while(directoryPath.length()> 0 && directoryPath.charAt(directoryPath.length()-1) =='/'){
	        directoryPath = directoryPath.substring(0, directoryPath.length()-1);
	    }
	 
	    int start = 0;
	    for(int i=1; i<directoryPath.length(); i++){
	        if(directoryPath.charAt(i) == '/'){
	            stack.push(directoryPath.substring(start, i));
	            start = i;
	        }else if(i==directoryPath.length()-1){
	            stack.push(directoryPath.substring(start));
	        }
	    }
	 
	    LinkedList<String> result = new LinkedList<String>();
	    int back = 0;
	    while(!stack.isEmpty()){
	        String top = stack.pop();
	 
	        if(top.equals("/.") || top.equals("/")){
	            // do nothing
	        }else if(top.equals("/..")){
	            back++;
	        }else{
	            if(back > 0){
	                back--;
	            }else{
	                result.push(top);
	            }
	        }
	    }
	 
	    //if empty, return "/"
	    if(result.isEmpty()){
	        return "/";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	    while(!result.isEmpty()){
	        String s = result.pop();
	        sb.append(s);
	    }
	 
	    return sb.toString();
	}
}
