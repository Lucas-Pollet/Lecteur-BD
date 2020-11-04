package fr.lecteurbd.stock;

public class Page {

	private int numpage;
	private String name;
	private String path;
	
	public Page(int num, String name, String path) {
		this.numpage=num;
		this.name=name;
		this.path=path;
	}

	public int getNumpage() {
		return numpage;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}
	
}
