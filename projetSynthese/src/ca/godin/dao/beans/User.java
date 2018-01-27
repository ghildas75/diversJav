package ca.godin.beans;

import java.util.*;

public class User {

	private int idUser;
	private String username;
	private String password;
	private boolean actived;
	private Collection<Role> Roles= new ArrayList<>();
}
