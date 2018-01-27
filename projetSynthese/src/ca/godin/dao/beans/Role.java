package ca.godin.beans;

public class Role {
private Long idRole;
private String roleName;
private User user;
public Long getIdRole() {
	return idRole;
}
public void setIdRole(Long idRole) {
	this.idRole = idRole;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

}
