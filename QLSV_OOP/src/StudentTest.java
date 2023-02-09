package baitap_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class StudentTest {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        int choose;
        Scanner scan = new Scanner(System.in);
        do{
            showMenu();
            System.out.println("Choose: ");
            choose = Integer.parseInt(scan.nextLine());
            
            switch(choose){
                case 1:
                    int n;
                    System.out.println("Nhap so sinh vien");
                    n = Integer.parseInt(scan.nextLine());
                    for(int i=0;i<n;i++){
                        Student std = new Student();
                        std.inputInfo();
                        
                        studentList.add(std);
                    }
                    break;
                    
                case 2:
                    for(int i=0;i<studentList.size();i++){
                        studentList.get(i).showInfo();
                    }
                    break;
                    
                case 3:
                    int minIndex = 0, maxIndex = 0;
//              Lưu lại vị trí
                    float minMark,maxMark;
                    minMark = studentList.get(0).getMark();
                    maxMark = studentList.get(0).getMark();
                    for (int i = 0; i < studentList.size(); i++) {
                        if(studentList.get(i).getMark()<minMark){
                            minIndex = i;
                            minMark = studentList.get(i).getMark();
                        }
                        
                        if(studentList.get(i).getMark()>maxMark){
                            maxIndex = i;
                            maxMark = studentList.get(i).getMark();
                        }    
                    }
                    System.out.println("Sinh vien co diem trung binh cao nhat");
                    studentList.get(maxIndex).showInfo();
                    
                    System.out.println("Sinh vien co diem trung binh thap nhat");
                    studentList.get(minIndex).showInfo();
                    break;
                    
                case 4:
                    System.out.println("Nhap rollNo can tim kiem: ");
                    String rollNosearch = scan.nextLine();
                    int count=0;
                    
                    for (Student student : studentList) {
                        if(student.getRollNo().equalsIgnoreCase(rollNosearch)){
                        student.showInfo(); 
                        count++;
                        }           
                    }
                    if(count==0) System.out.println("Khong tim thay sinh vien nao");                    
                    break;
                    
                case 5:
//              B1: Sắp xếp tên sinh viên theo thư tự từ A->Z
                    Collections.sort(studentList, new Comparator<Student>(){
                        @Override
                        public int compare(Student o1, Student o2) {
                            int cmp = o1.getName().compareTo(o2.getName());
                            if(cmp>=0)
                                return 1;
                            return -1;
                    }                   
                    });     
//              B2: Hiển thị
                    for (int i = 0; i < studentList.size(); i++) {
                        studentList.get(i).showInfo();
                    }
                    break;
                    
                case 6:
                    Collections.sort(studentList, new Comparator<Student>(){
                        @Override
                        public int compare(Student o1, Student o2) {
                            return o1.getMark() >= o2.getMark()?-1:1;
                    }                   
                    }); 
//              Hiển thị
                    for (int i = 0; i < studentList.size(); i++) {
                        if(studentList.get(i).checkScholarship())
                            studentList.get(i).showInfo();
                    }
                    break;
                    
                case 7:
                    System.out.println("Goodbye");
                    break;
                    
                default:
                    System.err.println("Nhap sai!!!");
                    break;
            }
        }while(choose !=7);
    }
    
    static void showMenu(){
        System.out.println("1. Nhap so sinh vien: ");
        System.out.println("2. Hien thi thong tin sinh vien: ");
        System.out.println("3. Hien thi Max va Min theo dtb: ");
        System.out.println("4. Tim kiem theo ma sinh vien: ");
        System.out.println("5. Hien thi tat ca sinh vien tu A->Z");
        System.out.println("6. Hien thi sinh vien duoc hoc bong && sort mark giam dan");
        System.out.println("7. Thoat");
       
    }
}
