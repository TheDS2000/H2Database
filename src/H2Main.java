import java.util.Scanner;

public class H2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		Scanner sc=new Scanner(System.in);
		
		H2JDBC comp =new H2JDBC();
		while(true)
		{
			System.out.println("MENU : ");
			System.out.println("1. Create Student table");
			System.out.println("2. Display Student table");
			System.out.println("3. Insert Into Student table");
			System.out.println("4. Update Student Name in table");
			System.out.println("5. Delete From Student table");
			System.out.println("Enter Your Choice : ");
			int ch=sc.nextInt();
			
			switch(ch)
			{
			case 1:comp.Createtable();
			break;
			case 2:comp.DisplayTable();
			break;
			case 3:comp.InsertTable();
			break;
			case 4:comp.UpdateTable();
			break;
			case 5:comp.DeleteTable();
			break;
			}
			
		}

	}

}

/*Result:
 * MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
2
prep0: select id,name,email,country,password from student
2 : Neha,neha@gmail.com,India,qwe
5 : Dhanashri,dks@gmail.com,India,hello
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
3
INSERT INTO student  (id, name, email, country, password) VALUES  (?, ?, ?, ?, ?);
Enter values to insert : 
Id : 
10
Name : 
Manish
Email : 
manish@Gmail.com
Country : 
USA
Password : 
12as
Inserting records into the table...
prep1: INSERT INTO student  (id, name, email, country, password) VALUES  (?, ?, ?, ?, ?); {1: 10, 2: 'Manish', 3: 'manish@Gmail.com', 4: 'USA', 5: '12as'}
Insert Executed
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
2
prep2: select id,name,email,country,password from student
2 : Neha,neha@gmail.com,India,qwe
5 : Dhanashri,dks@gmail.com,India,hello
10 : Manish,manish@Gmail.com,USA,12as
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
4
update student set name = ? where id = ?;
Enter id to update : 
Id : 
10
Name : 
Manisha
Update Executed
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
2
prep4: select id,name,email,country,password from student
2 : Neha,neha@gmail.com,India,qwe
5 : Dhanashri,dks@gmail.com,India,hello
10 : Manisha,manish@Gmail.com,USA,12as
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
3
INSERT INTO student  (id, name, email, country, password) VALUES  (?, ?, ?, ?, ?);
Enter values to insert : 
Id : 
1
Name : 
hemant
Email : 
hemant@gmail.com
Country : 
UK
Password : 
asdf
Inserting records into the table...
prep5: INSERT INTO student  (id, name, email, country, password) VALUES  (?, ?, ?, ?, ?); {1: 1, 2: 'hemant', 3: 'hemant@gmail.com', 4: 'UK', 5: 'asdf'}
Insert Executed
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
2
prep6: select id,name,email,country,password from student
1 : hemant,hemant@gmail.com,UK,asdf
2 : Neha,neha@gmail.com,India,qwe
5 : Dhanashri,dks@gmail.com,India,hello
10 : Manisha,manish@Gmail.com,USA,12as
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table

MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
5
delete from student where id = ?
Enter id to delete : 
Id : 
2
Deleted record from the table...
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : 
2
prep1: select id,name,email,country,password from student
1 : hemant,hemant@gmail.com,UK,asdf
5 : Dhanashri,dks@gmail.com,India,hello
10 : Manisha,manish@Gmail.com,USA,12as
MENU : 
1. Create Student table
2. Display Student table
3. Insert Into Student table
4. Update Student Name in table
5. Delete From Student table
Enter Your Choice : */
