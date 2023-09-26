
import java.util.*;
import java.io.*;


public class HotelManagementSystem{
    //main class
    public static void main(String[] args){
        System.out.println("---------------------------");
        System.out.println("| Welcome to 7 Star Hotel |");
        System.out.println("---------------------------");
        mainMenu();
    }
    //main menu method

    public static void mainMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("1. for Admin");
        System.out.println("2. for Customer");
        System.out.println("0. for Exiting program");
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input. Enter again");
            sc.next();
        }
        int select = sc.nextInt();
        try {
            switch (select) {
                case 1: {
                    boolean pass = false;
                    while(!pass) {
                        String password = "Admin@123";
                        Scanner object = new Scanner(System.in);
                        System.out.println("Enter Password: ");
                        String password2 = object.nextLine();
                        if (password.equals(password2)) {
                            Admin();
                            pass= true;
                        }
                        else{
                            System.out.println("Incorrect Password.");
                            pass = false;
                        }
                    }
                    break;
                }
                case 2: {
                    //for customer
                    customer();
                    break;
                }
                case 0: {
                    System.out.println("Program exited");
                    System.out.println("---------------------------");
                    break;
                }
                //exiting of program
                default:{
                    System.out.println("Invalid Input. Enter Again: ");
                    mainMenu();
                }
                //defualt in case of error
            }
        }
        //try block
        catch (Exception e) {
            System.out.println("Choose between the given options.");
        }
        //exception in case of choosing any other option
    }
    //Main menu

    public static void Admin(){
        Scanner admin = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("0. Main Menu");
        System.out.println("1. View Customer Record");
        System.out.println("2. Delete Customer Record");
        System.out.println("3. Search Customer Record");
        System.out.println("4. View Updated Customer Record");
        System.out.println("5. Update Room Record");
        System.out.println("6. Update Dining Record");
        System.out.println("7. Delete Dining Record");
        //num => Selecting what you want to do
        while(!admin.hasNextInt()){
            System.out.println("Invalid Input.Enter again.");
            admin.next();
        }
        int num = admin.nextInt();
        if(num==1){

            try {
                viewCustomerRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling viewing customer record
        else if(num==0){
            try {
                mainMenu();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling main menu
        else if(num==2){
            try {
                deleteCustomerRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling delete function
        else if(num==3){
            try {
                searchCustomerRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling search record
        else if(num==4){
            try {
                viewUpdatedCustomerRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling view udate records
        else if(num==5){
            try {
                updateRoomRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling update room records
        else if(num==6){
            try {
                updateDiningRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling updtae dining record
        else if(num==7){
            try {
                deleteDiningRecord();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //calling delete dining record
        else{
            System.out.println("Invalid Input. Choose again:");
            Admin();
        }
        //incase of wrong input
    }
    //Admin

    public static void customer() {
        //after entering in code as a customer
        Scanner cstmr = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("0. For Main Menu");
        System.out.println("1. Add Record");
        System.out.println("2. Add Rooms");
        System.out.println("3. Add Dining");
        System.out.println("4. Checkout");
        System.out.println("---------------------------");
        //selecting any of the option
        while(!cstmr.hasNextInt()){
            System.out.println("Invalid Input.Enter Again.");
            cstmr.next();
        }
        //exception
        int select = cstmr.nextInt();
        if(select==0) {
            //calling to add customer record
            try {
                mainMenu();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(select==1) {
            //calling to add customer record
            try {
                addCustomerRecord();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(select==2) {
            //calling to select room
            try {
                room();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(select==3) {
            try {
                //calling to add dining record
                Dining();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else if(select==4) {
            try {
                //checkout funtion call
                checkout();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("invalid Input. Enter again:");
            customer();
        }
        //invalid
    }
    //customer

    public static void addCustomerRecord() throws IOException {
        //name
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your First Name = ");
        String firstName = sc.nextLine();
        int lenName = firstName.length();
        for (int i = 0; i < lenName; i++){
            try {
                if ((firstName.charAt(i) >= 65 && firstName.charAt(i) <= 90) || (firstName.charAt(i) >= 97 && firstName.charAt(i) <= 122)) {
                        continue;
                    } else {
                        System.out.print("Invalid Input. Enter your First name in Alphabets : ");
                        firstName = sc.nextLine();
                        lenName = firstName.length();
                        i=0;
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        //checking last name
        System.out.print("Enter your Last Name = ");
        String lastName = sc.nextLine();
        int lenName2 = lastName.length();
        for (int i = 0; i < lenName2; i++) {
            try {
                if ((lastName.charAt(i) >= 65 && lastName.charAt(i) <= 90) || (lastName.charAt(i) >= 97 && lastName.charAt(i) <= 122)){
                    continue;
                }
                else {
                    System.out.print("Invalid Input. Enter your Last name in Alphabets : ");
                    lastName = sc.nextLine();
                    lenName2 = lastName.length();
                    i=0;
                }
            }
            catch (Exception e) {
                System.out.print(e);
            }
            i=0;
        }
        // Age
        System.out.print("Enter your age = ");
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input. Enter again:");
            sc.next();
        }
        int age = sc.nextInt();
        if (age <= 18) {
            System.out.println("You are invalid for our hotel.");
            mainMenu();
        } else {
            boolean contactNo = false;
            Scanner obj = new Scanner(System.in);
            // contact number
            System.out.print("Enter you Contact number : ");
            String contact = obj.nextLine();
            while(!contactNo){
                int len = contact.length();
                if(len==11) {
                    for (int i = 0; i < contact.length(); i++) {
                        if ((contact.charAt(i) >= 48 && contact.charAt(i) <= 57))
                            continue;
                        else {
                            System.out.print("Invalid Input. Enter your contact number again : ");
                            contact = obj.nextLine();
                            i = 0;
                        }
                    }
                    contactNo= true;
                }else{
                    System.out.println("Invalid Input. Enter contact number again:");
                    contact = obj.nextLine();
                }
            }
            //end of for loop
            // City
            System.out.print("Enter your city = ");
            String city = obj.nextLine();
            int lenCity = city.length();
            for (int i = 0; i < lenCity; i++) {
                if ((city.charAt(i) >= 65 && city.charAt(i) <= 90) || (city.charAt(i) >= 97 && city.charAt(i) <= 122))
                    continue;
                else {
                    System.out.print("Invalid Input. Enter your city name again : ");
                    city = obj.nextLine();
                    i = 0;
                }
            }
            //end of for loop
            // Cnic
            System.out.print("Enter your cnic in this form xxxxx-xxxxxxx-x : ");
            String cnic = obj.nextLine();
            boolean cnicc = false;
            while(!cnicc) {
                int lenCnic = cnic.length();
                if(lenCnic==15){
                    for (int i = 0; i < lenCnic; i++) {
                        if ((cnic.charAt(i) >= 48 && cnic.charAt(i) <= 57)||(cnic.charAt(i)=='-')){
                            if (i == 5 || i == 13) {
                                if (cnic.charAt(i) == '-') {
                                    continue;
                                } else {
                                    System.out.print("Invalid cnic. Enter your cnic in this form xxxxx-xxxxxxx-x : ");
                                    cnic = obj.nextLine();
                                    i=0;
                                }
                            }
                        } else {
                                System.out.print("Invalid cnic . Enter your cnic in this form xxxxx-xxxxxxx-x : ");
                                cnic = obj.nextLine();
                            }
                    }
                    cnicc = true;
                }
                else{
                    System.out.println("3-Invalid cnic.\nEnter your cnic in this form xxxxx-xxxxxxx-x: ");
                    cnic = obj.nextLine();
                }
            }
            // Array for storing customer detail
            String[] customerDetail = new String[6];
            customerDetail[0] = firstName;
            customerDetail[1] = lastName;
            customerDetail[2] = Integer.toString(age);
            customerDetail[3] = contact;
            customerDetail[4] = city;
            customerDetail[5] = cnic;
            // writing customer details in file
            boolean checkingID = false;
            String[] array = new String[100];
            int j=0;
            System.out.println("Enter id");
            String id = obj.nextLine();
            while(!checkingID) {
                File myobj = new File("customer.txt");
                Scanner Reader = new Scanner(myobj);
                while (Reader.hasNextLine()) {
                    String line = Reader.nextLine();
                    array[j] = line;
                    if(array[j].equals(id)){
                        System.out.println("Id already present. Enter again.");
                        id = obj.nextLine();
                        break;
                    }
                    j++;
                }
                Reader.close();
                checkingID = true;
            }
            FileWriter customerfile = new FileWriter("customer.txt", true);
            FileWriter updatedcustomerfile = new FileWriter("updatedCustomer.txt", true);
            PrintWriter fw = new PrintWriter(customerfile);
            PrintWriter ufw = new PrintWriter(updatedcustomerfile);
            fw.write("\n");
            fw.write(id);
            fw.write("\n");
            ufw.write("\n");
            ufw.write(id);
            ufw.write("\n");
            for (int i = 0; i < customerDetail.length; i++) {
                fw.print(customerDetail[i] + " ");
                ufw.print(customerDetail[i] + " ");
            }
            fw.close();
            customerfile.close();
            ufw.close();
            updatedcustomerfile.close();
            System.out.println("Your record has been created");
            //customer records
            customer();
        }

        //calling customer function to return back
    }
    //function to add customer record

    public static void viewCustomerRecord() throws FileNotFoundException {
        String[] array = new String[100];
        //string for reading file elements
        int i = 0;
        System.out.println("---------------------------");
        //File myobj = new File("customer.txt");
        File myobj = new File("updatedCustomer.txt");
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            i++;
        }
        //reading customer record file
        Reader.close();
        //reader func close
        System.out.println("---------------------------");
        Admin();
        //admin to return to main menu
    }
    //viewing customer records

    public static void searchCustomerRecord() throws FileNotFoundException {
        System.out.println("---------------------------");
        int i=0;
        String[] array = new String[100];
        Scanner sc = new Scanner(System.in);
        File myobj = new File("updatedCustomer.txt");
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            array[i] = line;
            i++;
        }
        //reading file
        Reader.close();
        System.out.println("Enter id: ");
        //searching by ID
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input. Enter again: ");
            sc.next();
        }
        int id = sc.nextInt();
        boolean found = false;
        String enterID = Integer.toString(id);
        //converting int to str to match
        for(int k=0;k<i;k++){
            if(array[k].equals(enterID)){
                System.out.println(array[k+1]);
                found = true;
                break;
            }
        }
        //searching in file
        if(!found){
            System.out.println("No data found on this id.");
        }
        //in case of invalid
        System.out.println("---------------------------");
        Admin();
    }
    //searching customer record

    public static void deleteCustomerRecord() throws IOException {
        String[] array = new String[100];
        System.out.println("---------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id : ");
        //taking id to delete record
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input.Enter again.");
            sc.next();
        }
        //searching record in file
        int id = sc.nextInt();
        String id2 = Integer.toString(id);
        int i=0;
        File myobj = new File("updatedCustomer.txt");
        Scanner Reader = new Scanner(myobj);
        //objects to read file
        while(Reader.hasNextLine()){
            String line = Reader.nextLine();
            array[i] = line;
            i++;
        }
        //reading file
        Reader.close();
        boolean found = false;
        FileWriter fw = new FileWriter("updatedCustomer.txt");
        for(int j=0;j<i;j++){
            if(array[j].equals(id2)){
                fw.write(" ");
                System.out.println("Record has been deleted");
                found = true;
                array[j+1] = " ";
            }
            else {
                fw.write(array[j]+"\n");
            }
        }
        //writing records back to file
        fw.close();
        if(!found){
            System.out.println("id not Found.");
            deleteCustomerRecord();
        }
        //in case of no id found
        System.out.println("---------------------------");
        System.out.println("Enter Y for viewing updated records:");
        //to view updated reords
        System.out.println("Enter N for main menu");
        //to main menu
        boolean flag = false;
        while(!flag) {
            String choice = sc.next();
            switch (choice) {
                case "Y": {
                    try {
                        viewUpdatedCustomerRecord();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    flag=true;
                    break;
                }
                case "N": {
                    try {
                        mainMenu();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    flag=true;
                    break;
                }
                default: {
                    System.out.println("Invalid Input. Enter again");
                    flag = false;
                }
            }
        }
        Admin();
    }
    //delete customer record

    public static void viewUpdatedCustomerRecord() throws FileNotFoundException {
        //update records after deletion
        String[] array = new String[100];
        int i = 0;
        System.out.println("---------------------------");
        //reading file
        File myobj = new File("updatedCustomer.txt");
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            i++;
        }
        //printing the records
        Reader.close();
        System.out.println("---------------------------");
        Admin();
        //calling admin func to return back to mai menu
    }
    //to view updated customer records

    public static void room() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        //displaying our room categories
        System.out.println("\nThese are room categories of our Hotel : " +
                "\n1.\tNormal Rooms" +
                "\n2.\tElite Rooms" +
                "\n3.\tLuxury Rooms" +
                "\n0.\tReturn to main menu");
        System.out.println("Which type of room do you want :");
        System.out.print("Enter room type : ");
        //taking user's choice
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input.Enter again.");
            sc.next();
        }
        //inase of any exception
        int roomType = sc.nextInt();
        if (roomType == 0) {
            mainMenu();
        }
        //0 for returning to main menu
        boolean flag = false;
        while (!flag) {
            switch (roomType) {
                case 1:
                    //for selecting normal rooms
                    try {
                        //reading Normal room file
                        File normalRoomFile = new File("NormalRoom.txt");
                        // NR belongs to Normal Room
                        Scanner NR = new Scanner(normalRoomFile);
                        while (NR.hasNextLine()) {
                            String Line = NR.nextLine();
                            System.out.println(Line);
                        }
                        NR.close();
                        customer();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }

                    break;
                case 2:
                    //for selecting elite room
                    try {
                        File eliteRoomFile = new File("EliteRoom.txt");
                        // ER belongs to Elite Room
                        Scanner ER = new Scanner(eliteRoomFile);
                        while (ER.hasNextLine()) {
                            String Line = ER.nextLine();
                            System.out.println(Line);
                        }
                        ER.close();
                        customer();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                    break;
                case 3:
                    //for selecting luxury room
                    try {
                        File LuxuryRoomFile = new File("LuxuryRoom.txt");
                        // NR belongs to Normal Room
                        Scanner LR = new Scanner(LuxuryRoomFile);
                        while (LR.hasNextLine()) {
                            String Line = LR.nextLine();
                            System.out.println(Line);
                        }
                        LR.close();
                        customer();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }

                    break;
                default:
                    //incase of exception default will run
                    System.out.println("Invalid Input.");
                    System.out.print("Enter room type again : ");
                    roomType = sc.nextInt();
            }
        }
    }
    //Room function
    public static void updateRoomRecord() throws IOException {
        Scanner updateRR = new Scanner(System.in);
        //choose in which category admin wants 0 add more accessories
        System.out.println("1. Normal Room");
        System.out.println("2. Elite Room");
        System.out.println("3. Luxury Room");
        System.out.println("0. Main Menu");
        while(!updateRR.hasNextInt()){
            System.out.println("Invalid Input. Enter again");
            updateRR.next();
        }
        //while close
        int roomrecord = updateRR.nextInt();
        if (roomrecord==0) {
            Admin();
        }
        else if(roomrecord==1){
            //mormal room
            String[] roomRecord = new String[100];
            //Reading Normal room file
            int i=0;
            FileReader normalRoom = new FileReader("NormalRoom.txt");
            Scanner normalRead = new Scanner(normalRoom);
            while(normalRead.hasNextLine()){
                String line = normalRead.nextLine();
                roomRecord[i] = line;
                i++;
            } //while ended
            normalRead.close();
            System.out.println("How many items do you want to add:");
            //taking items which will be added
            Scanner sc = new Scanner(System.in);
            int normalRoomItems = sc.nextInt();
            String[] updatedrecord = new String[i+normalRoomItems];

            for(int j=0;j<i;j++){
                updatedrecord[j] = roomRecord[j];
            }//end of for loop
            for(int k=i-1;k<updatedrecord.length;k++){
                String items = sc.nextLine();
                updatedrecord[k] = items;
            }
            //end of for loop
            FileWriter normRoomWriting = new FileWriter("NormalRoom.txt");
            for(int s=0;s<updatedrecord.length;s++){
                normRoomWriting.write(updatedrecord[s]+"\n");
            }
            //writing in file
            normRoomWriting.close();
            Admin();
        }
        else if(roomrecord==2){
            //elite room
            String[] roomRecord = new String[100];
            //Reading elite room file
            int i=0;
            FileReader eliteRoom = new FileReader("EliteRoom.txt");
            Scanner eliteRead = new Scanner(eliteRoom);
            while(eliteRead.hasNextLine()){
                String line = eliteRead.nextLine();
                roomRecord[i] = line;
                i++;
            }
            eliteRead.close();
            System.out.println("How many items do you want to add:");
            //taking items
            Scanner sc = new Scanner(System.in);
            int eliteRoomItems = sc.nextInt();
            String[] updatedrecord = new String[i+eliteRoomItems];
            for(int j=0;j<i;j++){
                updatedrecord[j] = roomRecord[j];
            }
            for(int k=i-1;k<updatedrecord.length;k++){
                String items = sc.nextLine();
                updatedrecord[k] = items;
            }
            FileWriter eliteRoomWriting = new FileWriter("EliteRoom.txt");
            for(int s=0;s<updatedrecord.length;s++){
                eliteRoomWriting.write(updatedrecord[s]+"\n");
            }
            //writing in file
            eliteRoomWriting.close();
            Admin();
        }

        else if(roomrecord==3){
            //luxury room

            String[] roomRecord = new String[100];
            //Reading luxury room file
            int i=0;
            FileReader luxuryRoom = new FileReader("LuxuryRoom.txt");
            Scanner luxuryRead = new Scanner(luxuryRoom);
            while(luxuryRead.hasNextLine()){
                String line = luxuryRead.nextLine();
                roomRecord[i] = line;
                i++;
            }
            luxuryRead.close();
            System.out.println("How many items do you want to add:");
            //items
            Scanner sc = new Scanner(System.in);
            int luxuryRoomItems = sc.nextInt();
            String[] updatedrecord = new String[i+luxuryRoomItems];
            for(int j=0;j<i;j++){
                updatedrecord[j] = roomRecord[j];
            }
            //
            for(int k=i-1;k<updatedrecord.length;k++){
                String items = sc.nextLine();
                updatedrecord[k] = items;
            }
            FileWriter luxRoomWriting = new FileWriter("LuxuryRoom.txt");
            for(int s=0;s<updatedrecord.length;s++){
                luxRoomWriting.write(updatedrecord[s]+"\n");
            }
            //writing code in file
            luxRoomWriting.close();
            Admin();
        }
        else {
            System.out.println("Invalid Input.Enter again:");
            updateRoomRecord();
        }
        //in case of any invalidity
    }
    //update room records

    public static void Dining() {
        //dining
        Scanner sc = new Scanner(System.in);
        System.out.println("\nThese are meal categories of our Hotel : " +
                "\n1.\tBreakfast" +
                "\n2.\tLunch" +
                "\n3.\tDinner" +
                "\n4.\tSweet");
        System.out.println("---------------------------");
        //displaying our menu

        System.out.println("Which type of meal do you want(Buffet) :" +
                "\nPress :" +
                "\n1 for Breakfast" +
                "\n2 for Lunch" +
                "\n3 for Dinner" +
                "\n4 for Sweet" +
                "\n0 for exit to main menu\n");
        //taking hi smeal choice

        System.out.print("Enter meal type : ");
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input. Enter again");
            sc.next();
        }
        int mealType = sc.nextInt();
        boolean flag = false;
        while (!flag) {
            switch (mealType) {
                case 1:
                    //breakfast
                    try {
                        File BreakfastFile = new File("Breakfast.txt");
                        // aa belongs to Breakfast
                        Scanner aa = new Scanner(BreakfastFile);
                        while (aa.hasNextLine()) {
                            String Line = aa.nextLine();
                            System.out.println(Line);
                        }
                        aa.close();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                    customer();
                    break;
                case 2:
                    //lunch
                    try {
                        File LunchFile = new File("Lunch.txt");
                        // bb belongs to Lunch
                        Scanner bb = new Scanner(LunchFile);
                        while (bb.hasNextLine()) {
                            String Line = bb.nextLine();
                            System.out.println(Line);
                        }
                        bb.close();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                    customer();
                    break;
                case 3:
                    //dinner
                    try {
                        File DinnerFile = new File("Dinner.txt");
                        // cc belongs to Normal Room
                        Scanner cc = new Scanner(DinnerFile);
                        while (cc.hasNextLine()) {
                            String Line = cc.nextLine();
                            System.out.println(Line);
                        }
                        cc.close();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                    customer();
                    break;
                case 4:
                    //sweet
                    try {
                        File SweetFile = new File("Sweet.txt");
                        // dd belongs to Sweet
                        Scanner dd = new Scanner(SweetFile);
                        while (dd.hasNextLine()) {
                            String Line = dd.nextLine();
                            System.out.println(Line);
                        }
                        dd.close();
                        flag = true;
                    } catch (Exception e) {
                        System.out.println("File Not Found");
                    }
                    //incase of validity
                    customer();
                    break;
                case 0:
                    //main menu
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Input.");
                    System.out.print("Enter meal type again : ");
                    mealType = sc.nextInt();
                    flag = false;
                    //default

            }
            //switch close
        }
        //while close
    }
    //dining

    public static void updateDiningRecord() throws IOException {
        //displaying menu in which he wanted to update
        Scanner update = new Scanner(System.in);
        System.out.println("0. Main Menu");
        System.out.println("1. BreakFast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("4. Sweet");

        while(!update.hasNextInt()){
            System.out.println("Invalid Input. Enter again");
            update.next();
        }
        //taking user's choice
        int select = update.nextInt();
        switch(select){
            case 0:{
                //for admin
                Admin();
            }
            case 1: {
                //for breakfast
                String[] array = new String[100];
                int i = 0;
                FileReader breakfast = new FileReader("Breakfast.txt");
                Scanner breakfastreader = new Scanner(breakfast);
                while (breakfastreader.hasNextLine()) {
                    String line = breakfastreader.nextLine();
                    array[i] = line;
                    i++;
                }
                //reading breakfast file
                breakfastreader.close();
                //creating new array
                Scanner object = new Scanner(System.in);
                System.out.println("How many items do you want to add: ");
                while(!object.hasNextInt()){
                    System.out.println("Invalid Input. Enter again: ");
                    object.next();
                }
                int num = object.nextInt();
                String[] newArray = new String[i + num];
                //adding elements from old array to new array
                for (int k = 0; k < i; k++) {
                    newArray[k] = array[k];
                }
                //updtaing records
                for(int j = i - 1; j < newArray.length; j++){
                    String items = object.nextLine();
                    newArray[j] = items;
                }
                //writing new data of breakfast int file
                FileWriter breakfast2 = new FileWriter("Breakfast.txt");
                FileWriter breakfast3 = new FileWriter("updatedBreakfast.txt");
                for (int s = 0; s < newArray.length; s++) {
                    breakfast2.write(newArray[s]+"\n");
                    breakfast3.write(newArray[s]+"\n");
                }
                breakfast2.close();
                breakfast3.close();
                //added
                System.out.println("---------------------------");
                updateDiningRecord();
                break;

            }
            case 2:{
                //for lunch
                String[] array2 = new String[100];
                int j=0;
                FileReader lunch = new FileReader("Lunch.txt");
                Scanner lunchReader = new Scanner(lunch);
                while(lunchReader.hasNextLine()){
                    String line = lunchReader.nextLine();
                    array2[j] = line;
                    j++;
                }
                //reading file
                lunchReader.close();
                //creating new array
                Scanner object2 = new Scanner(System.in);
                System.out.println("How many items do you want to add: ");
                while(!object2.hasNextInt()){
                    System.out.println("Invalid Input. Enter again: ");
                    object2.next();
                }
                int num2 = object2.nextInt();
                String[] newArray2 = new String[j+num2];
                //adding elements from old array to new array
                for(int k=0;k<j;k++){
                    newArray2[k] = array2[k];
                }
                for(int l=j-1;l< newArray2.length;l++){
                    String items = object2.nextLine();
                    newArray2[l] = items;
                }
                //writing new data of breakfast int file
                FileWriter lunch2 = new FileWriter("Lunch.txt");
                FileWriter lunch3 = new FileWriter("updatedLunch.txt");
                for(int s=0;s< newArray2.length;s++){
                    lunch2.write(newArray2[s]+"\n");
                    lunch3.write(newArray2[s]+"\n");
                }
                lunch2.close();
                lunch3.close();
                System.out.println("---------------------------");
                updateDiningRecord();
                break;
            }
            case 3:{
                //for dinner
                String[] array3 = new String[100];
                int a=0;
                //reading lunch file and storing in array
                FileReader dinner = new FileReader("Dinner.txt");
                Scanner dinnerReader = new Scanner(dinner);
                while(dinnerReader.hasNextLine()){
                    String line = dinnerReader.nextLine();
                    array3[a] = line;
                    a++;
                }
                //reaing file
                dinnerReader.close();
                //creating new array
                Scanner object3 = new Scanner(System.in);
                System.out.println("How many items do you want to add: ");
                while(!object3.hasNextInt()){
                    System.out.println("Invalid Input. Enter again: ");
                    object3.next();
                }
                int num3 = object3.nextInt();
                String[] newArray3 = new String[a+num3];
                //adding elements from old array to new array
                for(int k=0;k<a;k++){
                    newArray3[k] = array3[k];
                }
                for(int l=a-1;l< newArray3.length;l++){
                    String items = object3.nextLine();
                    newArray3[l] = items;
                }
                //taking new items in array
                FileWriter dinner2 = new FileWriter("Dinner.txt");
                FileWriter dinner3 = new FileWriter("updatedDinner.txt");
                for(int s=0;s<newArray3.length;s++){
                    dinner2.write(newArray3[s]+"\n");
                    dinner3.write(newArray3[s]+"\n");
                }
                //writing new data of breakfast int file
                dinner2.close();
                dinner3.close();
                System.out.println("---------------------------");
                updateDiningRecord();
                break;
            }
            case 4:{
                //for sweet
                String[] array4 = new String[100];
                int x=0;
                //reading lunch file and storing in array
                FileReader sweet = new FileReader("Sweet.txt");
                Scanner sweetReader = new Scanner(sweet);
                while(sweetReader.hasNextLine()){
                    String line = sweetReader.nextLine();
                    array4[x] = line;
                    x++;
                }
                //reading file
                sweetReader.close();
                //creating new array
                Scanner object4 = new Scanner(System.in);
                System.out.println("How many items do you want to add: ");
                int num4 = object4.nextInt();
                String[] newArray4 = new String[x+num4];

                for(int k=0;k<x;k++){
                    newArray4[k] = array4[k];
                }
                //adding elements from old array to new array

                for(int l=x-1;l< newArray4.length;l++){
                    String items = object4.nextLine();
                    newArray4[l] = items;
                }

                FileWriter sweet2 = new FileWriter("Sweet.txt");
                FileWriter sweet3 = new FileWriter("updatedSweet.txt");
                for(int s=0;s<newArray4.length;s++){
                    sweet2.write(newArray4[s]+"\n");
                    sweet3.write(newArray4[s]+"\n");
                }
                //writing new data of breakfast int file
                sweet2.close();
                sweet3.close();
                System.out.println("---------------------------");
                updateDiningRecord();
                break;
            }

            default:{
                //default in case of any validity
                System.out.println("Invalid Input. Enter again: ");
                updateDiningRecord();
            }
        }
        //switch close
    }
    //updating dinner record

    public static void deleteDiningRecord() throws IOException {
        //choose in which you wanna del something
        Scanner update = new Scanner(System.in);
        System.out.println("1. BreakFast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.println("4. Sweet");
        while (!update.hasNextInt()) {
            System.out.println("Invalid Input. Enter again.");
            update.next();
        }
        //taking his choice
        int select = update.nextInt();
        switch (select) {
            case 1: {
                //breakfast
                String[] array = new String[100];
                int i = 0;
                FileReader readingbf = new FileReader("updatedBreakfast.txt");
                Scanner readbf = new Scanner(readingbf);
                while (readbf.hasNextLine()) {
                    String line = readbf.nextLine();
                    array[i] = line;
                    i++;
                    System.out.println(line);
                }
                readbf.close();
                boolean delete = false;
                System.out.println("Enter name you want to del: ");
                Scanner del = new Scanner(System.in);
                String delitem = del.nextLine();
                FileWriter writebf = new FileWriter("updatedBreakfast.txt");
                for (int j = 0; j < i; j++) {
                    if (array[j].equals(delitem)) {
                        array[j] = " ";
                        writebf.write(array[j] + "\n");
                        System.out.println("Item Deleted.");
                        delete = true;
                    } else {
                        writebf.write(array[j] + "\n");
                    }
                }
                if(!delete)
                    System.out.println("No matches found.");
                writebf.close();
                System.out.println();
                System.out.println("Enter Y for viewing updated records:");
                //if wanted to see updated records
                System.out.println("Enter N for main menu");
                Scanner sc = new Scanner(System.in);
                while (!sc.hasNext()) {
                    System.out.println("Invalid Input. Enter again.");
                    sc.next();
                }
                String choice = sc.next();
                boolean choicce = false;
                while (!choicce) {
                    switch (choice) {
                        case "Y": {
                            try {
                                viewUpdatedBreakfast();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce = true;
                            break;
                        }
                        case "N": {
                            try {
                                Admin();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce = true;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Input. Enter again: ");
                            choice = sc.next();
                            choicce = false;
                        }
                    }
                }
            }
            case 2: {
                String[] array2 = new String[100];
                int a = 0;
                FileReader readinglunch = new FileReader("updatedLunch.txt");
                Scanner readlunch = new Scanner(readinglunch);
                while (readlunch.hasNextLine()) {
                    String line = readlunch.nextLine();
                    array2[a] = line;
                    a++;
                    System.out.println(line);
                }
                readlunch.close();
                boolean delete2 = false;
                System.out.println("Enter name you want to del: ");
                Scanner del2 = new Scanner(System.in);
                String delitem2 = del2.nextLine();
                FileWriter writelunch = new FileWriter("updatedLunch.txt");
                for (int j = 0; j < a; j++) {
                    if (array2[j].equals(delitem2)) {
                        array2[j] = " ";
                        writelunch.write(array2[j] + "\n");
                        System.out.println("Item Deleted.");
                        delete2 = true;
                    } else {
                        writelunch.write(array2[j] + "\n");
                    }
                }
                if(!delete2)
                    System.out.println("No matches found.");
                writelunch.close();
                System.out.println();
                System.out.println("Enter Y for viewing updated records:");
                //if wanted to see updated records
                System.out.println("Enter N for main menu");
                Scanner sc2 = new Scanner(System.in);
                while (!sc2.hasNext()) {
                    System.out.println("Invalid Input. Enter again.");
                    sc2.next();
                }
                String choice2 = sc2.next();
                boolean choicce2 = false;
                while (!choicce2) {
                    switch (choice2) {
                        case "Y": {
                            try {
                                viewUpdatedLunch();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        case "N": {
                            try {
                                Admin();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Input. Enter again: ");
                            choice2 = sc2.next();
                            choicce2 = false;
                        }
                    }
                }
            }
            case 3: {
                String[] array2 = new String[100];
                int a = 0;
                FileReader readinglunch = new FileReader("updatedDinner.txt");
                Scanner readlunch = new Scanner(readinglunch);
                while (readlunch.hasNextLine()) {
                    String line = readlunch.nextLine();
                    array2[a] = line;
                    a++;
                    System.out.println(line);
                }
                readlunch.close();
                boolean delete2 = false;
                System.out.println("Enter name you want to del: ");
                Scanner del2 = new Scanner(System.in);
                String delitem2 = del2.nextLine();
                FileWriter writelunch = new FileWriter("updatedDinner.txt");
                for (int j = 0; j < a; j++) {
                    if (array2[j].equals(delitem2)) {
                        array2[j] = " ";
                        writelunch.write(array2[j] + "\n");
                        System.out.println("Item Deleted.");
                        delete2 = true;
                    } else {
                        writelunch.write(array2[j] + "\n");
                    }
                }
                if(!delete2)
                    System.out.println("No matches found.");
                writelunch.close();
                System.out.println();
                System.out.println("Enter Y for viewing updated records:");
                //if wanted to see updated records
                System.out.println("Enter N for main menu");
                Scanner sc2 = new Scanner(System.in);
                while (!sc2.hasNext()) {
                    System.out.println("Invalid Input. Enter again.");
                    sc2.next();
                }
                String choice2 = sc2.next();
                boolean choicce2 = false;
                while (!choicce2) {
                    switch (choice2) {
                        case "Y": {
                            try {
                                viewUpdatedDinner();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        case "N": {
                            try {
                                Admin();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Input. Enter again: ");
                            choice2 = sc2.next();
                            choicce2 = false;
                        }
                    }
                }
            }
            case 4: {
                String[] array2 = new String[100];
                int a = 0;
                FileReader readinglunch = new FileReader("updatedSweet.txt");
                Scanner readlunch = new Scanner(readinglunch);
                while (readlunch.hasNextLine()) {
                    String line = readlunch.nextLine();
                    array2[a] = line;
                    a++;
                    System.out.println(line);
                }
                readlunch.close();
                boolean delete2 = false;
                System.out.println("Enter name you want to del: ");
                Scanner del2 = new Scanner(System.in);
                String delitem2 = del2.nextLine();
                FileWriter writelunch = new FileWriter("updatedSweet.txt");
                for (int j = 0; j < a; j++) {
                    if (array2[j].equals(delitem2)) {
                        array2[j] = " ";
                        writelunch.write(array2[j] + "\n");
                        System.out.println("Item Deleted.");
                        delete2 = true;
                    } else {
                        writelunch.write(array2[j] + "\n");
                    }
                }
                if(!delete2)
                    System.out.println("No matches found.");
                writelunch.close();
                System.out.println();
                System.out.println("Enter Y for viewing updated records:");
                //if wanted to see updated records
                System.out.println("Enter N for main menu");
                Scanner sc2 = new Scanner(System.in);
                while (!sc2.hasNext()) {
                    System.out.println("Invalid Input. Enter again.");
                    sc2.next();
                }
                String choice2 = sc2.next();
                boolean choicce2 = false;
                while (!choicce2) {
                    switch (choice2) {
                        case "Y": {
                            try {
                                viewUpdatedSweet();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        case "N": {
                            try {
                                Admin();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            choicce2 = true;
                            break;
                        }
                        default: {
                            System.out.println("Invalid Input. Enter again: ");
                            choice2 = sc2.next();
                            choicce2 = false;
                        }
                    }
                }
            }
            default: {
                    System.out.println("Invalid Input. Enter again: ");
                    deleteDiningRecord();
            }
        }

    }
    //delete dining record

    public static void viewUpdatedBreakfast() throws FileNotFoundException {
        String[] array = new String[100];
        int i = 0;
        System.out.println("---------------------------");
        File myobj = new File("updatedBreakfast.txt");
        Scanner Reader = new Scanner(myobj);

        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            i++;
        }
        //read in file and sores its items in array
        Reader.close();
        System.out.println("---------------------------");
        Admin();

    }
    //view updated breakfast

    public static void viewUpdatedLunch() throws FileNotFoundException {
        String[] array = new String[100];
        int i = 0;
        System.out.println("---------------------------");
        File myobj = new File("updatedLunch.txt");
        //reading file
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            //storing in array to view file record
            i++;
        }
        Reader.close();
        System.out.println("---------------------------");
        Admin();
    }
    //VIEWING UPDTAED LUNCH

    public static void viewUpdatedDinner() throws FileNotFoundException{
        String[] array = new String[100];
        int i = 0;
        System.out.println("---------------------------");
        File myobj = new File("updatedDinner.txt");
        //reading file
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            //storing in array
            i++;
        }
        Reader.close();
        System.out.println("---------------------------");
        Admin();
    }
    // func of viewing update dinner records//

    public static void viewUpdatedSweet() throws FileNotFoundException {
        String[] array = new String[100];
        int i = 0;
        System.out.println("---------------------------");
        File myobj = new File("updatedSweet.txt");
        Scanner Reader = new Scanner(myobj);
        //reading file
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            System.out.println(line);
            array[i] = line;
            //writing in array to print file record
            i++;
        }
        Reader.close();
        System.out.println("---------------------------");
        Admin();
    }
    //function for viewing updating sweet

    public static void checkout(){
        Scanner input = new Scanner(System.in);
        double[] array = new double[2];
        //counting meal price
        double count;
        //counting room price
        double count2;
        System.out.println("1. BreakFast(700/-)        5. NormalRoom(800 per hour)");
        System.out.println("2. Lunch(2500/-)           6. EliteRoom(2000 per hour)");
        System.out.println("3. Dinner(4000/-)          7. LuxuryRoom(3500 per hour)");
        System.out.println("4. Sweet(1200/-)");
        //displaying info so he can choose
        boolean flag = false;
        System.out.println("Enter your meals info: ");
        while(!flag) {
            while(!input.hasNextInt()){
                System.out.println("Invalid Input.Enter again.");
                input.next();
            }
            //invalid input
            int enter = input.nextInt();
            if (enter == 1) {
                count = 700;
                array[0] = count;
                flag = true;
            } else if (enter == 2) {
                count = 2500;
                array[0] = count;
                flag = true;
            } else if (enter == 3) {
                count = 4000;
                array[0] = count;
                flag = true;
            }else if (enter == 4) {
                count = 1200;
                array[0] = count;
                flag = true;
            } else if (enter == 12) {
                count = 700 + 2500;
                array[0] = count;
                flag = true;
            } else if (enter == 13) {
                count = 700 + 4000;
                array[0] = count;
                flag = true;
            } else if (enter == 23) {
                count = 2500 + 4000;
                array[0] = count;
                flag = true;
            } else if (enter == 21) {
                count = 2500 + 700;
                array[0] = count;
                flag = true;
            } else if (enter == 32) {
                count = 2500 + 4000;
                array[0] = count;
                flag = true;
            } else if (enter == 31) {
                count = 700 + 4000;
                array[0] = count;
                flag = true;
            } else if (enter == 123) {
                count = 700 + 2500 + 4000;
                array[0] = count;
                flag = true;
            }
            else if (enter == 4321) {
                count = 1200 + 4000 + 2500 + 700;
                array[0] = count;
                flag = true;
            }
            else if (enter == 1234) {
                count = 700 + 2500 + 4000 + 1200;
                array[0] = count;
                flag = true;
            }else if (enter == 234) {
                count = 2500 + 4000 + 1200;
                array[0] = count;
                flag = true;
            }else if (enter == 134) {
                count = 700 + 4000 + 1200;
                array[0] = count;
                flag = true;
            }else if (enter == 124) {
                count = 700 + 2500 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 14) {
                count = 700 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 41) {
                count = 700 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 24) {
                count = 2500 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 42) {
                count = 2500 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 34) {
                count = 4000 + 1200;
                array[0] = count;
                flag = true;
            }
            else if (enter == 43) {
                count = 4000 + 1200;
                array[0] = count;
                flag = true;
            }
            else {
                System.out.println("Invalid Input.Enter Again");
                flag = false;
            }
        }
        //end of while loop
        boolean found= false;
        System.out.println("How many hours you stay: ");
        while(!input.hasNextDouble()){
            System.out.println("Invalid Input. Enter again.");
            input.next();
        }
        double hours = input.nextDouble();
        System.out.println("Enter you room info: ");
        while(!found) {
            while(!input.hasNextInt()){
                System.out.println("Invalid Input. Enter again");
                input.next();
            }
            //taking his room info
            int enter2 = input.nextInt();
            if (enter2 == 5) {
                count2 = 800*hours;
                array[1] = count2;
                found = true;
            }
            else if (enter2 == 6) {
                count2 = 2000*hours;
                array[1] = count2;
                found = true;
            }
            else if (enter2 == 7) {
                count2 = 4000*hours;
                array[1] = count2;
                found = true;
            } else {
                System.out.println("Invalid Input Enter again.");
                found = false;
            }
            //in case of invalidity
        }
        //while ended
        double totalBill = array[0] + array[1];
        System.out.println("Total Bill =  "+totalBill);
        System.out.println("For online Payment: ");
        System.out.println("Bank:     61010105943756");
        System.out.println("Jazzcash: 03076588780");
        System.out.println("Thank You for coming.");
        mainMenu();
    }
    //billig function
}
//code ended
