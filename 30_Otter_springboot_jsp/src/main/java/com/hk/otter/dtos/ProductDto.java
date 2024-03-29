package com.hk.otter.dtos;

//import java.util.Date;
import java.sql.Date;
import java.util.List;


public class ProductDto {
   
   private int seq;
   private int user_seq;
   private int cate_seq;
   private String img;
   
   private String maker;   
   private String goal_price;
   private String title;
   private Date created_date;
   private String open_date;
   private String close_date;
   private String content;
   private int total_price;
   private int total_supporters;
   private String product_check;
   
   private int remainingDays;
   


   public ProductDto(int seq, int cate_seq, String img, String maker, String title, int total_supporters,
         int remainingDays) {
      super();
      this.seq = seq;
      this.cate_seq = cate_seq;
      this.img = img;
      this.maker = maker;
      this.title = title;
      this.total_supporters = total_supporters;
      this.remainingDays = remainingDays;
   }


   public ProductDto(int seq, String img, String maker, String title, int total_supporters, int remainingDays) {
      super();
      this.seq = seq;
      this.img = img;
      this.maker = maker;
      this.title = title;
      this.total_supporters = total_supporters;
      this.remainingDays = remainingDays;
   }


   public int getRemainingDays() {
      return remainingDays;
   }


   public void setRemainingDays(int remainingDays) {
      this.remainingDays = remainingDays;
   }


   private List<RewardDto> reList;

   // 관리자-프로젝트 전체보기용
   public ProductDto(int seq, String maker, String title, Date created_date, String open_date, int cate_seq,
         String product_check) {
      super();
      this.seq = seq;
      this.maker = maker;
      this.title = title;
      this.created_date = created_date;
      this.open_date = open_date;
      this.cate_seq = cate_seq;
      this.product_check = product_check;
   }

   
// 네모 프로젝트
   public ProductDto(int seq, String img, String maker, String title, String close_date, int total_supporters) {
   super();
   this.seq = seq;
   this.img = img;
   this.maker = maker;
   this.title = title;
   this.close_date = close_date;
   this.total_supporters = total_supporters;
}


   //프로젝트 상세보기
   public ProductDto(int seq, String img, String maker, String goal_price, String title, String close_date,
         String content, int total_price, int cate_seq, String product_check) {
      super();
      this.seq = seq;
      this.img = img;
      this.maker = maker;
      this.goal_price = goal_price;
      this.title = title;
      this.close_date = close_date;
      this.content = content;
      this.total_price = total_price;
      this.cate_seq = cate_seq;
      this.product_check = product_check;
   }


   public ProductDto() {
      super();
      // TODO Auto-generated constructor stub
   }


   //내 프로젝트 조회
   public ProductDto(int seq, int user_seq, int cate_seq, String maker, String title, Date created_date,
         String open_date, String close_date, String product_check, int remainingDays) {
      super();
      this.seq = seq;
      this.user_seq = user_seq;
      this.cate_seq = cate_seq;
      this.maker = maker;
      this.title = title;
      this.created_date = created_date;
      this.open_date = open_date;
      this.close_date = close_date;
      this.product_check = product_check;
      this.remainingDays = remainingDays;
   }

//   public ProductDto(int seq, String product_check, String open_date) {
//      super();
//      this.seq = seq;
//      this.product_check = product_check;
//      this.open_date = open_date;
//      
//   }

   
   public ProductDto(int user_seq, String img, String product_check) {
      super();
      this.user_seq = user_seq;
      this.img = img;
      this.product_check = product_check;
   }

   
   public ProductDto(int seq, int user_seq, String img, String maker, String goal_price, String title,
         Date created_date, String open_date, String close_date, String content, int total_price,
         int total_supporters, int cate_seq, String product_check, List<RewardDto> reList) {
      super();
      this.seq = seq;
      this.user_seq = user_seq;
      this.img = img;
      this.maker = maker;
      this.goal_price = goal_price;
      this.title = title;
      this.created_date = created_date;
      this.open_date = open_date;
      this.close_date = close_date;
      this.content = content;
      this.total_price = total_price;
      this.total_supporters = total_supporters;
      this.cate_seq = cate_seq;
      this.product_check = product_check;
      this.reList = reList;
   }




   public int getSeq() {
      return seq;
   }


   public void setSeq(int seq) {
      this.seq = seq;
   }


   public int getUser_seq() {
      return user_seq;
   }


   public void setUser_seq(int user_seq) {
      this.user_seq = user_seq;
   }


   public int getCate_seq() {
      return cate_seq;
   }


   public void setCate_seq(int cate_seq) {
      this.cate_seq = cate_seq;
   }


   public String getImg() {
      return img;
   }


   public void setImg(String img) {
      this.img = img;
   }


   public String getMaker() {
      return maker;
   }


   public void setMaker(String maker) {
      this.maker = maker;
   }


   public String getGoal_price() {
      return goal_price;
   }


   public void setGoal_price(String goal_price) {
      this.goal_price = goal_price;
   }


   public String getTitle() {
      return title;
   }


   public void setTitle(String title) {
      this.title = title;
   }


   public Date getCreated_date() {
      return created_date;
   }


   public void setCreated_date(Date created_date) {
      this.created_date = created_date;
   }


   public String getOpen_date() {
      return open_date;
   }


   public void setOpen_date(String open_date) {
      this.open_date = open_date;
   }


   public String getClose_date() {
      return close_date;
   }


   public void setClose_date(String close_date) {
      this.close_date = close_date;
   }


   public String getContent() {
      return content;
   }


   public void setContent(String content) {
      this.content = content;
   }


   public int getTotal_price() {
      return total_price;
   }


   public void setTotal_price(int total_price) {
      this.total_price = total_price;
   }


   public int getTotal_supporters() {
      return total_supporters;
   }


   public void setTotal_supporters(int total_supporters) {
      this.total_supporters = total_supporters;
   }


   public String getProduct_check() {
      return product_check;
   }


   public void setProduct_check(String product_check) {
      this.product_check = product_check;
   }


   public List<RewardDto> getReList() {
      return reList;
   }


   public void setReList(List<RewardDto> reList) {
      this.reList = reList;
   }


   @Override
   public String toString() {
      return "ProductDto [seq=" + seq + ", user_seq=" + user_seq + ", cate_seq=" + cate_seq + ", img=" + img
            + ", maker=" + maker + ", goal_price=" + goal_price + ", title=" + title + ", created_date="
            + created_date + ", open_date=" + open_date + ", close_date=" + close_date + ", content=" + content
            + ", total_price=" + total_price + ", total_supporters=" + total_supporters + ", product_check="
            + product_check + ", remainingDays=" + remainingDays + ", reList=" + reList + "]";
   }




   
   
   
   
   
   

}