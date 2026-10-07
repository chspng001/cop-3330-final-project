/* 
phillip nguyen
cop 3330 section 1
hatim boustique
final project
*/

package finalproject2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args) throws FileNotFoundException, InputMismatchException {

        ArrayList<Person> personList = new ArrayList<>();
        int choice = 0;

        Scanner input = new Scanner(System.in);
        
        boolean valid = false;

        System.out.println("Welcome to the Personnel Management Program!");
        
        System.out.println("");

        while (choice != 8 || valid == false ) {

            System.out.println("[1] - Enter the information of a faculty"); // done
            System.out.println("[2] - Enter the information of a student"); // done
            System.out.println("[3] - Print tuition invoice for a student"); // done
            System.out.println("[4] - Print faculty information"); // done
            System.out.println("[5] - Enter the information of a staff member"); // done
            System.out.println("[6] - Print the information of a staff member"); // done
            System.out.println("[7] - Delete a personal entry"); // done
            System.out.println("[8] - Exit program"); // done
            
            System.out.println("");

            do {
            	
            	try 
            	{
            		
            		System.out.println("");
                	System.out.print("Choose one of the options: ");
            		
	            	choice = input.nextInt();
	            	input.nextLine();  // consume newline character
	            	
	            	if ( choice == 1 || choice == 2 || choice == 3 || choice == 4 | choice == 5 || choice == 6 || choice == 7 || choice == 8 ) 
	            	{
	            	
	            		valid = true;
	            		break;
	            		
	            	}}
            	
            	catch ( Exception e ) 
            	{
            		
            		input.nextLine();
            		
            		System.out.println("");
            		
            		System.out.println("[ --- Invalid input, please try again. --- ]");
            		
            		System.out.println("");
            		
            	}
            	
            	break;
            
            } while ( valid == false );
            
            switch (choice) 
            {

                case 1: // enter the information of a faculty
                    try 
                    {
                    	
                    	System.out.println("");
                        System.out.println("[ --- You chose [1] - Enter the information of a faculty --- ]");
                        System.out.println("");

                        // take faculty name
                        
                        System.out.print("Enter the name of the faculty: ");
                        String facName = input.nextLine();
                        
                        // take faculty ID
                        
                        String facID;
                        boolean idExists;

                        do 
                        {
                        	
                            idExists = false;
                            System.out.print("Enter the ID of the faculty (follow format LowercaseLetterLowercaseLetterNumberNumberNumberNumber): ");
                            facID = input.nextLine().toLowerCase();
                            
                            // check if ID properly formatted

                            if (!facID.matches("^[a-z]{2}\\d{4}")) 
                            {
                            	
                            	System.out.println("");
                                System.out.println("Invalid input - please try again (your format may be incorrect).");
                                System.out.println("");
                                continue;
                                
                            }
                            
                            // check if ID already exists in PersonList

                            for (Person person : personList) 
                            {
                            	
                                if ( person.getId().equals(facID) ) 
                                {
                                	
                                    idExists = true;
                                    break;
                                    
                                }
                                
                            }

                            if ( idExists == true ) 
                            {
                            	
                            	System.out.println("");
                            	
                                System.out.println("[ --- Error: Individual with the same ID already exists. Please enter a unique ID. --- ]");
                                
                                System.out.println("");
                                
                            } 
                            else 
                            {
                            	
                                break;
                                
                            }

                        } 
                        while (true);

                        // take faculty rank
                        
                        String facRank;
                        
                        do 
                        {
                        	
                            System.out.print("Enter the rank of the faculty (adjunct/professor): ");
                            facRank = input.nextLine().toLowerCase();

                            if (facRank.equals("adjunct") || facRank.equals("professor")) 
                            {
                                break;
                            } 
                            else 
                            {
                            	
                            	System.out.println("");
                                System.out.println("[ --- Invalid input - please try again. " +
                                        "(rank should either be adjunct or professor, capitalization notwithstanding). --- ]");
                                System.out.println("");
                                
                            }
                            
                        } 
                        while (true);                        
                        
                        // take faculty department
                        
                        String facDept;
                        
                        do {
                        	
                            System.out.print("Enter the department of the faculty member (English/engineering/mathematics): ");
                            facDept = input.nextLine().toLowerCase();

                            if (facDept.equals("mathematics") || facDept.equals("engineering") || facDept.equals("english")) 
                            {
                            	
                                break;
                                
                            } 
                            else 
                            {
                            	
                                System.out.println("[ --- Invalid input - please try again. (department should either be mathematics, engineering, or English, capitalization notwithstanding). --- ]");
                                System.out.println("");
                                
                            }

                        } 
                        while (true);

                        // construct new faculty member
                        
                        Faculty tempFac = new Faculty(facName, facID, facRank, facDept);
                        personList.add(tempFac);
                        
                        System.out.println("");

                        System.out.println("[ --- Faculty information added successfully. --- ]");
                        
                        System.out.println("");

                    } 
                    catch (Exception e) 
                    {
                    	
                        System.out.println("");
                        
                    }
                    break;

                case 2: // enter the information of a student
                    try 
                    {
                    	
                    	System.out.println("");
                        System.out.println("[ --- You chose [2] - Enter the information of a student --- ]");
                        System.out.println("");

                        // take faculty name
                        
                        System.out.print("Enter the name of the student: ");
                        String studName = input.nextLine();
                        
                        // take faculty ID
                        
                        String studID;
                        boolean idExists;

                        do 
                        {
                        	
                            idExists = false;
                            System.out.print("Enter the ID of the faculty (follow format LowercaseLetterLowercaseLetterNumberNumberNumberNumber): ");
                            studID = input.nextLine().toLowerCase();
                            
                            // check if ID properly formatted

                            if (!studID.matches("^[a-z]{2}\\d{4}")) 
                            {
                            	
                            	System.out.println("");
                                System.out.println("Invalid input - please try again (your format may be incorrect).");
                                System.out.println("");
                                continue;
                                
                            }
                            
                            // check if ID already exists in PersonList

                            for (Person person : personList) 
                            {
                            	
                                if ( person.getId().equals(studID) ) 
                                {
                                	
                                    idExists = true;
                                    break;
                                    
                                }
                                
                            }

                            if ( idExists == true ) 
                            {
                            	
                            	System.out.println("");
                                System.out.println("[ --- Error: Individual with the same ID already exists. Please enter a unique ID. --- ]");
                                System.out.println("");
                                
                            } 
                            else 
                            {
                            	
                                break;
                                
                            }

                        } 
                        while (true);

                        // take student GPA
                        
                        double studGPA = 0;
                        
                        do 
                        {
                            
                        	try 
                            {
                            	
                                System.out.print("Enter the student's GPA: ");
                                studGPA = input.nextDouble();
                                break;
                                
                            } 
                            catch (Exception e) 
                            {
                            	
                            	System.out.println("");
                                System.out.println("[ --- Error: Invalid input - enter numeric input only. ---]");
                                input.nextLine();
                                System.out.println("");
                                
                            }
                        	
                        } while ( true );
                        
                        // take student credit hours
                        
                        int studCredHours = 0;
                                                
                        do 
                        {
                            
                        	try 
                            {
                            	
                                System.out.print("Enter the student's credit hours: ");
                                studCredHours = input.nextInt();

                                if ( studCredHours < 0 || studCredHours > 120 ) {
                                	
                                	System.out.println("");
                                	System.out.println("[ --- Error: Credit hours entered must be greater than 0 and less than 120.");
                                	System.out.println("");
                                	
                                }
                                else {
                                	
                                	break;
                                	
                                }                                
                                
                            } 
                            catch (Exception e) 
                            {
                            	
                            	System.out.println("");
                                System.out.println("[ --- Error: Invalid input - enter whole number input only. ---]");
                                System.out.println("");
                                input.nextLine();
                            }
                        	
                        } while ( true );
                        
                        // construct new student member
                        
                        Student tempStud = new Student(studName, studID, studGPA, studCredHours); 
                        personList.add(tempStud);
                        
                        System.out.println("");

                        System.out.println("[ --- Student information added successfully. --- ]");
                        
                        System.out.println("");

                    } 
                    catch (Exception e) 
                    {
                    	
                        System.out.println("");
                        
                    }
                    
                    break;
                	
                case 3: // print tuition invoice for a student
                	
            		/* Students in this college pay $236.45 per credit hour in addition to a $52 administrative fee. 
            		Your code should generate a tuition invoice (a method within the class Student). 
            		Note that students get 25% off total payment if their gpa is greater or equal to 3.85.
            		*/
                	
                	String checkID;
                    boolean studentFound = false;
                    
                    if ( personList.isEmpty() == true ) 
                    {
                    	
                    	System.out.println("");
                    	System.out.println("[ --- Error: There are no personnel in the database able to be printed. --- ]");
                    	System.out.println("");
                    	break;
                    	
                    }
                	
                    do 
                    {
                    	
                        try 
                        {
                        	
                            System.out.print("Enter the student's ID: ");
                            checkID = input.nextLine();

                            studentFound = false;

                            for (Person p : personList) 
                            {
                            	
                                if (p instanceof Student && checkID.equals(p.getId())) 
                                {
                                	
                                    System.out.println("");
                                    p.print();
                                    System.out.println("[ --- Tuition: $" + ((Student) p).tuition() + " (including administrative fee) --- ]");
                                    System.out.println("");
                                    studentFound = true;
                                    break;

                                }
                                
                            }

                            if (!studentFound) 
                            {
                            	
                                System.out.println("");
                                System.out.println("[ --- Error: No such student exists. --- ]");
                                System.out.println("");
                                
                            }
                            
                            if (studentFound) 
                            {
                            	
                            	break;
                            	
                            }

                        } catch (Exception e) 
                        {
                        	
                            System.out.println("");
                            System.out.println("[ --- Error: Invalid input. ---]");
                            input.nextLine();
                            System.out.println("");
                            
                        }
                    } while (true);
                    
                    break;
                    

                case 4: // print faculty information
                	
                    boolean facultyFound = false;
                	
                	if ( personList.isEmpty() == true ) 
                    {
                    	
                    	System.out.println("");
                    	System.out.println("[ --- Error: There are no personnel in the database able to be printed. --- ]");
                    	System.out.println("");
                    	break;
                    	
                    }
                	
                	do 
                    {
                		
                        try 
                        {
                        	
                            System.out.print("Enter the faculty's ID: ");
                            checkID = input.nextLine();

                            facultyFound = false;

                            for (Person p : personList) 
                            {
                            	
                                if (p instanceof Faculty && checkID.equals(p.getId())) 
                                {
                                	
                                    System.out.println("");
                                    p.print();
                                    System.out.println("");
                                    facultyFound = true;
                                    break;

                                }
                                
                            }

                            if (!facultyFound) 
                            {
                            	
                                System.out.println("");
                                System.out.println("[ --- Error: No such faculty exists. --- ]");
                                System.out.println("");
                                
                            }
                            
                            if (facultyFound) 
                            {
                            	
                            	break;
                            	
                            }

                        } catch (Exception e) 
                        {
                        	
                            System.out.println("");
                            System.out.println("[ --- Error: Invalid input. ---]");
                            input.nextLine();
                            System.out.println("");
                            
                        }
                        
                    } while (true);
                	
                    break;


                case 5: // enter the information of a staff member
                	
                	try 
                	{
	                	
                		System.out.println("");
	                    System.out.println("[ --- You chose [5] - Enter the information of a staff --- ]");
	                    System.out.println("");
	                    
	                    // take faculty name
	                    
	                    System.out.print("Enter the name of the staff: ");
	                    String staffName = input.nextLine();
	                	
	                	String staffID;
	                    boolean idExists;
	
	                    do 
	                    {
	                    	
	                        idExists = false;
	                        System.out.print("Enter the ID of the faculty (follow format LowercaseLetterLowercaseLetterNumberNumberNumberNumber): ");
	                        staffID = input.nextLine().toLowerCase();
	                        
	                        // check if ID properly formatted
	
	                        if (!staffID.matches("^[a-z]{2}\\d{4}")) 
	                        {
	                        	
	                        	System.out.println("");
	                            System.out.println("Invalid input - please try again (your format may be incorrect).");
	                            System.out.println("");
	                            continue;
	                            
	                        }
	                        
	                        // check if ID already exists in PersonList
	
	                        for (Person person : personList) 
	                        {
	                        	
	                            if ( person.getId().equals(staffID) ) 
	                            {
	                            	
	                                idExists = true;
	                                break;
	                                
	                            }
	                            
	                        }
	
	                        if ( idExists == true ) 
	                        {
	                        	
	                        	System.out.println("");
	                        	
	                            System.out.println("[ --- Error: Individual with the same ID already exists. Please enter a unique ID. --- ]");
	                            
	                            System.out.println("");
	                            
	                        } 
	                        else 
	                        {
	                        	
	                            break;
	                            
	                        }
	
	                    } 
	                    while (true);
	
	                    // take staff status
	                    
	                    String staffStatus;
	                    
	                    do 
	                    {
	                    	
	                        System.out.print("Enter the status of the faculty (full time/part time): ");
	                        staffStatus = input.nextLine().toLowerCase();
	
	                        if (staffStatus.equals("full time") || staffStatus.equals("part time")) 
	                        {
	                            break;
	                        } 
	                        else 
	                        {
	                        	
	                        	System.out.println("");
	                            System.out.println("[ --- Invalid input - please try again. " +
	                                    "(status should either be \"full time\" or \"professor\", capitalization notwithstanding). --- ]");
	                            System.out.println("");
	                            
	                        }
	                        
	                    } 
	                    while (true);                        
	                    
	                    // take staff department
	                    
	                    String staffDept;
	                    
	                    do {
	                    	
	                        System.out.print("Enter the department of the staff member (English/engineering/mathematics): ");
	                        staffDept = input.nextLine().toLowerCase();
	
	                        if (staffDept.equals("mathematics") || staffDept.equals("engineering") || staffDept.equals("english")) 
	                        {
	                        	
	                            break;
	                            
	                        } 
	                        else 
	                        {
	                        	
	                            System.out.println("[ --- Invalid input - please try again. (department should either be mathematics, engineering, or English, capitalization notwithstanding). --- ]");
	                            System.out.println("");
	                            
	                        }
	
	                    } 
	                    while (true);
	
	                    // construct new faculty member
	                    
	                    Staff tempStaff = new Staff(staffName, staffID, staffStatus, staffDept);
	                    personList.add(tempStaff);
	                    
	                    System.out.println("");
	
	                    System.out.println("[ --- Staff information added successfully. --- ]");
	                    
	                    System.out.println("");
	                    
	                    break;
	                    
                	} catch ( Exception e ) 
                	{
                		
                		System.out.println("[ --- Invalid input, please try again. --- ]");
                		
                	}
                	
                case 6: // print the information of a staff member
                	
                	boolean staffFound = false;
                	
                	if ( personList.isEmpty() == true ) 
                    {
                    	
                    	System.out.println("");
                    	System.out.println("[ --- Error: There are no personnel in the database able to be printed. --- ]");
                    	System.out.println("");
                    	break;
                    	
                    }
                	
                	do 
                    {
                		
                        try 
                        {
                        	
                            System.out.print("Enter the staff's ID: ");
                            checkID = input.nextLine();

                            staffFound = false;

                            for (Person p : personList) 
                            {
                            	
                                if (p instanceof Staff && checkID.equals(p.getId())) 
                                {
                                	
                                    System.out.println("");
                                    p.print();
                                    System.out.println("");
                                    staffFound = true;
                                    break;

                                }
                                
                            }

                            if (!staffFound) 
                            {
                            	
                                System.out.println("");
                                System.out.println("[ --- Error: No such faculty exists. --- ]");
                                System.out.println("");
                                
                            }
                            
                            if (staffFound) 
                            {
                            	
                            	break;
                            	
                            }

                        } catch (Exception e) 
                        {
                        	
                            System.out.println("");
                            System.out.println("[ --- Error: Invalid input. ---]");
                            input.nextLine();
                            System.out.println("");
                            
                        }
                    } while (true);
                	
                    break;

                	
                case 7: // delete a personal entry
                	
                	boolean deleteFound = false;
                	
                	if ( personList.isEmpty() == true ) 
                    {
                    	
                    	System.out.println("");
                    	System.out.println("[ --- Error: There are no personnel in the database able to be deleted. --- ]");
                    	System.out.println("");
                    	break;
                    	
                    }
                	
                	do 
                    {
                		
                        try 
                        {
                        	
                            System.out.print("Enter the personnel's ID: ");
                            checkID = input.nextLine();

                            deleteFound = false;

                            for (Person p : personList) 
                            {
                            	
                                if ( checkID.equals(p.getId()) ) 
                                {
                                	
                                	personList.remove(p);
                                	
                                    System.out.println("");
                                    System.out.println("[ --- Personnel with ID: " + checkID + " has been removed. --- ]");
                                    System.out.println("");
                                    deleteFound = true;
                                    break;

                                }
                                
                            }

                            if (!deleteFound) 
                            {
                            	
                                System.out.println("");
                                System.out.println("[ --- Error: No such faculty exists. --- ]");
                                System.out.println("");
                                
                            }
                            
                            if (deleteFound) 
                            {
                            	
                            	break;
                            	
                            }

                        } catch (Exception e) 
                        {
                        	
                            System.out.println("");
                            System.out.println("[ --- Error: Invalid input. ---]");
                            input.nextLine();
                            System.out.println("");
                            
                        }
                        
                    } while (true);
                	
                    break;

                case 8: // exit program
                	
                	/* 
                	When option 8 is chosen to exist the program, the user is presented with the option to create a report that has the most
                	up-to-date data from the array (or ArrayList list...) saved into a text file (report.txt). 
                	A sample report is provided at the end of this document.
                	6) The final report should print the students sorted by descending gpas or descending names. 
                	For how to sort the students (by gpa or name), you may implement one of the Java’s interfaces Comparable or Comparator. 
                	Where to do that in your code is something that you need to figure out.
                	*/
                	
                	String create;
	            	Integer sort;
                	
                	do 
                    {
                		
                        try 
                        {
                        	
                            System.out.print("Would you like to create a personnel report? (y/n): ");
                            create = input.nextLine();

                            if (create.equalsIgnoreCase("y")) 
                            {
                            	
                				Date thisDate = new Date();
                            	                            	
                                ArrayList<Student> studentList = new ArrayList<>();
                                                                
                                ArrayList<Faculty> facultyList = new ArrayList<>();
                                
                                ArrayList<Staff> staffList = new ArrayList<>();
                            	
                            	for ( Person p : personList ) 
                            	{
                            	
                            		// no employee add loop because employee is not instantiable
                            		
                            		if ( p instanceof Student) 
                            		{
                            			
                            			studentList.add((Student)p);
                            			
                            		}
                            		
                            		if ( p instanceof Faculty) 
                            		{
                            			
                            			facultyList.add((Faculty)p);
                            			
                            		}
                            		
                            		if ( p instanceof Staff) 
                            		{
                            			
                            			staffList.add((Staff)p);
                            			
                            		}
                            		
                            	}
                            	
                            	System.out.println("");
                            	
                            	System.out.print("Sort students by name or GPA, descending? Non-students will always be sorted by order of addition. (enter 0 for name/1 for GPA): ");
                            	
                            	do 
                            	{
                            		
                            		try 
                            		{
                            		
                            			sort = input.nextInt();
                            			
                            			// sort by name
                            			
                            			if ( sort == 0 )
                            			{
                            				
                            				try (PrintWriter PersonnelReport = new PrintWriter("report.txt")) {
                            					
                            					PersonnelReport.println("***********************************************************");
                                				PersonnelReport.println("");
                            					
                            					PersonnelReport.println("Report compiled: " + thisDate);
                                				
                            			        Collections.sort(studentList, Comparator.comparing(Student::getFullName));
                                				                     
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Student Personnel --- ]");
                                				
                                				for ( Student s : studentList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + s.getFullName());
                                					PersonnelReport.println("ID: " + s.getId());
                                					PersonnelReport.println("GPA: " + s.getGpa());
                                					PersonnelReport.println("Credit Hours: " + s.getCredHours());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Faculty Personnel --- ]");
                                				
                                				for ( Faculty f : facultyList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + f.getFullName());
                                					PersonnelReport.println("ID: " + f.getId());
                                					PersonnelReport.println("Rank: " + f.getRank());
                                					PersonnelReport.println("Department: " + f.getDepartment());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Staff Personnel --- ]");
                                				
                                				for ( Staff s : staffList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + s.getFullName());
                                					PersonnelReport.println("ID: " + s.getId());
                                					PersonnelReport.println("Status: " + s.getStatus());
                                					PersonnelReport.println("Department: " + s.getDepartment());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("***********************************************************");
                                				
                                				PersonnelReport.close();
                                				
                                				PersonnelReport.flush();
                                				
                                				System.out.println("");
                                				System.out.println("[ --- Final personnel report (report.txt) created in this directory, go check it out --- ]");
                                				System.out.println("");
                                				System.out.println("[ --- Thanks for using the Personnel Management Program! --- ]");


                            				} catch (FileNotFoundException e) {
                            					// TODO Auto-generated catch block
                            					e.printStackTrace();
                            				}
                            				
                            				continue;
                            			                       				
                            			}
                            			
                            			// sort by GPA
                            			
                            			if ( sort == 1 )
                            			{
                            				
                            				try (PrintWriter PersonnelReport = new PrintWriter("report.txt")) {
                            					
                            					PersonnelReport.println("***********************************************************");
                                				PersonnelReport.println("");
                            					
                            					PersonnelReport.println("Report compiled: " + thisDate);
                                				
                            			        Collections.sort(studentList, Comparator.comparingDouble(Student::getGpa));
                                				                     
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Student Personnel --- ]");
                                				
                                				for ( Student s : studentList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + s.getFullName());
                                					PersonnelReport.println("ID: " + s.getId());
                                					PersonnelReport.println("GPA: " + s.getGpa());
                                					PersonnelReport.println("Credit Hours: " + s.getCredHours());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Faculty Personnel --- ]");
                                				
                                				for ( Faculty f : facultyList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + f.getFullName());
                                					PersonnelReport.println("ID: " + f.getId());
                                					PersonnelReport.println("Rank: " + f.getRank());
                                					PersonnelReport.println("Department: " + f.getDepartment());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("[ --- Staff Personnel --- ]");
                                				
                                				for ( Staff s : staffList ) {
                                					
                                					PersonnelReport.println("");
                                					PersonnelReport.println("Name: " + s.getFullName());
                                					PersonnelReport.println("ID: " + s.getId());
                                					PersonnelReport.println("Status: " + s.getStatus());
                                					PersonnelReport.println("Department: " + s.getDepartment());
                                					
                                				}
                                				
                                				PersonnelReport.println("");
                                				PersonnelReport.println("***********************************************************");
                                				
                                				PersonnelReport.close();
                                				
                                				PersonnelReport.flush();
                                				
                                				System.out.println("");
                                				System.out.println("[ --- Final personnel report (report.txt) created in this directory, go check it out --- ]");
                                				System.out.println("");
                                				System.out.println("[ --- Thanks for using the Personnel Management Program! --- ]");


                            				} catch (FileNotFoundException e) {
                            					// TODO Auto-generated catch block
                            					e.printStackTrace();
                            				}
                            				
                            				continue;
                            			                       				
                            			}
                            			
                            			
                            		} catch ( Exception e ) 
                            		{
                            		
                                    System.out.println("");
                                    System.out.println("[ --- Error: Invalid input. ---]");
                                    input.nextLine(); // consume nextline character
                                    System.out.println("");
                            		
                            		}
                            		
                            	} while (true);
                            	
                            }
                            
                            if (create.equalsIgnoreCase("n")) 
                            {
                            	
                            	System.out.println("");
                            	System.out.println("[ --- Thanks for using the Personnel Management Program! --- ]");
                            	System.out.println("");
                            	
                            	break;
                            	
                            } else {
                        		
                            	System.out.println("");
                            	System.out.println("[ --- Error: Invalid input. --- ] ");
                            	System.out.println("");
                            	
                        	}
                        	
                        } catch (Exception e) 
                        {
                        	
                            System.out.println("");
                            System.out.println("[ --- Error: Invalid input. ---]");
                            input.nextLine(); // consume nextline character
                            System.out.println("");
                            
                        }
                        
                    } while (true);
                	
                	
                    
                default:
                	
                    // do nothing (invalid input messages already embedded into case statements)

            }

        }
        
        input.close();
        
    }
    
}

abstract class Person
{
	
	/* 
	Both classes Student and Employee inherit from the abstract class Person. 
	The abstract class Person has what is common to a Student and an Employee (Faculty or Staff). 
	The class Person must include the signature: public abstract void print();
	The abstract method print is overridden to print the fee invoice for a student and to print the information for a faculty or a staff member. 
	It is left to you (the programmer) to come up with other abstract methods if you see fit (this is optional).
	*/
	
	// fields
	
	public String fullName;
	public String id;
	
	// getters and setters
	
	public String getFullName() 
	{
		
		return fullName;
		
	}

	public void setFullName(String fullName) 
	{
		
		this.fullName = fullName;
		
	}

	public String getId() 
	{
		
		return id;
		
	}

	public void setId(String id) 
	{
		
		this.id = id;
		
	}
	
	// methods
	
	public abstract void print();
	
}

class Student extends Person
{
	
	/*
	The Student class has the private attributes:
	- full name : String
	- id: String
	- gpa: double
	- Number of credit hours currently taken: int
	 */
	
	// fields
	// fullname and id inherited from person
	
	private Double gpa;
	private int credHours;

	// getters/setters
	

	public Double getGpa() 
	{
		
		return gpa;
		
	}

	public void setGpa(Double gpa) 
	{
		
		this.gpa = gpa;
		
	}

	public int getCredHours() 
	{
		
		return credHours;
		
	}

	public void setCredHours(int credHours) {
		
		this.credHours = credHours;
		
	}
	
	// constructors
	
	public Student(String fullName, String id, Double gpa, int credHours) 
	{
		
		this.fullName = fullName;
		this.id = id;
		this.gpa = gpa;
		this.credHours = credHours;
		
	}
	
	// methods
	
	@Override
	public void print() 
	{
		
		System.out.println("[ --- Student information for {" + fullName + "} --- ]");
		System.out.println("[ --- ID: " + id + " --- ]");
		System.out.println("[ --- GPA: " + gpa + " --- ]");
		System.out.println("[ --- Credit Hours: " + credHours + " --- ]");
		
	}
	
	public double tuition()
	{
		
		// pay $236.45 per credit hour in addition to a $52 administrative fee
		
		double creditPrice = 236.45;
		
		double tuition = ( creditPrice * credHours ) + 52;
		
		if ( gpa >= 3.85 ) 
		{
			
			System.out.println("Tuition discounted due to high GPA. ");
			return ( tuition * 0.75 );
			
		}
		
		return tuition;
		
	}
	
}

abstract class Employee extends Person
{
	
	/* 
	The class Employee should also be abstract, and it is supposed to include what is common to a staff and a faculty.
	For faculty and staff, consider these departments only: Mathematics, Engineering and English.
	 */
	
	// fields
	// inherits name, id from person
	
	String department;
	
	// methods
	
	public void print()
	{
		
	}
	
	// getters/setters
	
	public String getDepartment() 
	{
		
		return department;
		
	}
	
	// no constructors required
	
}

class Faculty extends Employee
{
	
	/*
	For a faculty, we need a:
	- full name: String
	- id: String
	- department (mathematics, engineering or english): String
	- Rank (professor or adjunct): String
	*/

	// As for the rank of a faculty, consider these ranks only: Professor and Adjunct.
	// inherits full name, id, department from Employee + getters/setters
	
	// fields
	// inherits full name, id, and department from employee
	
	String rank;
	
	// getters/setters

	public String getRank() 
	{
		
		return rank;
		
	}

	public void setRank(String rank) 
	{
		
		this.rank = rank;
		
	}
	
	// constructors
	
	public Faculty(String Name, String ID, String Rank, String Department) {
		
		this.fullName = Name;
		this.id = ID;
		this.rank = Rank;
		this.department = Department;
		
	}
	
	// methods
	
	@Override
	public void print() 
	{
		
		System.out.println("[ --- Faculty information for {" + fullName + "} --- ]");
		System.out.println("[ --- ID: " + id + " --- ]");
		System.out.println("[ --- Department: " + department + " --- ]");
		System.out.println("[ --- Rank: " + rank + " --- ]");
		
	}
	
}

class Staff extends Employee
{
	
	/*For a staff, we need a:
	- full name: String
	- id: String
	- department (mathematics, engineering or english): String
	- status (part time or full time): String
	*/
	
	// fields
	// inherits full name, id, department from Employee + getters/setters
	
	String status;
	
	// getters/setters

	public String getStatus() 
	{
		
		return status;
		
	}

	public void setStatus(String status) 
	{
		
		this.status = status;
		
	}
	
	public Staff(String Name, String ID, String Rank, String Department) {
		
		this.fullName = Name;
		this.id = ID;
		this.status = Rank;
		this.department = Department;
		
	}
	
	// constructors
	
	public Staff(String status) {
		
		super();
		this.status = status;
		
	}
	
	// methods
	
	@Override
	public void print() 
	{
		
		System.out.println("[ --- Staff information for {" + fullName + "} --- ]");
		System.out.println("[ --- ID: " + id + " --- ]");
		System.out.println("[ --- Department: " + department + " --- ]");
		System.out.println("[ --- Status: " + status + " --- ]");
		
	}
	
}