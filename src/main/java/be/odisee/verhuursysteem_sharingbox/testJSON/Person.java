package be.odisee.verhuursysteem_sharingbox.testJSON;

public class Person {
	private String name;
	private int age;
	private String city;

	public Person() {
	};

	public Person(String name, int age, String city) {
		this.name = name;
		this.city = city;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	};
}