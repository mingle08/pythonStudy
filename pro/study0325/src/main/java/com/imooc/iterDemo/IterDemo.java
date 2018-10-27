package com.imooc.iterDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IterDemo {

	public static void main(String[] args) {
		iterDemo();

	}
	
	
    public static void iterDemo(){
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        Iterator<String> iter1 = list1.iterator();
        while(iter1.hasNext()){
            String str1 = iter1.next();
            if("c".equals(str1)){
                iter1.remove();
            }
        }
        
        for(String str11 : list1) {
        	System.out.println(str11);
        }
        
        System.out.println("==============");

        List<String> list2 = new LinkedList<String>();
        list2.add("Tom");
        list2.add("Joey");
        list2.add("Jack");
        ListIterator<String> iter2 = list2.listIterator();
        while(iter2.hasNext()){
            String str2 = iter2.next();
            if("Tom".equals(str2)){
                iter2.remove();
            }
        }
        
        for(String str22 : list2) {
        	System.out.println(str22);
        }
        
    }

}
