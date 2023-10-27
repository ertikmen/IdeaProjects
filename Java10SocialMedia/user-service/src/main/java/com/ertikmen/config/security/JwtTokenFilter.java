package com.ertikmen.config.security;


import com.ertikmen.utility.JwtTokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenManager jwtTokenManager;
    private final JwtUserDetails jwtUserDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getRequestURL());
        String authorizationHeader=request.getHeader("Authorization");
        //System.out.println(authorizationHeader);
        // burda çalıştırdık ve null düştüğünü gördük

        System.out.println("authHeader===>"+authorizationHeader);
        System.out.println("auth===>"+SecurityContextHolder.getContext().getAuthentication());


        if (authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")
        //    && SecurityContextHolder.getContext().getAuthentication()==null // daha önce authtantion olmamışsa.. gerektiğinde if içine yazacağız.
        ){


            String token=authorizationHeader.substring(7);
            Optional<String> role=jwtTokenManager.getRoleFromToken(token);
            UserDetails userDetails=null;
            System.out.println("token===>"+token);


            if (role.isPresent()){
                userDetails=jwtUserDetails.loadUserByUserRole(role.get());

                UsernamePasswordAuthenticationToken authenticationToken=
                        new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

            System.out.println("User==>"+userDetails);
            System.out.println("getcontext==>"+SecurityContextHolder.getContext());
        }


        System.out.println("auth==>"+SecurityContextHolder.getContext().getAuthentication());
        filterChain.doFilter(request,response);

    }
}
