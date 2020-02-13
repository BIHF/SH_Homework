package com.board.vo;

import java.util.Date;

public class boardVo {
	private int no;
	private String content;
	private Date time;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	

	public boardVo(int no, String content, Date time) {
		super();
		this.no = no;
		this.content = content;
		this.time = time;
	}

	public boardVo() {

	}
}
