package Employee;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
class createNew{
	public static final String yellow = "\033[1;33m";
	public static final String reset = "\u001B[0m";

	public static LocalDateTime datetime=LocalDateTime.now();
	public static DateTimeFormatter mydate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static DateTimeFormatter mytime = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static Calendar cal=Calendar.getInstance();
	public static final String date=datetime.format(mydate);
	int count=1;
	void createFile(String str){
		try{
		File f1=new File("D:"+str+".txt");
			if(f1.createNewFile()){
				System.out.println("File "+f1.getName()+" created successfully");		
			}else{
				System.out.println("File already exists in directory.");
			}
		}
		catch(IOException e){
			System.out.println("An unexpected error occured.");
			e.printStackTrace();
		}
	}
	void writeInvent(){
		String filename = "D:Inventory.txt";
        int firstNumber = 0;
        Scanner sc=new Scanner(System.in);
        // Read the last line from the file
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String lastLine = null;

            while ((line = br.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null) {
                String[] parts = lastLine.split("\\|");
                if (parts.length >= 1) {
                    firstNumber = Integer.parseInt(parts[0].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str=null; 
        int count=1,num2;
        double num, num1;
        char chr;
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            int nextNumber = firstNumber + 1;
            while(count>0){
            	// String newLine="S.No\t|\tProduct Code\t|\tProduct Name\t|\tMRP($)\t|\tDiscount(%)\t|\tQuantity";
                System.out.print("Enter products name : ");
				str=sc.nextLine();
				System.out.print("Enter the price ($) of the product : ");
				num=sc.nextDouble();
				System.out.print("Enter the discount (%) to be given : ");
				num1=sc.nextDouble();
				System.out.print("Enter the quantity of the product available : ");
				num2=sc.nextInt();
                String newLine = nextNumber + "\t|\t" + (100+nextNumber) + "\t|\t" + str + "\t|\t" + num + "\t|\t" + num1+ "\t|\t" + num2+"\t|\t";
                writer.println(newLine);
                nextNumber++;
                System.out.println("Do you add more data\nPress Y for yes and N for no");
				chr=sc.next().charAt(0);
				if(chr=='N'||chr=='n'){
					break;
				}else{
					sc.nextLine();
					continue;
				}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Data written successfully!");
	}
	
	void stockUpdate(){
		String fileName = "D:Inventory.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(yellow+line+reset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void writeBillHist(String name,String id,String phon,String amt,String time,String date,String paym){
		String filename = "D:BillHistory.txt";
        int firstNumber = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String lastLine = null;

            while ((line = br.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null) {
                String[] parts = lastLine.split("\\|");
                if (parts.length >= 1) {
                    firstNumber = Integer.parseInt(parts[0].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            int nextNumber = firstNumber + 1;
            String newLine = nextNumber + "\t|\t" + name + "\t|\t" + phon + "\t|\t" + id + "\t|\t" + date + "\t|\t" + time +"\t|\t"+amt+"\t|\t"+paym ;
            writer.println(newLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data written successfully!");
	}
}
class WriteBill extends createNew{
	String id;
	WriteBill(){
		id="Self";
	}
	WriteBill(String str){
		id=str;
	}
	public static final String red2 = "\u001b[41;1m";
	public static final String red = "\033[1;31m";
	public static final String reset = "\u001B[0m";
	public static final String cyan = "\033[1;36m";

	public static LocalDateTime datetime=LocalDateTime.now();
	public static DateTimeFormatter mydate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static DateTimeFormatter mytime = DateTimeFormatter.ofPattern("HH:mm:ss"); 
	public static Scanner sc=new Scanner(System.in);
	void create(){
		String name= name();
		Random rand=new Random();
		String phone=phonenumb();
		String filePath = "D:"+name+".txt";
		int a=42;
		try(FileWriter writer=new FileWriter(filePath, true)){
			writer.write("\tSupermarket Billing System\n\t\tGroup 5 CSE-C\n\tThe NorthCap University\n\t\tSector-23, Gurgaon\n\tGSTIN: 07DDJGD9815J5FW");
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("\t\t[RETAIL INVOICE]");
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("\t\tIn Store Purchase");
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("Bill No : B3/2226/0147"+rand.nextInt(20));
			writer.write("\n");
			writer.write("Trans No : 3798"+rand.nextInt(100));
			writer.write("\n");
			writer.write("Billed By : "+id);
			writer.write("\n");
			String date=datetime.format(mydate);
			String time=datetime.format(mytime);
			writer.write("Date : "+date+"  "+time);
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("SNo Product\t\tQty\tRate Discnt\tAmt");
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			int count=1;
			char ch;
			double total=0;
			DecimalFormat df = new DecimalFormat("#.##");
			while(count>0){
				int it=item();
				String str=itname(it);
				System.out.print("You choose "+str+", enter it's quantity : ");
				int quan=0;
				double sum=0;
				while(quan==0){
					quan=sc.nextInt();
					if(quan<0){
						try{
							throw new NegativeArraySizeException("Negative quantity");
						}
						catch(NegativeArraySizeException e){
							System.out.println(red+e+reset);
							System.out.println(red+"Quantity can't be negative\n Enter a valid number"+reset);
							quan=0;
						}
					}
				}
				int avail=itnum(it);
				if(quan>avail){
					try{
						throw new IndexOutOfBoundsException("Extra Selected");
					}
					catch(IndexOutOfBoundsException e){
						System.out.println(red+e+reset);
						System.out.println(red+"More than quantity available selected\nQantity is set to maximum units "+avail+" available"+reset);
						quan=avail;
					}
				}
				avail=avail-quan;
				changevalue(it,avail);
				double price=itprice(it);
				double perc=itdisc(it);
				double disc=price*(perc)/100;
				sum=quan*(price-disc);
				total=total+sum;
				writer.write(count+" "+str+"\t");
				count++;
				if(str.length()<6){
					writer.write("\t");
				}
				String sum1=df.format(sum);
				writer.write(quan+"\t"+price+"\t"+disc+"\t"+sum1+"\n");
				System.out.println("Do you want to buy more stuff\nPress Y for Yes or N for No.");
				ch=sc.next().charAt(0);
				if(ch=='n'||ch=='N'){
					break;
				}
			}
			String total1 = df.format(total);
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("TOTAL\t\t"+total1+"\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("Code\t\tBase Amt\t\tGST Amt\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			double gst=(total-(total/118*100))/2;
			double base1=total-2*gst;
        	String csgst = df.format(gst);
        	String base=df.format(base1);
			writer.write("CGST\t\t"+base+"\t\t"+csgst+"\nSGST\t\t"+base+"\t\t"+csgst+"\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\nAmount Including GST:\t"+total1+"\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			String pay=paym(total1);
			writer.write("Manual "+pay+" payment\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			for(int i=0;i<a;i++){
				writer.write("-");
			}
			writer.write("\n");
			writer.write("Thank you for shopping with us.");
			writer.close();
			writeBillHist(name,id,phone,total1,time,date,pay);
		}catch(IOException e){
			System.out.println("An error occurred while writing to the file "+e);
		}
	}
	public static void history(){
		String fileName = "D:BillHistory.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }		
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public static void changevalue(int num,int num1){
		 String filePath = "D:Inventory.txt";
	    num++;
	    String newValue = Integer.toString(num1);
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(filePath));
	        BufferedWriter writer = new BufferedWriter(new FileWriter("D:Bill.txt"));

	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] columns = line.split("\\|");
	            String productCode = columns[1].trim();

	            if (productCode.equals(Integer.toString(num))) {
	                columns[columns.length - 1] = " " + newValue.trim();
	            }

	            String modifiedLine = String.join(" | ", columns);
	            writer.write(modifiedLine);
	            writer.newLine();
	        }

	        reader.close();
	        writer.close();

	        File outputFile = new File("D:Bill.txt");
	        File inputFile = new File(filePath);
	        outputFile.renameTo(inputFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public static String phonenumb(){
		System.out.print("Enter your phone number : ");
		String str=sc.nextLine();
		if(str.length()==10){
            for (char c : str.toCharArray()) {
	            if (!Character.isDigit(c)) {
	                System.out.println("The number contains some character's in between.\n"+red+"Enter a valid number"+reset);
	                phonenumb();
	            }
        	}
        }
        else{
            System.out.println("The number is short of digits\n"+red+"Enter a valid number"+reset);
            sc.nextLine();
            phonenumb();
        }
        return str;
	}
	public static String paym(String amt){
		System.out.println("Your total is $"+amt+" including GST\nSelect a mode of payment\n1. Credit Card\\Debit Card\n2. UPI ID");
		int choice=0;
		String str="Madhur";
		do{
			choice=sc.nextInt();
			switch (choice) {
				case 1: str="Card";
					creddeb();
					break;
				case 2: str="UPI";
					upiId();
					break;
				default: choice=0;
						System.out.println(red+"Enter a valid number"+reset);
						break;
			}
		}while(choice==0);
		return str;
	}
	public static void creddeb(){
		int choice=0;
		Random rand=new Random();
		System.out.print("Enter your card number : ");
		while(choice==0){
			String num=sc.nextLine();
			if(num.length()<10){
				choice=0;
				System.out.println(red+"Number you entered is not valid"+reset);
			}
			else{
				choice=1;
			}	
		}
		int a=(rand.nextInt(3)+1);
		String str="Madhur";
		switch (a) {
			case 1: str="VISA";
				break;
			case 2: str="RuPay";
				break;
			case 3: str="MasterCard";
				break;
			case 4: str="AmericanExpress";
				break;
		}
		System.out.println("Your card is identified as "+cyan+str+reset+" card");
		String phone=phonenumb();
		System.out.print("Enter card holder's name : ");
		String name=sc.nextLine();
		System.out.print("Enter your card's expiration in MM/YY format : ");
		int count1=0;
		String expir="Madhur";
		while(count1==0){
			expir=sc.nextLine();
			DateTimeFormatter mydate1 = DateTimeFormatter.ofPattern("MM");
			String month=datetime.format(mydate1);
			DateTimeFormatter mydate2 = DateTimeFormatter.ofPattern("YYYY");
			String year=datetime.format(mydate2);
			int mon=0,yea=0;
			try {
				mon = Integer.parseInt(month);
	        } catch (NumberFormatException e) {
	            System.out.println(red+"Invalid input. The string does not represent a valid integer."+reset);
	        }
	        try {
				yea = Integer.parseInt(year);
	        } catch (NumberFormatException e) {
	            System.out.println(red+"Invalid input. The string does not represent a valid integer."+reset);
	        }
			if (!expir.matches("\\d{2}/\\d{2}")) {
				System.out.println(red+"Invalid input format."+reset+" Please enter in MM/YY format.");
				count1=0;
			}		
			else{
				char c=expir.charAt(0);
				int e=c-'0';
				c=expir.charAt(1);
				int b=c-'0';
				e=10*e+b;
				c=expir.charAt(3);
				b=c-'0';
				c=expir.charAt(4);
				int d=c-'0';
				b=10*b+d;
				if(e>mon||b>(yea%100)){
					count1=1;
						
				}else{
					count1=0;
					System.out.println("The card is expired");
				}
			}
		}
		int count2=0;
		String cvv="Madhur";
		while(count2==0){
			System.out.print("Enter your CVV : ");
			cvv=sc.nextLine();
			if(cvv.length()!=3){
				count2=0;
				System.out.println(red+"Something is wrong try again"+reset);
			}
			else{
					for (char c : cvv.toCharArray()) {
			            if (!Character.isDigit(c)) {
			                System.out.println(red+"Something is wrong with format"+reset);
			                count2=0;
			            }
			            else{
			            	count2=1;
			            }
	        		}
       		}
		}
		System.out.println("Please wait while we check your payment's status");
       		for(int i=0;i<1000;i++){
       			for(int j=0;j<1000;j++){

       			}
       		}
		System.out.println("Your payment was successful\nThank You for shopping with us");
	}
	public static void upiId(){
		Random rand=new Random();
		System.out.print("Enter your phone number : ");
		String phon=phonenumb();
		System.out.print("Enter your UPI ID : ");
		String uid=sc.nextLine();
		int num=(rand.nextInt(20)+30);
		for(int i=59;i>num;i--){
			System.out.print("Please wait while we verify your payment\nTime before payment fails : "+i+"s\n");
			try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println("Your payment was successful\nThank you for waiting");
	}
	public static int itnum(int num){
		String filePath = "D:Inventory.txt";
		String lastNumber="Madhur";
		num++;
		int lineNumber = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
           while ((line = reader.readLine()) != null) {
                if (lineNumber >= 2) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 6) {
                        lastNumber = parts[5].trim();
                        if(lineNumber==num){
                        	break;
                        }
                    }
                }
                lineNumber++;
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        int item=0, count=(int)Math.pow(10,lastNumber.length());
        for(int i=0;i<lastNumber.length();i++){
        	count=count/10;
        	char ch=lastNumber.charAt(i);
        	switch(ch){
        		 case '0':num=0;
	            break;
		        case '1':num=1;
		            break;
		        case '2':num=2;
		            break;
		        case '3':num=3;
		            break;
		        case '4':num=4;
		            break;
		        case '5':num=5;
		            break;
		        case '6':num=6;
		            break;
		        case '7':num=7;
		            break;
		        case '8':num=8;
		            break;
		        case '9':num=9;
		            break;
        	}
        	item=item+num*count;
        }
        return item;
	}
	public static double itdisc(int num){
		String filePath = "D:Inventory.txt";
		double number=0;
		num++;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1; // Track the line number
            while ((line = br.readLine()) != null) {
                if (lineNumber >= 2) { // Start reading from line number 2
                    String[] columns = line.split("\\|");
                    if (columns.length >= 5) {
                        String numberString = columns[4].trim();
                        try {
                            number = Double.parseDouble(numberString);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format at line " + lineNumber + ": " + numberString);
                        }
                        if(lineNumber==num){
                        	break;
                        }
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
	}
	public static double itprice(int num){
		String filePath = "D:Inventory.txt";
		double number=0;
		num++;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1; // Track the line number
            while ((line = br.readLine()) != null) {
                if (lineNumber >= 2) { // Start reading from line number 2
                    String[] columns = line.split("\\|");
                    if (columns.length >= 4) {
                        String numberString = columns[3].trim();
                        try {
                            number = Double.parseDouble(numberString);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format at line " + lineNumber + ": " + numberString);
                        }
                        if(lineNumber==num){
                        	break;
                        }
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;
	}
	public static String itname(int num){
		String filename = "D:Inventory.txt";
		String stringData="Madhur";
		num++;
        int lineNumber = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (lineNumber >= 2) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        stringData = parts[2].trim();
                        if(lineNumber==num){
                        	break;
                        }
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(stringData);
        return stringData;
	}
	public static int item(){
		String filename = "D:Inventory.txt";

        int lineNumber = 1;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (lineNumber >= 2) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        int firstNumber = Integer.parseInt(parts[0].trim());
                        String stringData = parts[2].trim();
                        System.out.println(firstNumber + ": " + stringData);
                    }
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int num=0;
        lineNumber=lineNumber-2;
        System.out.print("Choose the item you want to buy : ");
        while(num==0){
        	num=sc.nextInt();
        	if(num<1||num>lineNumber){
        		System.out.println("Choose the item from given list");
        		num=0;
        	}	
        }
        return num;
    }
    public static String name(){
    	System.out.print("Enter Customer's Name : ");
    	String name=sc.nextLine();
    	return name;
    }
}
class Schedule{
	public static final String reset = "\u001B[0m";
    public static final String red = "\033[1;31m";
    public static final String green = "\033[1;32m";
    public static final String cyan = "\033[1;36m";
    public static final String yellow = "\033[1;33m";
    public static final String white = "\033[1;37m";
    public static final String purple = "\033[1;35m";
    public static final String blue = "\033[1;34m";
    public static final String black = "\033[1;30m";

    public static final String black1 = "\u001b[40;1m";
	public static final String red2 = "\u001b[41;1m";
	public static final String green2 = "\u001b[42;1m";
	public static final String yellow2 = "\u001b[43;1m";
	public static final String blue2 = "\u001b[44;1m";
	public static final String magenta2 =  "\u001b[45;1m";
	public static final String cyan2 = "\u001b[46;1m";
	public static final String white2 = "\u001b[47;1m";

	public static  LocalDate datetime = LocalDate.now();
    public static DateTimeFormatter mydate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	void display(String str){
		Random rand=new Random();
		System.out.println("Hi! "+str+" your next 5 days schedule");
		LocalDate curr=LocalDate.now();
			for(int i=0;i<7;i++){
	        System.out.print(purple+"- "+reset);
	    	}
			System.out.print("Weekly Schedule: ");
			for(int i=0;i<7;i++){
	    	    System.out.print(purple+"- "+reset);
	    	}
	    	System.out.println();
	    	for(int i=0;i<33;i++){
	    	    System.out.print(purple+"-"+reset);
	    	}
	    	System.out.println();
	    	for(int i=0;i<5;i++){
		    System.out.print(purple+"|\t"+reset);
		    LocalDate next=curr.plusDays(i);
		    LocalDate next1=datetime.plusDays(i);
			DayOfWeek day=next.getDayOfWeek();
			String date=next1.format(mydate);
			System.out.print(yellow2+day+reset);
			System.out.print(purple+"|\t"+reset);
			System.out.print("9am to 5pm");
			System.out.println(purple+"|\t"+reset);
			System.out.print(purple+"|\t"+reset);
			System.out.print(date);
			System.out.print(purple+"|\t"+reset);
			System.out.print("Counter - "+rand.nextInt(20));
			System.out.println(purple+"|\t"+reset);
			for(int j=0;j<33;j++){
		        System.out.print(purple+"-"+reset);
		    }
		    System.out.println();
	    }
	}
}
class Main{
	public static final String reset = "\u001B[0m";
    public static final String red = "\033[1;31m";
    public static final String green = "\033[1;32m";
    public static final String cyan = "\033[1;36m";
    public static final String yellow = "\033[1;33m";
    public static final String white = "\033[1;37m";
    public static final String purple = "\033[1;35m";
    public static final String blue = "\033[1;34m";
    public static final String black = "\033[1;30m";
    public static final String magenta = "\u001b[35;1m";
    public static final String red1 = "\u001b[41m";

	public static LocalDateTime datetime=LocalDateTime.now();
	public static DateTimeFormatter mydate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	public static DateTimeFormatter mytime = DateTimeFormatter.ofPattern("HH:mm:ss");
	public static final String date=datetime.format(mydate);
	public static Calendar cal=Calendar.getInstance();
	public static Random rand=new Random();

	public static void Super(){
		Scanner sc=new Scanner(System.in);
		Schedule obj=new Schedule();
		createNew obj1=new createNew();
		// String str=sc.nextLine();
		// obj1.createFile(str);
		System.out.println(date);
		System.out.println(cal.getTime());
		int cout=0;
		while(cout<3){
			if(cout>0){
				System.out.println(green+""+(3-cout)+" Tries remanining"+reset);
			}
			cout++;
			System.out.print("Enter your "+blue+ "Employee ID : "+reset);
			
		String userID=sc.nextLine();
		System.out.print("Enter your password : ");
		String password=sc.nextLine();
		int num=0;
		if(userID.equals("admin")&&password.equals("admin")){
			System.out.println("You logged in "+(rand.nextInt(20)+50)+" times as ADMIN");
			cout=4;
			WriteBill bill=new WriteBill();
			do{
				System.out.println(magenta+"Choose one option"+reset+"\n1. Check Bill Data\n2. Update Stock\n3. Add new stock"+red1+"\n4. Log Out"+reset);
			num=sc.nextInt();	
			switch(num){
			case 1: bill.history();
					break;
			case 2: bill.item();
					System.out.println("Choose the item you want to update");
					int it=sc.nextInt();
					String str=bill.itname(it);
					System.out.print("You choose "+str+", enter it's new stock : ");
					int new1=sc.nextInt();
					bill.changevalue(it,new1);
					System.out.println("Data was updated successfully");
					break;
			case 3: obj1.writeInvent();
					break;
			case 4: System.out.println(yellow+"....Logging out...."+reset);
					break;
			default: System.out.println(red+"\nEnter valid number"+reset);
			}
		}while(num!=4);
		}
		else if(userID.equals("Madhur")&&password.equals("Madhur")){
			System.out.println("Hi! "+userID);
			cout=4;
			do{
				System.out.println(magenta+"Choose one option\n"+reset+"1. Check your Schedule\n2. Billing"+red1+"\n3. Log Out"+reset);
			num=sc.nextInt();	
			switch(num){
			case 1: obj.display(userID);
					break;
			case 2: WriteBill bill=new WriteBill(userID);
					bill.create();
					break;
			case 3: System.out.println(yellow+"....Logging out...."+reset);
					break;
			default: System.out.println(red+"\nEnter valid number"+reset);
			}
		}while(num!=3);
		}
		else if(userID.equals("Lakshay")&&password.equals("Lakshay")){
			System.out.println("Hi! "+userID);
			cout=4;
			do{
				System.out.println(magenta+"Choose one option\n"+reset+"1. Check your Schedule\n2. Billing"+red1+"\n3. Log Out"+reset);
			num=sc.nextInt();	
			switch(num){
			case 1: obj.display(userID);
					break;
			case 2: WriteBill bill=new WriteBill(userID);
					bill.create();
					break;
			case 3: System.out.println(yellow+"....Logging out...."+reset);
					break;
			default: System.out.println(red+"\nEnter valid number"+reset);
			}
		}while(num!=3);
		}
		else if(userID.equals("Saarmeen")&&password.equals("Saarmeen")){
			System.out.println("Hi! "+userID);
			cout=4;
			do{
				System.out.println(magenta+"Choose one option\n"+reset+"1. Check your Schedule\n2. Billing"+red1+"\n3. Log Out"+reset);
			num=sc.nextInt();	
			switch(num){
			case 1: obj.display(userID);
					break;
			case 2: WriteBill bill=new WriteBill(userID);
					bill.create();
					break;
			case 3:	System.out.println(yellow+"....Logging out...."+reset);
					break;
			default: System.out.println(red+"\nEnter valid number"+reset);
			}
		}while(num!=3);
		}
		else if(userID.equals("Leepakshi")&&password.equals("Leepakshi")){
			System.out.println("Hi! "+userID);
			cout=4;
			do{
				System.out.println(magenta+"Choose one option\n"+reset+"1. Check your Schedule\n2. Billing"+red1+"\n3. Log Out"+reset);
			num=sc.nextInt();	
			switch(num){
			case 1: obj.display(userID);
					break;
			case 2: WriteBill bill=new WriteBill(userID);
					bill.create();
					break;
			case 3: System.out.println(yellow+"....Logging out...."+reset);
					break;
			default: System.out.println(red+"\nEnter valid number"+reset);
			}
		}while(num!=3);
		}
		else{
			System.out.println("Invalid user ID or password.");
		}
	}
	}
}
public class EmployeeSchedule{
	public static final String reset = "\u001B[0m";
    public static final String red = "\033[1;31m";
    public static final String green = "\033[1;32m";
    public static final String cyan = "\033[1;36m";
    public static final String yellow = "\033[1;33m";
    public static final String white = "\033[1;37m";
    public static final String purple = "\033[1;35m";
    public static final String blue = "\033[1;34m";
    public static final String black = "\033[1;30m";
    public static final String magenta = "\u001b[35;1m";
    public static final String red1 = "\u001b[41m";

	public static void main(String[] args){
		Main obj=new Main();
		WriteBill bill=new WriteBill();
		createNew open=new createNew();
		System.out.println(green+"Supermarket Billing System"+reset+cyan+"\nGroup - 5"+reset+yellow+"\nCSE-C"+reset);
		int num=0;
		do{
			System.out.println(blue+"Choose An Option\n"+reset+magenta+"1. Employee Login\n2. Self-Checkout\n3. Stock-Checking\n4. Exit"+reset);
			Scanner sc=new Scanner(System.in);
			num=sc.nextInt();
			switch (num) {
				case 1: obj.Super();
					break;
				case 2: bill.create();
						break;
				case 3:	open.stockUpdate();
						break;
				case 4: System.out.println(red+"Exiting.."+reset);
						break;
				default: System.out.println("Enter a valid number");
						break;
			}
		}while(num!=4);
	}
}
