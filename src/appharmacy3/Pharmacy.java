
package appharmacy3;

import java.util.ArrayList;
import java.util.Scanner;

public class Pharmacy {
    private String pharmacyName;
    private String location;
    
    public ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    public ArrayList<User> accounts = new ArrayList<User>();
    Scanner input = new Scanner(System.in);
    Pharmacist mj = new Pharmacist("MJ","mj@gmail.com",20,"123");

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
    public void addMedicine(Medicine med){
       this.medicines.add(med);
    }
    
    public void addUser(User user){
        this.accounts.add(user);
    }
    
    public void viewAvailableMedicine() {
        System.out.printf("%20s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", "Generic name", "|", "Brand Name", "|", "Medicine Type", "|", "Price", "|","Stock","|");
        System.out.println("------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < this.getMedicines().size(); i++) {
            System.out.printf("%20s %5s %20s %5s %20s %5s %15s %5s %15s %5s\n", this.getMedicines().get(i).getGenericName(), "|", this.getMedicines().get(i).getBrandName(), "|", this.getMedicines().get(i).getType(), "|", this.getMedicines().get(i).getPrice(), "|",this.getMedicines().get(i).getMedStock(),"|");
        }
    }
    
    public void updateMedicine(){
        
    }

    public void removeMedicine(Medicine med){
        System.out.print("Brand name of medicine you want to remove: ");
        String rMed = input.nextLine();
        for(int i = 0; i < this.medicines.size(); i++){
            if(this.medicines.get(i).getBrandName().equals(rMed) == true){
                this.medicines.remove(this.medicines.get(i));
            }
        }
    }

    public Pharmacist getMj() {
        return mj;
    }
    
    public void addMedicine(Pharmacy a){
        a.addMedicine(new Medicine("Paracetamol", "Biogesic","Head ache",5,12));
        a.addMedicine(new Medicine("Paracetamol", "Alaxan","Body Pain",5,12));
//        a.addMedicine(new Medicine("Paracetamol", "Biogesic","Head ache",12));
//        a.addMedicine(new Medicine("Paracetamol", "Biogesic","Head ache",12));
//        a.addMedicine(new Medicine("Paracetamol", "Biogesic","Head ache",12));
//        a.addMedicine(new Medicine("Paracetamol", "Biogesic","Head ache",12));
    }
    
    public void addAccounts(Pharmacy a) {
        a.getAccounts().add(new SeniorCitizen("Maria", "maria@gmail.com",70,"123"));
        a.getAccounts().add(new SeniorCitizen("Juana", "juana@gmail.com",65, "123"));
        a.getAccounts().add(new Adult("Jane", "jane@gmail.com",25, "123"));
        a.getAccounts().add(new Adult("Monica", "mon@gmail.com",26, "123"));
        a.getAccounts().add(new Pharmacist("jana", "jana@gmail.com",30, "123"));
        a.getAccounts().add(new Pharmacist("Yeo", "yeo@gmail.com",25, "123"));
    }

}
