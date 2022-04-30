package trailProject.trail.service;

import com.nimbusds.jose.shaded.json.JSONArray;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import trailProject.trail.dto.CourseDto;
import trailProject.trail.entity.Course;
import trailProject.trail.repository.CourseRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    //구 단위로 코스 리스트 보여주는거
    public List<CourseDto> findByCourseAddress(String courseAddress) {
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<CourseDto> page = courseRepository.findByCourseAddress(courseAddress, pageRequest);
        return page.getContent();
    }
    //아이디로 코스 찾는거
    public CourseDto findByCourseId(Long courseId) {
        CourseDto courseDto = courseRepository.findByCourseId(courseId);
        return courseDto;
    }

}
