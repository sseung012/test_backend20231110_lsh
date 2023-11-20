package com.hk.trip.dtos;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "boardDto")
public class BoardDto {

	private int seq;
	private String id;
	private String title;
	private String content;
	private Date regDate;
	private int refer;
	private int step;
	private int depth;
	private String readCount;
	private String delflag;
	
	//date를 String 형식으로 변환하여 저장해줄 변수
	private String regDateStr;
	
	
	public String getRegDateStr() {
		return regDateStr;
	}

	public void setRegDateStr(String regDateStr) {
		this.regDateStr = regDateStr;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getReadCount() {
		return readCount;
	}

	public void setReadCount(String readCount) {
		this.readCount = readCount;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	@Override
	public String toString() {
		return "AnsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", refer=" + refer + ", step=" + step + ", depth=" + depth + ", readCount=" + readCount
				+ ", delflag=" + delflag + "]";
	}
}














