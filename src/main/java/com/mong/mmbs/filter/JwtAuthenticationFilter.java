package com.mong.mmbs.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.mong.mmbs.security.TokenProvider;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired private TokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String authorizationHeader = request.getHeader("Authorization");

			String token = (authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
					? tokenProvider.removeBearer(authorizationHeader)
					: null;

			if (token == null || !tokenProvider.isValidToken(token)) {
				filterChain.doFilter(request, response);
				return;
			}

			Long id = tokenProvider.getIdFromJwt(token);
			setAuthenticationContext(request, id);
		} catch (Exception exception) {
			exception.printStackTrace();
		}	
		
		filterChain.doFilter(request, response);
	}

	private void setAuthenticationContext(HttpServletRequest request, Long id) {
		AbstractAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(id, null, AuthorityUtils.NO_AUTHORITIES);

		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authenticationToken);

		SecurityContextHolder.setContext(securityContext);
	}
}
