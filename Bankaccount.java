import java.util.Scanner;
 class bankaccount2 { 
     Scanner sc = new Scanner(System.in);
    String namecust;
    int accno;
    int typeacc;
    int fixbalance=1000;
   
     int balance;
     public int depositeamount(){
        int deposite;
        System.out.println("ENTER HOW MUCH AMOUNT YOU WANT TO DEPOSITE : ");
        deposite = sc.nextInt();
        balance = balance + deposite;
        displaybalance();
        return balance;
    }
    public void withdrawamount(int b){
        int with;        
          fixbalance=1000;

                    if(b>fixbalance){
                System.out.println("HOW MUCH AMOUNT YOU WANT TO WITHDRAWAL :");
                with = sc.nextInt();
                balance= balance-with;
                displaybalance();
            }
            else{
                System.out.println("YOU CANNOT WITHDRAW AMOUNT ");
            }
        }
    public void updatebalance(){
        int add;
        System.out.println("ENTER AMOUNT TO ADD IN YOUR BALANCE FOR UPDATE : ");
        add= sc.nextInt();
        balance= balance + add;
        System.out.println("YOUR UPDATED BALANCE IS : " + balance); 
    }
    public  void displaybalance(){
        System.out.println("YOUR BALANCE IS : " + balance);
    }
    public  void interest(){
        double p=depositeamount();
        double r=0.04;
        int n=2,t=3;
        double amount = p * Math.pow(1 + (r / n), n * t);
        double cinterest = amount - p;
        System.out.println("Compound Interest after " + t + " years: "+cinterest);
        System.out.println("Amount after " + t + " years: "+amount);
       
    }
    public  int minimumbalance(){
        System.out.println("YOUR BALANCE IS MINIMUM FROM FIXED BALANCE AND YOU WILL GET A PENALTY of amount 250rs : ");
        balance = balance - 250;
        return balance;
        
     }

    
}
class Bankaccount extends bankaccount2{
       public void details(){
        System.out.println("ENTER YOUR TASK FORM FOLLOWING:- ");
        System.out.println("1.DEPOSITE THE AMOUNT ");
        System.out.println("2.WITHDRAW THE AMOUNT ");
        System.out.println("3.UPDATE THE BALANCE ");
        System.out.println("4.DISPLAY THE BALANCE ");
        System.out.println("5.COMPUTE AND DEPOSITE THE INTEREST ");
       }
       public void currentaccount(){
       
        details();
        int choose;
        choose = sc.nextInt();
        switch(choose){
            case 1: depositeamount();
                    break;
            case 2: withdrawamount(balance);
                    break;
            case 3: updatebalance();
                    break;
            case 4: displaybalance();
                    break;    
            case 5:  System.out.println("THE CURRENT ACCOUNT PROVIDE CHEQUE FACILITY WITH NO INTEREST ");
                    break;    
                    default:System.out.println("YOU HAVE ENTERED WRONG OPTION");break;
        }
        
       }  
       public void savingaccount(){
        details();
        int choose;
        choose = sc.nextInt();
        switch(choose){
            case 1: depositeamount();
                    break;
            case 2: withdrawamount(balance);
                    break;
            case 3: updatebalance();
                    break;
            case 4: displaybalance();
                    break;    
            case 5:  interest();
                    break; 
                    default:System.out.println("YOU HAVE ENTERED WRONG OPTION");break;   
        }
        
  }
       
        
        
  
    public static void main(String[] args) {
        char ch='y';
        Bankaccount obj = new Bankaccount();
       
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME : - ");
        obj.namecust = sc.nextLine();
        System.out.println("ENTER YOUR ACCOUNT NUMBER : - ");
        obj.accno = sc.nextInt();
        System.out.println("ENTER YOUR BALANCE IN YOUR ACCOUNT :-  ");
        obj.balance = sc.nextInt();
        do{
        System.out.println("ENTER YOUR ACCOUNT TYPE \n 1.CURRENT ACCOUNT \n 2.SAVING ACCOUNT: - ");
        obj.typeacc = sc.nextInt();
        
        switch(obj.typeacc){
            case 1:obj.currentaccount(); 
                    break;
            case 2:obj.savingaccount();
                    break;

        }
    System.out.println("DO YOU WANT TO CONTINUE (Y/N):" );
    ch=sc.next().charAt(0);
}while(ch=='Y'|| ch=='y');
 System.out.println("MADE BY SARTHAK UPADHYAY" );    
}
}