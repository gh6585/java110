package ex01;

import java.util.Date;

public class Car {
    int no;
    String model;
    String maker;
    int cc;
    Date CreatedDate;
    
    public Car() {
        System.out.println("Car() 호출됨!");
    }
    
    public Car(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String,int) 호출됨!");

    }
    
    public Car(int cc, String medel) {
        this.model = medel;
        this.cc = cc;
        System.out.println("Car(int,String) 호출됨!");

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", CreatedDate=" + CreatedDate
                + "]";
    }
    
    
}
