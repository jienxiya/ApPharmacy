
package appharmacy3;

import java.util.ArrayList;

public class Pharmacy {
    private String pharmacyName;
    private String location;
    ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    ArrayList<User> accounts = new ArrayList<User>();
    Pharmacist mj = new Pharmacist("Admin","Email","Password");
    
    private int noOfMedicineAdded = 0;
    private int noOfUser = 0;

    //constructors
    public Pharmacy() {
    }

    public Pharmacy(String pharmacyName, String location, ArrayList<Medicine> medicines, ArrayList<User> accounts) {
        this.pharmacyName = pharmacyName;
        this.location = location;
        this.medicines = medicines;
        this.accounts = accounts;
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

    public int getNoOfMedicineAdded() {
        return noOfMedicineAdded;
    }

    public void setNoOfMedicineAdded(int noOfMedicineAdded) {
        this.noOfMedicineAdded = noOfMedicineAdded;
    }

    public int getNoOfUser() {
        return noOfUser;
    }

    public void setNoOfUser(int noOfUser) {
        this.noOfUser = noOfUser;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public ArrayList<User> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<User> accounts) {
        this.accounts = accounts;
    }
    
    //behaviors
    public void addMedicine(Medicine med){
       this.medicines.add(med);
       this.noOfMedicineAdded += 1;
    }
    
    public void addUser(User user){
        this.accounts.add(user);
        this.noOfUser += 1;
    }
    
    public void viewAvailableMedicine(){
        System.out.println(this.medicines);     
    }
    
    public void updateMedicine(){
        
    }
    
    
    
//    public void removeMedicine(){
//        for(int i = 0; i < this.medicines.size(); i++){
//            if(){
//                this.medicines.remove(med);
//            }
//        }
//    }

    public Pharmacist getMj() {
        return mj;
    }
}
