import java.util.Scanner;

class atm
{
  String name,userName,password,userName1,password1,transaction=" ",str="";
   int acc_no,tcount=0;
  double balance=100000;
  Scanner sc=new Scanner(System.in);
 
 void registerUser()
  {
                 System.out.print("\t\t\tEnter Your Name:");
	name=sc.next();
	System.out.print("\t\t\tEnter User Name:");
	userName=sc.next();
	System.out.print("\t\t\tEnter Your Password:");
	password=sc.next();
	System.out.print("\n\t\t\tEnter Account Number:");
	acc_no=sc.nextInt();
	System.out.print("\n\t\t"+name+" your account is created successfully....Kindly Login\n");
	
  }
  
  boolean login()
  {     boolean islogin=false;
             while(!islogin){
                 System.out.print("\n\t\t\tEnter User Name:");
	userName1=sc.next();
	if(userName1.equals(userName)) {	
	          System.out.print("\t\t\tEnter Your Password:");
	          password1=sc.next();
	          if(password1.equals(password))
	           {
	              System.out.print("\n\t\t\tLogin Successful\n");
       	               islogin=true;
                            }
                      else{
                                System.out.print("\n\t\t\tInvalid Login ");	
		
	          }
                 }
             else{System.out.print("\n\t\t\tUsername not found....");}
             }
    return islogin;
  }
  
  void withdraw(double amt)
  {
	  if(balance>=amt)
	  { tcount++;
	     balance=balance-amt;
		 System.out.print("\t\t\t"+amt+"is withdrawed successfully....");
		 str="\t\t\t"+amt+"is withdrawed\n";
		 transaction=transaction.concat(str);
		 
	  }
	  else
	  {
	  System.out.print("\t\t\tInsufficient Balance..");
	   
	  }
  }
  
   boolean deposit(double amt)
   {
	   if(amt<=0)
	   { return false;}
       else{            tcount++;
	          balance=balance+amt;
                           System.out.print("\t\t\tAmount "+amt+" deposited.."); 
            	          String str="\t\t\t"+amt+"is deposited\n";
	          transaction=transaction.concat(str);			  
                           return true; 	 
	        }
   }
   
   boolean transfer(double amt,String rec)
   {
    if(balance>=amt)
	  {  tcount++;
	     balance=balance-amt;
		System.out.print("\t\t\t"+amt+"is transfered to "+rec);
		 str="\t\t\t"+amt+"is transfered to "+rec;
		 transaction=transaction.concat(str);
		 return true;
	  }
	  else
	  {
	  System.out.print("\t\t\tInsufficient Balance..");
	   return false;
	  }
   }
   
   void checkBalance()
   {
	  System.out.print("\t\t\tAccount Balance is"+balance);
   }
   
   void transactionHistory()
   {
	  if(tcount==0)
		 System.out.print("\t\t\tNo Transaction");
	  else
		  System.out.print(transaction);
   }
   
   public static void main(String args[])
   {
	   String rname;double amount;
	   System.out.print("\t\t\tWelcome to BOI ATM");
	   System.out.print("\t\t\t\n1.Register\n2.Exit\nEnter your choice..");
	    atm a=new atm(); 
		Scanner sc=new Scanner(System.in);
	   int choice=sc.nextInt();
	   if(choice==1)
	   {
		 
		  a.registerUser();
	   }
	   else{System.exit(0);}
	   
	   while(true)
	   {
		   System.out.print("\t\t\t\n1.LogIn.\n2.Exit.\nEnter your choice..");
		   choice=sc.nextInt();
		   if(choice==1)
		   {
			   if(a.login())
			   {
				 System.out.print("\t\t\t\t\nwelcome "+a.name+" to ATM "); 
				 boolean finish=false;
				 while(!finish)
				 {
				  System.out.print("\t\t\t\n1.Withdraw\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Transaction History\n6.Exit");
				  System.out.print("\nEnter your choice..");
				  choice=sc.nextInt();
				  switch(choice)
				  {
					  case 1:System.out.print("\n\t\t\t Enter amount to withdraw:");
					         amount=sc.nextInt();
							 a.withdraw(amount);
					         break;
					  case 2:System.out.print("\n\t\t\t Enter amount to Deposit:");
					         amount=sc.nextInt();
					         a.deposit(amount);
					         break;
					  case 3:System.out.print("\n\t\t\t Enter Name of Receipent:");
							 rname=sc.next();
					         System.out.print("\n\t\t\t Enter amount to transfer");
					         amount=sc.nextInt();
					         a.transfer(amount,rname); 
					         break;	 
					  case 4:a.checkBalance();
					         break;	 
					  case 5:a.transactionHistory();
					         break;
					  case 6: System.exit(0); 
					       
										
				  }
				  
			          }
			   }
			   
		   }
		   else
		   {
			  System.exit(0); 
		   }
	   }
   }
}