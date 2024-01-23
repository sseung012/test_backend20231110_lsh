package com.hk.board.dtos;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "hkDto")
public class HkDto {
	
   private int seq;
   private String id;
   private String title;
   private String content;
   private Date regdate;
   
   public HkDto() {
	   super();
	   // TODO Auto-generated constructor stub
   }
   
   public HkDto(int seq, String id, String title, String content, Date regdate) {
	   super();
	   this.seq = seq;
	   this.id = id;
	   this.title = title;
	   this.content = content;
	   this.regdate = regdate;
   }

   @Override
   public String toString() {
      return "HkDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regdate=" + regdate
            + "]";
   }
   public int getSeq() {
      return seq;
   }
   public void setSeq(int seq) {
      this.seq = seq;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public Date getRegdate() {
      return regdate;
   }
   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }
}