package oopssession5;

public class User extends Entity {

	private String hobby;
	private int age;
	
	public User(int entityId,String entityType,String entityName,String entityHobby,int entityAge)
	{
		super(entityId, entityType, entityName);
		this.hobby=entityHobby;
		this.age=entityAge;
		
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
