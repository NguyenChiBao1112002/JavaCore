package baitap_01;

import java.util.Scanner;

public class Student extends Person {
    String rollNo;
    float mark;
    String email;

    public Student() {
    }

    @Override
    public void showInfo() {
        super.showInfo(); 
        System.out.println(" rollNo: " + rollNo + "; mark: " + mark + "; email: " + email);
        System.out.println("");
    }
    
    
    
//  Override: ghi đè
//  Chỉ cần gọi inputInfo
    @Override
    public void inputInfo() {
        super.inputInfo(); 
        
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
//  Có thể viết ngắn là: while(!setRollNo(input.nextLine()); (! vì while = true)
//  Kết quả false thì chạy tiếp nên true= !flase để no chạy tiếp
        while(true){
            String rollNoInput = input.nextLine();
            boolean check = setRollNo(rollNoInput);
            if(check){
                break;
            }
        }
//  nextLine: đọc 1 dòng
//  Float.parseFloat(input.nextLine): bỏ ký tự \n; đọc 1 dòng-> chuyển thành số Float
//  Để ko bỏ xót các số sau dấu thập phân khi nhâp, vì nếu ko có thì
//  float mặc định chỉ lấy 6 số sau dấu thập phân
        System.out.println("Nhap diem sinh vien: ");
        while(true){
            float markInput = Float.parseFloat(input.nextLine());
            boolean check = setMark(markInput);
            if(check){
                break;
            }
        }
        
        System.out.println("Nhap email sinh vien: ");
        while(true){
            String emailInput = input.nextLine();
            boolean check = setEmail(emailInput);
            if(check){
                break;
            }
        }
        
    }
    
    
    
    public String getRollNo() {
        return rollNo;
    }

    @SuppressWarnings("empty-statement")
    public boolean setRollNo(String rollNo) {
        if(rollNo!=null&&rollNo.length()==8){
            this.rollNo = rollNo;
            return true;
        }
        else{
            System.err.println("Nhap lai ma sinh vien (length=8):");
            return false;
        }
    }

    public float getMark() {
        return mark;
    }

    public boolean setMark(float mark) {
        if(mark >=0 && mark <=10){
            this.mark = mark;
            return true;
        }
        else{
            System.err.println("Nhap lai diem (diem >=0 && <=10");
            return false;
        }
    }

    public String getEmail() {
        return email;
    }

//  Phương thức email.contains=> Tìm kiếm chuỗi trong chuỗi. 
//  Trong chuỗi emai => Nếu có trả về true, không trả về false
//  email phải khác null, vì null => null.contains đằng sau lỗi
    public boolean setEmail(String email) {
        
        if(email!=null && email.contains("@") && !email.contains(" ")){
            this.email = email;
            return true;
        }
        else{
            System.out.println("Nhap lai dia chi email:");
            return false;
        }
    }
    
     public boolean checkScholarship(){
        return mark>=8;
    }
}
