package com.ss.training.lms.security;

/**
 * @author Justin O'Brien
 */
public class JwtProperties {

	public static final String SECRET = "SmoothstackJava042020LMS";
    public static final int EXPIRATION_TIME = 86_400_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
