package com.aaCode.Assignment.config;

import com.aaCode.Assignment.service.JWTService;
import com.aaCode.Assignment.service.JWTUserDetailsService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;

    private final JWTUserDetailsService jwtUserDetailsService;

    public JWTAuthenticationFilter(JWTService jwtService, JWTUserDetailsService jwtUserDetailsService){
        this.jwtService = jwtService;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException{
        System.out.println(1);
        final String authHeader = request.getHeader("Authorization");
        System.out.println(authHeader);
        final String token;
        final String adminEmail;

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        token = authHeader.substring(7);
        adminEmail = jwtService.extractUsername(token);

        if (adminEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(adminEmail);
            if (jwtService.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            filterChain.doFilter(request, response);
        }
    }
}
