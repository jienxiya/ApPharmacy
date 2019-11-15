package appharmacy3;

import java.util.ArrayList;
import java.util.Scanner;

public class Pharmacy {

    private String pharmacyName;
    private String location;

    static ArrayList<Medicine> medicines = new ArrayList<>();
    static ArrayList<User> accounts = new ArrayList<>();
    Scanner strInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);
    Pharmacist mj = new Pharmacist("MJ", "mj@gmail.com", 20, "123");

    //constructors
    public Pharmacy() {

    }

    public Pharmacy(String pharmacyName, String location) {
        this.pharmacyName = pharmacyName;
        this.location = location;
    }

    //setters & getters
    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<User> getAccounts() {
        return accounts;
    }

    //behaviors
    public void addMedicine(Medicine med) {
        this.medicines.add(med);
    }

    public void addUser(User user) {
        this.accounts.add(user);
    }

    public void viewAvailableMedicine() {
        System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", "ID", "|", "Generic name", "|", "Brand Name", "|", "Medicine Type", "|", "Price", "|", "Stock", "|");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.getMedicines().size(); i++) {
            System.out.printf("%10s %5s %30s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", this.getMedicines().get(i).getMedID(), "|", this.getMedicines().get(i).getGenericName(), "|", this.getMedicines().get(i).getBrandName(), "|", this.getMedicines().get(i).getType(), "|", this.getMedicines().get(i).getPrice(), "|", this.getMedicines().get(i).getMedStock(), "|");
        }
    }

    public void updateMedicineStock(Medicine med) {
        System.out.print("Remove Medicine(Medicine ID): ");
        int uMed = intInput.nextInt();
        for(int i = 0; i < this.medicines.size(); i++){
            if (this.medicines.get(i).getMedID() == uMed) {
                System.out.println("Current Stock of " + this.medicines.get(i).getBrandName() + " is: " + this.medicines.get(i).getMedStock());
                System.out.println("Update Stock (quantity): ");
                int d = intInput.nextInt();
                this.medicines.get(i).setMedStock(d);
            } 
        }
    }

    public void removeMedicine(Medicine med) {
        System.out.print("Remove Medicine(Medicine ID): ");
        int rMed = intInput.nextInt();
        for (int i = 0; i < this.medicines.size(); i++) {
            if (this.medicines.get(i).getMedID() == rMed) {
                this.medicines.remove(this.medicines.get(i));
                System.out.println("You remove " + this.medicines.get(i).getBrandName() + " to the list.");
            }
        }
    }

    public Pharmacist getMj() {
        return mj;
    }

    public void populateMedicine(Pharmacy a) {
        //Medicine for Headache
        a.addMedicine(new Medicine(1, "Paracetamol", "Biogesic", "Head ache", 5, 6));
        a.addMedicine(new Medicine(2, "Paracetamol", "Bioflu", "Head ache", 5, 7));
        a.addMedicine(new Medicine(3, "Paracetamol", "Rexidol Forte", "Head ache", 5, 4));
        //Medicine for Cough
        a.addMedicine(new Medicine(4, "Dextromethorphan Hydrobromide", "Tuseran Forte", "Cough", 5, 8));
        a.addMedicine(new Medicine(5, "Carbocisteine", "Solmux", "Cough", 5, 12));
        a.addMedicine(new Medicine(6, "Vitex Negundo L.(Lagundi Leaf)", "Ascof Forte", "Cough", 5, 12));
        //Medicine for Body Pain
        a.addMedicine(new Medicine(7, "Ibuprofen", "Medicol Advance", "Body Pain", 5, 12));
        a.addMedicine(new Medicine(8, "Ibuprofen", "Alaxan FR", "Body Pain", 5, 12));
        a.addMedicine(new Medicine(9, "Ibuprofen", "Advil", "Body Pain", 5, 12));
        //Medicine for Allergies
        a.addMedicine(new Medicine(10, "Cetirizine", "Zyrtec", "Allergy", 5, 12));
        a.addMedicine(new Medicine(11, "Loratadine", "Allerta", "Allergy", 5, 12));
        a.addMedicine(new Medicine(12, "Cetirizine + Phenyliphrine", "Alnix Plus", "Allergy", 5, 12));
    }

    public void addAccounts(Pharmacy a) {
        //seniorCitizen
        a.getAccounts().add(new SeniorCitizen("Maria", "maria@gmail.com", 70, "123"));
        a.getAccounts().add(new SeniorCitizen("Juana", "juana@gmail.com", 65, "123"));
        //adult
        a.getAccounts().add(new Adult("Jane", "jane@gmail.com", 25, "123"));
        a.getAccounts().add(new Adult("Monica", "mon@gmail.com", 26, "123"));
        //pharmacist
        a.getAccounts().add(new Pharmacist("jana", "jana@gmail.com", 30, "123"));
        a.getAccounts().add(new Pharmacist("Yeo", "yeo@gmail.com", 25, "123"));
    }

    public void addMedicine(Medicine e, Pharmacy a) {

        System.out.print("Enter brandname: ");
        String bname = strInput.nextLine();
        System.out.print("Enter generic name: ");
        String gname = strInput.nextLine();
        System.out.print("Enter price: ");
        String price = strInput.nextLine();
        System.out.print("Stock: ");
        String stock = strInput.nextLine();
        System.out.println("1. Cough\n2. Headache\n3. Allergies\n4. BodyPain");
        System.out.print("Choose type of medicine: ");
        int choice = intInput.nextInt();
        int id = a.getMedicines().size()+1;
        switch (choice) {
            case 1:
                a.getMedicines().add(new Medicine(id, gname, bname, "Cough", Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 2:
                a.getMedicines().add(new Medicine(id, gname, bname, "Headache", Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 3:
                a.getMedicines().add(new Medicine(id, gname, bname, "Allergies", Integer.valueOf(stock), Double.valueOf(price)));
                break;
            case 4:
                a.getMedicines().add(new Medicine(id, gname, bname, "BodyPain", Integer.valueOf(stock), Double.valueOf(price)));
                break;
            default:
                System.out.println("Error choice! Please try again!");
                break;
        }
        

    }

}
