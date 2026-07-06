package lib;

public class Module {

	//Fields
	private String code;
	private String name;
	private int examWeight;
	private int cwkWeight;

	
	//Constructors
	public Module() {
		this("CTEC0000", "", 50);
	}
	
	public Module(String code, String name) {
		this(code, name, 50);
	}
	
	public Module(String code, String name, int examWeight) {
		this.code = code;
		this.name = name;
		this.examWeight = examWeight;
		this.cwkWeight = 100 - examWeight;
	}
	
	
	//Methods
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExamWeight() {
		return examWeight;
	}
	
	public void setExamWeight(int examWeight) {
		this.examWeight = examWeight;
		this.cwkWeight = 100 - examWeight;
	}
	
	public int getCwkWeight() {
		return cwkWeight;
	}
	
	public void setCwkWeight(int cwkWeight) {
		this.cwkWeight = cwkWeight;
		this.examWeight = 100 - cwkWeight;
	}

	@Override
	public String toString() {
		return "Module:[code=" + code + ", name=" + name + 
				", examWeight=" + examWeight + ", cwkWeight=" + cwkWeight + "]";
	}
	
}