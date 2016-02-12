/**
 * Tester class that tests all the classes methods
 */
public class Tester {
    
    /**
     * Main method that creates an intern, employee, hourlyEmployee, executive, and and array for StaffMember. To test it puts them in a for loop and also another for loop to class the pay method. 
     */
   public static void main (String[] args){
       
       Intern intern = new Intern("Robin", "Outside", "RobPhon"); 
       Employee employee = new Employee("Batgirl", "Batcomputer", "BatgirlPhone", "22222222", 85000); 
       HourlyEmployee hourlyEmployee = new HourlyEmployee("Aflred", "Wayne Manor", "Alfred Phone", "12435465", 100);
       Executive executive = new Executive("Batman", "Batcave", "Batphone", "836290847", 1000000); 
       StaffMember[] staff = {intern, employee, hourlyEmployee, executive}; 
       
       hourlyEmployee.addHours(50); 
       executive.awardBonus(1000000); 
       
       for(StaffMember person: staff) {
           System.out.println(person + "\n"); 
       }
       
       for(StaffMember person: staff) {
           System.out.println(person.pay()); 
        }
   }
}