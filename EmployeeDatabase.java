package regn_2241013031;

class Date{
	int day;
	int month;
	int year;
	Date(int dd, int mm, int yyyy)
	{
		this.day = dd;
		this.month = mm;
		this.year = yyyy;
	}
	int getDay()
	{
		return day;
	}
	int getMonth()
	{
		return month;
	}
	int getYear()
	{
		return year;
	}
	 public String toString()
	{
		return (day+"-"+month+"-"+year);
	}
}


class Address{
	String street;
	String city;
	String state;
	String country;
	Address(String street, String city, String state, String country)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	String getAddress()
	{
		return (street+","+city+","+state+","+country);
	}
	public String toString()
	{
		return (street+","+city+","+state+","+country);
	}
}


class Employee{
	String name;
    int empId;
    double salary;
    Date hireDate;
    String jobPosition;
    String contactNumber;
    Address address;
    
    Employee(String name, int empId, double salary, Date hireDate, String jobPosition, String contactNumber, Address address)
    {
    	this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.hireDate = hireDate;
        this.jobPosition = jobPosition;
        this.contactNumber = contactNumber;
        this.address = address;
    }
    String getJobPosition()
    {
    	return jobPosition;
    }
    public String toString() {
        return "Name: "+name+"\n" +
               "Employee ID: "+empId+"\n" +
               "Salary: "+salary +"\n" +
               "Hire Date: "+hireDate.toString()+"\n" +
               "Job Position: "+jobPosition+"\n" +
               "Contact Number: "+contactNumber+"\n" +
               "Address: "+address.toString()+"\n";
    }

}


class Test
{
	 
	public static void arrangeEmployeeBySalary(Employee e[])
	{
		
		System.out.println("Arranged entire output according to descending order of salary:\n");
		int n = e.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (e[j].salary < e[j+1].salary) 
	            {
	                Employee temp = e[j];
	                e[j] = e[j+1];
	                e[j+1] = temp;
	            }
	        }
	    }
	}
	
	
	
	public static void getEmployeesByJobPosition(Employee e[], String jp)
	{
		System.out.println("Printing Employees who are in the job: "+jp +"\n");
		for(Employee e1:e)
		{
			if(e1.getJobPosition().equalsIgnoreCase(jp))
			{
				System.out.println(e1.toString());
			}
		}
		System.out.println();
	}
	
	
	public static void getEmployeesByHireDate(Employee e[], Date d1, Date d2)
	{
		System.out.println("Getting Employees who have been hired between "+d1.toString()+" and "+d2.toString()+"\n");
		for (Employee employee : e) 
		{
			int hireDate=employee.hireDate.getDay();
			int hireMonth=employee.hireDate.getMonth();
			int hireYear=employee.hireDate.getYear();
			
			if (hireYear < d1.getYear() || hireYear > d2.getYear()) {
	            continue;
	        }
			
			
	        if (hireYear == d1.getYear() && hireMonth < d1.getMonth()) {
	            continue;
	        }
	        
	        if (hireYear == d2.getYear() && hireMonth > d2.getMonth()) {
	            continue;
	        }
	        
	        if (hireYear == d1.getYear() && hireMonth == d1.getMonth() && hireDate < d1.getDay()) {
	            continue;
	        }
	        
	        if (hireYear == d2.getYear() && hireMonth == d2.getMonth() && hireDate> d2.getDay()) {
	            continue;
	        }
	        System.out.println(employee.toString());
		}
		
	}
	
	
	public static int foreignEmployeeCount(Employee e[]) {
	    System.out.println("Foreign Employees Count:\n");
	    int count_Foreign = 0;
	    for (Employee emp : e) {
	        
	        String countryCode = "";
	        int i = 0;
	        while (i < emp.contactNumber.length() && emp.contactNumber.charAt(i) != '-') {
	            countryCode += emp.contactNumber.charAt(i);
	            i++;
	        }
	        if (!countryCode.equals("+91")) {
	            count_Foreign++;
	        }
	    }
	    return count_Foreign;
	}

	
	public static void getEmployeesBySalary(Employee e[], double s1, double s2)
	{
		System.out.println("Getting Employees whose salary lies between "+s1+" and "+s2+"\n");
		for (Employee emp: e)
		{
			if(emp.salary>=s1 && emp.salary<=s2)
			{
				System.out.println(emp.toString());
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		
		Employee employees[]=new Employee[500];
		employees[0] = new Employee("John Doe", 1001, 250000.0, new Date(1, 4, 2022), "Manager", "+91-9876543210", new Address("24B", "Dhanbad", "Jharkhand", "India"));
		employees[1] = new Employee("Jane Smith", 1002, 125000.0, new Date(2, 5, 2022), "Developer", "+91-9876543211", new Address("42D", "Kolkata", "West Bengal", "India"));
		employees[2] = new Employee("Bob Johnson", 1003, 350000.0, new Date(3, 6, 2022), "Manager", "+44-1234567890", new Address("789 Maple St", "Somewhere", "LA", "USA"));
		employees[3] = new Employee("Alice Lee", 1004, 20000.0, new Date(4, 7, 2022), "Designer", "+44-2345678901", new Address("321 Oak St", "Nowhere", "TX", "USA"));
		employees[4] = new Employee("Tom Brown", 1005, 400000.0, new Date(5, 8, 2022), "Manager", "+81-3456789012", new Address("654 Pine St", "Anyplace", "CA", "USA"));
		employees[5] = new Employee("Dean Ambros", 1006, 250000.0, new Date(22, 7, 2023), "Web Developer", "+91-9876543210", new Address("24A", "Ranchi", "Jharkhand", "India"));
		employees[6] = new Employee("Adams smith", 1007, 400000.0, new Date(2, 8, 2023), "Ceo", "+91-9876543211", new Address("72A", "Kolkata", "West Bengal", "India"));
		employees[7] = new Employee("Marshall Mathers", 1008, 35000.0, new Date(8, 6, 2024), "Advisor", "+44-1234567890", new Address("Agony st", "Somewhere", "LA", "USA"));
		employees[8] = new Employee("Rock Lee", 1009, 400000.0, new Date(30, 11, 2022), "President", "+44-2345678901", new Address("83 black St", "Nowhere", "TX", "Uk"));
		employees[9] = new Employee("Tom Cruise", 1010, 340000.0, new Date(5, 12, 2022), "Manager", "+81-3456789012", new Address("3911 zone", "Palace", "Hr", "Mexico"));
		
		
		String[] jobPositions = {"Software Engineer","Data Scientist","Product Manager","UX Designer","Marketing Manager","Sales Representative","Project Manager","Financial Analyst","Business Development Manager","Customer Service Representative","Human Resources Manager","Operations Manager","Account Manager", "IT Support Specialist", "Web Developer","Graphic Designer","Content Writer","Social Media Manager","Legal Counsel","Executive Assistant"};
		String[] names = {"Liam", "Emma", "Noah", "Olivia", "William", "Ava", "James", "Isabella", "Oliver", "Sophia", "Elijah", "Mia", "Benjamin", "Charlotte", "Lucas", "Amelia", "Mason", "Harper", "Ethan", "Evelyn"};
		String[] surnames = {"Johnson", "Wilson", "Smith", "Jones", "Brown", "Davis", "Garcia", "Martinez", "Rodriguez", "Hernandez", "Lopez", "Perez", "Lee", "Kim", "Park", "Lee", "Chang", "Nguyen", "Kim", "Park"};
		String[] contactNumbers = {"+1-55548546657","+44-205558784","+81-3544254455","+86-1087454545","+33-155555555","+91-3055357555","+39-0655555555","+31-205563565","+855-55555555","+91-255555465","+65-65555878","+82-255558484","+52-557874875","+54-115568654115","+55-2155555555","+91-1155556535","+972-25555555","+90-21297841255","+86-215555555","+971-45555555"};

		
		for(int i=10; i<500; i++)
		{
			employees[i]= new Employee(names[(int)(Math.random()*20)]+" "+surnames[(int)(Math.random()*20)], (i+1001),(int)(Math.random()*400000+50000),new Date((int)(Math.random()*30 +1),(int)(Math.random()*12 + 1),(int)(2022+i*Math.random())), jobPositions[(int)(Math.random()*20)], contactNumbers[(int)(Math.random()*20)], new Address("Street no "+i, "City "+i, "State "+i, "Country "+i));
		}
		
		
        arrangeEmployeeBySalary(employees);
        getEmployeesByJobPosition(employees, "Manager");
        getEmployeesByHireDate(employees, new Date(1,4,2022), new Date(31,3,2023));
        int count=foreignEmployeeCount(employees);
        System.out.println("Foreign employees: "+count+"\n");
        getEmployeesBySalary(employees, 150000, 300000);
        
	}
}