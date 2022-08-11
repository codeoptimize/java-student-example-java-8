package java_8_student_excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class stud_app {

	public static void main(String[] args) {
		
		
		Student student1 = new Student(
	            "Jayesh",
	            20,
	            new Address("1234"),
	            Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
	 
	        Student student2 = new Student(
	            "Khyati",
	            20,
	            new Address("1235"),
	            Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
	 
	        Student student3 = new Student(
	            "Jason",
	            20,
	            new Address("1236"),
	            Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
	        
	        
	 
	        List<Student> students = Arrays.asList(student1, student2, student3);
	        
	        
	        
	        /*****************************************************
	         Get student with exact match name "jayesh"
	        *****************************************************/
	        
	        
	        students.stream().filter(s-> s.getName().equalsIgnoreCase("jayesh")).forEach(System.out::println);
	        
	        /*****************************************************
	         Get student with matching address "1235"
	        *****************************************************/
	        
	        
	        students.stream().filter(s-> s.getAddress().getZipcode().equalsIgnoreCase("1235")).forEach(System.out::println);
	        
	        /*****************************************************
	         Get all student having mobile numbers 3333.
	        *****************************************************/
	        
	        
	        List<Student> stud= students.stream().
	        		filter(s->s.getMobileNumbers().stream().anyMatch
	        				(n-> Objects.equals(n.getNumber(), "3333")))
	        		.collect(Collectors.toList());
	        
	        
	        		
	     
	        
	        Iterator<Student> itr = stud.iterator();
	        
	        while(itr.hasNext())
	        
	        	
	        	System.out.println(itr.next());
	        
	        
	        /*****************************************************
	         Get all student having mobile number 1233 and 1234
	         *****************************************************/
	        
	        List<Student> stud2 = students.stream().filter(s->s.getMobileNumbers().stream().
	        		allMatch(x->Objects.equals(x.getNumber(),"1233") || Objects.equals(x.getNumber(),"1234") )).collect(Collectors.toList());
	        
	        
	        	
              Iterator<Student> itr2 = stud2.iterator();
	        
	            while(itr2.hasNext())
	        
	        	
	        	System.out.println(itr2.next());
	            
	            /*****************************************************
	            Convert List<Student> to List<String> of student name
	           *****************************************************/
	            
	            
	            List<String> lst = new ArrayList<>();
	            
	            lst=students.stream().map(s-> s.getName()).collect(Collectors.toList());
	            
	            
	        
	        
	            Iterator<String> itr3=lst.iterator();
	            
	            
	            while(itr3.hasNext())
	    	        
		        	
		        	System.out.println(itr3.next());
	            
	            
	            
	            /*****************************************************
	            Change the case of List<String>
	           *****************************************************/
	           List<String> nameList =
	               Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
	           
	           nameList.stream().map(String::toUpperCase).forEach(System.out::println);
	           
	           
	           
	           /*****************************************************
	           Sort List<String>
	           *****************************************************/
	          List<String> namesList =
	              Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");
	          
	          
	           namesList.stream().sorted().forEach(System.out::print);
	         
	            
	            
	            
		
	}

}
