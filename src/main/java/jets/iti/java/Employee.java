package jets.iti.java;

public class Employee {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String address;
    private String phoneNum;
    private int vacationBalance;
    private int age;


    public Employee() {
        // Default constructor
    }

    public Employee(int id, String fname, String lname, String gender, String address, String phoneNum, int vacationBalance,int age) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.address = address;
        this.phoneNum = phoneNum;
        this.vacationBalance = vacationBalance;
        this.age = age;
    }


    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getVacationBalance() {
        return vacationBalance;
    }

    public void setVacationBalance(int vacationBalance) {
        this.vacationBalance = vacationBalance;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", vacationBalance=" + vacationBalance +'\''+
                ", age=" +age+
                '}';
    }

}
