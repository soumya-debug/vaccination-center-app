package com.example.vaccinationcenter.filter;


import com.example.vaccinationcenter.entities.User;
import com.example.vaccinationcenter.repository.UserRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class UserAuthenticationFilter implements Filter {

  private UserRepository userRepository;

  public UserAuthenticationFilter(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    boolean flag = validateToken((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse);
    if(!flag){
      return;
    }
    filterChain.doFilter(servletRequest,servletResponse);
  }

  private Set<String> servletPaths = new HashSet<>(){{
    add("citizens");
    add("vaccinationcenter");
    add("me");
  }};

  private boolean validateToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String servletPath = request.getServletPath();
    System.out.println(servletPath);

    String api = request.getHeader("x-api");

    if(!Boolean.valueOf(api))
    {
      return true;
    }

    String authorizationHeader = request.getHeader("authorization");
    if (StringUtils.isBlank(authorizationHeader)) {
      System.out.println("auth token missing, so redirecting to login");
      response.setStatus(302);
      return false;
    }
    byte emailBytes[] = Base64.getDecoder().decode(authorizationHeader.getBytes(StandardCharsets.UTF_8));
    String email = new String(emailBytes);
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new RuntimeException("user not found with email: " + email);
    }
    return true;
  }
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    Filter.super.init(filterConfig);
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }

  private String getBaseUrl(HttpServletRequest request)
  {
    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

    System.out.println(baseUrl);
    return baseUrl;
  }
}
