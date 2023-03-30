package com.trillon.camp.common.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.trillon.camp.members.dto.Account;

import lombok.Data;

@Data
public class SecurityUser extends User{

	private Account account;
	
	public SecurityUser(Account account) {
		 super(account.getUserId(), account.getPassword(), AuthorityUtils.createAuthorityList(account.getAuthority().toString()));
	
		 System.out.println(account.getUserId());
		 System.out.println(account.getPassword());
		 System.out.println(account.getAuthority());
		 
		 this.account = account;
	}

}
