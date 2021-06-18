package com.quinta.foody.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_tbl")
public class Login {
	
	@Id
	@Column(name="email_id",length=70)
	private String emailId;
	
	@Column(name="password",length=50)
	private String passWord;

	
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Login(String emailId, String passWord) {
		super();
		this.emailId = emailId;
		this.passWord = passWord;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassWord() {
		return passWord;
	}



	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}



	@Override
	public String toString() {
		return "Login [emailId=" + emailId + ", passWord=" + passWord + "]";
	}


	
	
}

		