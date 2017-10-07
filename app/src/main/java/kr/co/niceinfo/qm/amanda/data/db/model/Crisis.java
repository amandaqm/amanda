package kr.co.niceinfo.qm.amanda.data.db.model;

import java.util.Date;

public class Crisis {
	public static final String SECURITY = "security";
	public static final String SERVICES = "services";
	
	String name;
	String desc;
	String level;
	String category;
	Date date;
	
	/**
	 * 
	 * @param name
	 * @param desc
	 * @param level
	 * @param category
	 * @param date
	 */
	public Crisis(String name, String desc, String level, String category,Date date) {
		this.name = name;
		this.desc = desc;
		this.level = level;
		this.category = category;
		this.date = date;
	}
	
	public Crisis() {
		this("","","","",new Date());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Crisis [name=" + name + ", desc=" + desc + ", level=" + level
				+ ", category=" + category + ", date=" + date + "]";
	}
	
	
	

	
	
}