package hellorest.src;

public class DummyClass {
	
	private String name;
	private int size;
	private byte[] byteArray;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		name = (name == null || name.equals(""))?"vacío":name;
		this.name = name;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the byteArray
	 */
	public byte[] getByteArray() {
		return byteArray;
	}
	/**
	 * @param byteArray the byteArray to set
	 */
	public void setByteArray(byte[] byteArray) {
		this.byteArray = byteArray;
	}
	/**
	 * @param name
	 * @param size
	 * @param byteArray
	 */
	public DummyClass(String name, int size, byte[] byteArray) {
		super();
		this.name = name;
		this.size = size;
		this.byteArray = byteArray;
	}

}
