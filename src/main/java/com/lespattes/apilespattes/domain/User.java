package com.lespattes.apilespattes.domain;

import com.lespattes.apilespattes.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="users")
@Entity(name="users")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private String cpf;
	private String password;

	public User(UserDTO data) {
		this.name = data.name();
		this.email = data.email();
		this.cpf = data.cpf();
		this.password = data.password();
	}
}
	
