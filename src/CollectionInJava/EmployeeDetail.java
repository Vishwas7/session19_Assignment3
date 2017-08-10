package CollectionInJava;
/**
 *importing class, which are belong from java.util.package;
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
/**
 * 
 * @author Vishwas
 *first i've created a class named EmployeeDetail and main method
 *than created Object of Employee class
 */
public class EmployeeDetail {

    public static void main(String[] args) {
    	System.out.println("Display Employee Detail\n");
	
        Employee empOne = new Employee("Mr.John", "Manager", 80000);
        Employee emplTwo = new Employee("Mr.Nitesh", "Ass.Manager", 50000);
        Employee emplThree = new Employee("Mr.Pradeep", "Area Dept. Manager", 35000);
        Employee emplFour = new Employee("Mr.Vishwas", "Area Dept. Manager", 35000);
        Employee emplFive = new Employee("Mr.Pradeep", "salesmen", 20000);
        
          /**
           * in here creating object of TreeSet and making it generic for Employee
           * and adding Employee to TreeSet by using add()method
           */
        TreeSet<Employee> treeSet = new TreeSet<Employee>(new EmployeeComparator(
                new compareWithName(), new compareWithDesignation()
                ));
       
        treeSet.add(empOne);
        treeSet.add(emplTwo);
        treeSet.add(emplThree);
        treeSet.add(emplFour);
        treeSet.add(emplFive);
        /**
		 * In here using iterator
		 * and than using while loop for checking the value
		 * and call hasNext() which will returns true if there are 
		 * more elements. Otherwise, returns false.
		 */
        Iterator iterator=treeSet.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
    }

}
/**
 * 
 * @author Vishwas
 * created a class compareWithSalary which will compare employee salary
 * to compare salary i've used compare method and to use compare method
 * it must be implements with Comparator Interface  
 *
 */
class compareWithSalary implements Comparator<Employee>{

    @Override
    public int compare(Employee employee1, Employee employee2) {
        if(employee1.getSalary() > employee2.getSalary()){
            return 1;
        }else{
            return -1;
        }
    }
    
}
/**
 * 
 * @author Vishwas
 * created a class compareWithName which will compare with employee names
 * to compare names i've used compare method and to use of compare method
 * it must be implements with Comparator Interface  
 *
 */
class compareWithName implements Comparator<Employee>{
	
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getName().compareTo(employee2.getName());  
    }
    
}
/**
 * 
 * @author Vishwas
 * created a class compareWithDesignation which will compare with employee Designation
 * to compare Designation i've used compare method and to use of compare method
 * it must be implements with Comparator Interface  
 *
 */
class compareWithDesignation implements Comparator<Employee>{
	
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getDesignation().compareTo(employee2.getDesignation());  
    }
    
}
 /**
  * 
  * @author Vishwas 
  * In here creating a class EmployeeComparator
  * it implements  Comparator
  *
  */
class EmployeeComparator implements Comparator<Employee> {
     
    private List<Comparator<Employee>> listComparators;
 
    @SafeVarargs
	public EmployeeComparator(Comparator<Employee>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }
 
    public int compare(Employee emp1, Employee emp2) {
    	//For each loop
        for (Comparator<Employee> comparator : listComparators) {
            int result = comparator.compare(emp1, emp2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
