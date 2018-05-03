package com.tree234;
import java.io.*;
public class Tree234Test {

	public static void main(String[] args) throws IOException {
		long value;
		Tree234 tree = new Tree234();
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(30);
		tree.insert(70);
		while(true) {
			System.out.print("Please Enter first letter of show, insert, or find.");
			char choice = getChar();
			switch(choice) {
			case 's':
				tree.displayTree();
				break;
			case 'i':
				System.out.print("Enter value to insert: ");
				value = getInt();
				tree.insert(value);
				break;
			case 'f':
				System.out.print("Enter value to find: ");
				value = getInt();
				int found = tree.find(value);
				if(found != -1) {
					System.out.print("found : " + value);
				}else {
					System.out.print("could not found " + value);
				}
				break;
			default:
				System.out.print("Invalid enter\n");
			}
		}

	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return br.readLine();
	}
	
	public static char getChar() throws IOException {
		return getString().charAt(0);
	}
	
	public static int getInt() throws IOException {
		return Integer.valueOf(getString());
	}

}
