import java.util.*;

public class DSExercise4 {
    public static void main(String[] args){
        System.out.println("Exercise 4: Employee Management System");
        System.out.println("**************************************");
        Scanner ob = new Scanner(System.in);
        Employees employees = new Employees();

        while(true){
            System.out.println("---ENTER CHOICE---");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Display");
            System.out.println("4. Delete");
            System.out.println("5. EXIT");
            int choice = ob.nextInt();
            ob.nextLine(); // consume newline after int input

            switch(choice){
                case 1:
                    System.out.println("Enter employee id: ");
                    int eid = ob.nextInt();
                    ob.nextLine(); // consume newline

                    System.out.println("Enter name: ");
                    String n = ob.nextLine();

                    System.out.println("Enter position: ");
                    String pos = ob.nextLine();

                    System.out.println("Enter salary: ");
                    int sal = ob.nextInt();
                    ob.nextLine(); // consume newline

                    Employee e = new Employee(eid, n, pos, sal);
                    employees.addEmployee(e);
                    break;

                case 2:
                    System.out.println("Enter employee ID to search: ");
                    int eId = ob.nextInt();
                    ob.nextLine(); // consume newline
                    Employee emp = employees.searchEmployee(eId);
                    if(emp != null){
                        emp.display();
                    } else {
                        System.out.println("Employee not found");
                    }
                    break;

                case 3:
                    employees.display();
                    break;

                case 4:
                    System.out.println("Enter employee ID to delete: ");
                    int empId = ob.nextInt();
                    ob.nextLine(); // consume newline
                    employees.delete(empId);
                    break;

                case 5:
                    System.out.println("---THANK YOU :)---");
                    ob.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}

class Employees {
    List<Employee> employees;

    public Employees(){
        employees = new ArrayList<>();
    }

    public Employees(List<Employee> e){
        employees = e;
    }

    public void addEmployee(Employee e){
        employees.add(e);
    }

    public Employee searchEmployee(int eId){
        for(Employee e : employees){
            if(e.getEmployeeId() == eId){
                return e;
            }
        }
        return null;
    }

    public void display(){
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        for(Employee e: employees){
            e.display();
        }
    }

    public void delete(int eId){
        Iterator<Employee> itr = employees.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.getEmployeeId() == eId) {
                itr.remove();
                System.out.println("Removed successfully");
                return;
            }
        }
        System.out.println("Not found");
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String position;
    private int salary;

    public Employee(int eid, String n, String p, int s){
        employeeId = eid;
        name = n;
        position = p;
        salary = s;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public int getSalary(){
        return salary;
    }

    public void display(){
        System.out.println("ID: " + employeeId + ", Name: " + name +
                ", Position: " + position + ", Salary: " + salary);
    }
}
