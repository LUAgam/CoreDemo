/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * 
 *
 * @author $Author: JHuang $
 * @version $Revision: 4277 $
 */
@Entity
@Table(name = "tbl_user", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User extends BaseEntity<User> {

	/*--------------------------------------------
	|             C O N S T A N T S             |
	============================================*/
	private static final long serialVersionUID = 8380098780579946048L;

	/*--------------------------------------------
	|    I N S T A N C E   V A R I A B L E S    |
	============================================*/

	/**
	 * 用户名
	 */
	@NotNull
	private String username;

	/**
	 * 密码
	 */
	@NotNull
	private String password;
	
	/**
	 * 盐值
	 */
	@NotNull
	private String salt;

	/**
	 * version
	 */
	@Version
	private int version;

	/**
	 * login allowed
	 */
	private boolean loginAllowed = true;

	/**
	 * Comment
	 */
	private String comment;

	@ManyToOne(fetch=FetchType.EAGER)
	private Person person;
	// ----------------------------------------------//

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isLoginAllowed() {
		return loginAllowed;
	}

	public void setLoginAllowed(boolean loginAllowed) {
		this.loginAllowed = loginAllowed;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
