package com.project.medicumzone.config;

import com.project.medicumzone.security.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private MyUserDetailsService myUserDetailsService;
    private JWTTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authToken = jwtTokenHelper.getToken(request);
        if(authToken!=null){
            String username = jwtTokenHelper.getUsernameFromToken(authToken);
            if(username!=null){
                UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
                if(jwtTokenHelper.validateToken(authToken,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken
                            =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities() );
                    authenticationToken.setDetails(new WebAuthenticationDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }

}
