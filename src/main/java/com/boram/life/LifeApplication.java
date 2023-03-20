package com.boram.life;

import com.boram.life.domain.Member;
import com.boram.life.member.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeApplication.class, args);
	}
}
