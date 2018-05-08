package asd;

public class CustomerVO {
private String name;
private String wnals;
private String tel;
private String gneder;
private String hobby;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getWnals() {
	return wnals;
}
public void setWnals(String wnals) {
	this.wnals = wnals;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getGneder() {
	return gneder;
}
public void setGneder(String gneder) {
	this.gneder = gneder;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
    return this.getName();
}
}
