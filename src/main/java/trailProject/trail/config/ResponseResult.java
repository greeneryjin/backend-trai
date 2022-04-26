package trailProject.trail.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import trailProject.trail.security.token.JwtProperties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class ResponseResult extends HttpServlet {

    private ObjectMapper ob = new ObjectMapper();

    //토큰 만료 시 사용
    public void expiredResponse(HttpServletResponse response) throws ServletException, IOException {

        //상태코드
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);

        //application/json : json 형식
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        //한글로 인코딩
        response.setCharacterEncoding("utf-8");

        //결과 반환.
        Result<String> result = Result.res(StatusEnum.NOT_FOUND, "토큰이 만료되었습니다.", "false");

        //응답 작성
        String string = ob.writeValueAsString(result);
        response.getWriter().write(string);
    }

    //액세스토큰, 리프레시 토큰 발급 시 사용
    public void createResponse(HttpServletResponse response, Map tokens, JwtProperties jwtProperties) throws ServletException, IOException {

        response.addHeader(JwtProperties.HEADER_STRING, jwtProperties.TOKEN_PREFIX);

        //상태코드
        response.setStatus(HttpServletResponse.SC_OK);

        //application/json : json 형식
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        //한글로 인코딩
        response.setCharacterEncoding("utf-8");

        //결과 반환.
        Result<String> result = Result.res(StatusEnum.OK, "토큰이 발급되었습니다.", "success", tokens);

        //응답 작성
        String string = ob.writeValueAsString(result);
        response.getWriter().write(string);
    }

    //액세스토큰 재발급시 사용
    public void reCreateResponse(HttpServletResponse response, Map tokens, JwtProperties jwtProperties) throws ServletException, IOException {

        response.addHeader(jwtProperties.HEADER_STRING, jwtProperties.TOKEN_PREFIX);

        //상태코드
        response.setStatus(HttpServletResponse.SC_OK);

        //application/json : json 형식
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        //한글로 인코딩
        response.setCharacterEncoding("utf-8");

        //결과 반환.
        Result<String> result = Result.res(StatusEnum.OK, "토큰이 다시 발급되었습니다.", "success", tokens);

        //응답 작성
        String string = ob.writeValueAsString(result);
        response.getWriter().write(string);
    }
}
