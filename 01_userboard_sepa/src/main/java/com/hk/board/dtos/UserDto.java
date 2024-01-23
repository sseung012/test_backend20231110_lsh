package com.hk.board.dtos;

//패키지가 다른 클래스를 사용할 때 반드시 작성해야함
import java.util.Date;

public class UserDto {
   //private??? : 클래스 내부에서만 접근 가능
   private String userID;
   private String name;
   private int birthYear;
   private String addr;
   private String mobile1;
   private String mobile2;
   private int height;
   private Date mDate;
   
   public String getUserID() {
      return userID;
   }

   public UserDto() {
      
   }

   //생성자 오버로딩 : 클래스의 멤버필드를 선택적으로 초기화할 수 있다.
   public UserDto(String userID, String name, int birthYear, String addr, String mobile1, String mobile2, int height,
         Date mDate) {
      super();
      this.userID = userID;
      this.name = name;
      this.birthYear = birthYear;
      this.addr = addr;
      this.mobile1 = mobile1;
      this.mobile2 = mobile2;
      this.height = height;
      this.mDate = mDate;
   }
   public UserDto(String userID, String name, int birthYear, String addr, String mobile1, String mobile2, int height) {
	super();
	this.userID = userID;
	this.name = name;
	this.birthYear = birthYear;
	this.addr = addr;
	this.mobile1 = mobile1;
	this.mobile2 = mobile2;
	this.height = height;
}

public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getBirthYear() {
      return birthYear;
   }

   public void setBirthYear(int birthYear) {
      this.birthYear = birthYear;
   }

   public String getAddr() {
      return addr;
   }

   public void setAddr(String addr) {
      this.addr = addr;
   }

   public String getMobile1() {
      return mobile1;
   }

   public void setMobile1(String mobile1) {
      this.mobile1 = mobile1;
   }

   public String getMobile2() {
      return mobile2;
   }

   public void setMobile2(String mobile2) {
      this.mobile2 = mobile2;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public Date getmDate() {
      return mDate;
   }

   public void setmDate(Date mDate) {
      this.mDate = mDate;
   }

   public void setUserID(String userID) {
      this.userID = userID;
   }
   
   @Override
   public String toString() {
      return "UserDto [userID=" + userID + ", name=" + name + ", birthYear=" + birthYear + ", addr=" + addr
            + ", mobile1=" + mobile1 + ", mobile2=" + mobile2 + ", height=" + height + ", mDate=" + mDate + "]";
   }
   
   
   
   
   
}