package trailProject.trail.api.controller;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trailProject.trail.api.entity.Course;
import trailProject.trail.api.repository.CourseRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/trail")
public class ApiController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/api")
    public String callApi() throws IOException, ParseException {
        String urlStr = "http://openapi.seoul.go.kr:8088/4e5964696a646f6e37344e59724a57/json/SeoulGilWalkCourse/0/10";
        URL url = new URL(urlStr);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        String result = br.readLine();
//        String returnLine;
//        while((returnLine = br.readLine())!=null) {
//            result.concat(returnLine);
//            System.out.println(result);
//        }
        //이게 맞나 싶네..
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject)parser.parse(result);
        JSONObject seoulGilWalkCourse = (JSONObject)object.get("SeoulGilWalkCourse");
        JSONArray arr = (JSONArray)seoulGilWalkCourse.get("row");

        for(int i=0; i<arr.size(); i++) {
            JSONObject tmp = (JSONObject)arr.get(i);
            Course course = new Course(i+(long)1, (double)tmp.get("COURSE_CATEGORY"), (String)tmp.get("COURSE_CATEGORY_NM"),
                    (String)tmp.get("SOUTH_NORTH_DIV"), (String)tmp.get("SOUTH_NORTH_DIV_NM"), (String)tmp.get("AREA_GU"),
                    (String)tmp.get("DISTANCE"), (String)tmp.get("LEAD_TIME"), (String)tmp.get("COURSE_LEVEL"),
                    (double)tmp.get("VOTE_CNT"), (String)tmp.get("RELATE_SUBWAY"), (String)tmp.get("TRAFFIC_INFO"),
                    (String)tmp.get("CONTENT"), (String)tmp.get("PDF_FILE_PATH"), (String)tmp.get("COURSE_NAME"),  (String)tmp.get("REG_DATE"),
                    (String)tmp.get("DETAIL_COURSE"), (double)tmp.get("CPI_IDX"), (String)tmp.get("CPI_NAME"), (String)tmp.get("X"),
                    (String)tmp.get("Y"));
            //System.out.println("X좌표 : "+course.getX()+", Y좌표 : "+course.getY());
            courseRepository.save(course);
        }
        //이게 맞나 싶어..

        urlConnection.disconnect();
        return result;
    }
}
