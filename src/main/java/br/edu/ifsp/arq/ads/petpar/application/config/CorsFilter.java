package br.edu.ifsp.arq.ads.petpar.application.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter{

	private final List<String> allowedOrigins = Arrays.asList(
			"http://cti-optiplex-3080:8000",
			"http://localhost:4200"
	);

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String requestOrigin = request.getHeader("Origin");

		if (requestOrigin != null && allowedOrigins.contains(requestOrigin)) {
			response.setHeader("Access-Control-Allow-Origin", requestOrigin);
			response.setHeader("Access-Control-Allow-Credentials", "true");
		}

		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
			response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
			response.setHeader("Access-Control-Max-Age", "3600");

			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			chain.doFilter(req, resp);
		}
	}
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) resp;
//
//		response.setHeader("Access-Control-Allow-Origin", allowedOrigin);
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//
//		if ("OPTIONS".equals(request.getMethod()) &&
//				allowedOrigin.equals(request.getHeader("Origin"))) {
//			response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
//        		response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
//        		response.setHeader("Access-Control-Max-Age", "3600");
//
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, resp);
//		}
//
//	}
}