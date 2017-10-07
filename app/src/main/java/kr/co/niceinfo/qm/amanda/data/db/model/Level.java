package kr.co.niceinfo.qm.amanda.data.db.model;

public class Level {
	String name;
	String desc;
	
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
	public Level(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	
	
	public Level() {
		this("","");
	}
	
	@Override
	public String toString() {
		return "Service [name=" + name + ", desc=" + desc + "]";
	}

}