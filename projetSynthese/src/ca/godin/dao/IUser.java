package ca.godin.dao;
import ca.godin.beans.*;
public interface IUser {

	public void addUser(User user);
	public void setRole(Role r,int userid);
	public  Order saveOrder(Cart cart,Client c);
}
