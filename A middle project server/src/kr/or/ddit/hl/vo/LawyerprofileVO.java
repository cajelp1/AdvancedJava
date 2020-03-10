package kr.or.ddit.hl.vo;

import java.io.Serializable;

public class LawyerprofileVO implements Serializable{
	private String law_id;
	private String law_career;
	private String law_academic_background;
	private int category_code;
	private String law_license;
	private String law_current_news;

	public String getLaw_id() {
		return law_id;
	}

	public void setLaw_id(String law_id) {
		this.law_id = law_id;
	}

	public String getLaw_career() {
		return law_career;
	}

	public void setLaw_career(String law_career) {
		this.law_career = law_career;
	}

	public String getLaw_academic_background() {
		return law_academic_background;
	}

	public void setLaw_academic_background(String law_academic_background) {
		this.law_academic_background = law_academic_background;
	}

	public int getCategory_code() {
		return category_code;
	}

	public void setCategory_code(int category_code) {
		this.category_code = category_code;
	}

	public String getLaw_license() {
		return law_license;
	}

	public void setLaw_license(String law_license) {
		this.law_license = law_license;
	}

	public String getLaw_current_news() {
		return law_current_news;
	}

	public void setLaw_current_news(String law_current_news) {
		this.law_current_news = law_current_news;
	}

}
