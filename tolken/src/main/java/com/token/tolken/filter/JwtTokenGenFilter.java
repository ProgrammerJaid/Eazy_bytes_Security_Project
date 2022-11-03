package com.token.tolken.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtTokenGenFilter extends OncePerRequestFilter {

	@Value("${app.jwt-secret}")
	private String k;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println(k+"  ------     ");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null) {
			
			SecretKey key = Keys.hmacShaKeyFor(k.getBytes(StandardCharsets.UTF_8));
			String jwt = Jwts.builder().setIssuer("Jaid").setSubject("JWT Token")
					.claim("username", auth.getName())
					.setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime() + 3000000))
					.signWith(key)
					.compact();

			System.out.print(jwt);
			
			response.setHeader("Authorization", jwt);
		}
		
		filterChain.doFilter(request, response);
	}

//	public String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
//
//		Set<String> authSt = new HashSet<>();
//		for (GrantedAuthority authorities : collection) {
//			authSt.add(authorities.getAuthority());
//		}
//
//		return String.join(",", authSt);
//	}

//	@Override
//	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//		return !request.getServletPath().equals("/user");
//	}
	
}