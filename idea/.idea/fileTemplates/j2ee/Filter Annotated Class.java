#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
@javax.servlet.annotation.WebFilter("/*")
public class ${Class_Name} implements javax.servlet.Filter {
    
    public void init(javax.servlet.FilterConfig config) throws javax.servlet.ServletException {

    }

    public void doFilter(javax.servlet.ServletRequest req, javax.servlet.ServletResponse resp, javax.servlet.FilterChain chain) throws javax.servlet.ServletException, java.io.IOException {
        chain.doFilter(req, resp);
    }
    
    public void destroy() {
    
    }
   

}
