package trailProject.trail.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trailProject.trail.course.dto.CourseDetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.CourseDetail;
import trailProject.trail.course.repository.CourseDetailRepository;
import trailProject.trail.course.repository.CourseRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;
    @Autowired
    private final CourseDetailRepository courseDetailRepository;

    public List<CourseDto> findCourseByCourseAddress(String courseAddress) {
        List<CourseDto> courseDtoList = courseRepository.findByCourseAddressContains(courseAddress);
        int size = courseDtoList.size();

        for (int i = 0; i < size; i++) {
            StringBuffer sb = new StringBuffer();
            String courseDistance = courseDtoList.get(i).getCourseDistance();
            String time = courseDtoList.get(i).getTime();
            String times = time + "분";
            String[] split = courseDistance.split("\\.");

            for (int j = 0; j <split.length; j++) {
                if(j == 0){
                    sb.append(split[j]);
                }
            }
            sb.append("m");
            courseDtoList.get(i).setCourseDistance(sb.toString());
            courseDtoList.get(i).setTime(times);
        }
        return courseDtoList;
    }


    public CourseDetailDto findCourseDetailByCourseId(Long courseId) {
        CourseDetail courseDetail = courseDetailRepository.findByCourseDetailId(courseId);
        String[] coordinateArray = courseDetail.getCoordinateArray().replaceAll("[^0-9.]", " ").trim().split("\\s+");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < coordinateArray.length-1; i+=2) {
            for (int j = i; j == i ; j++) {
                map.put(coordinateArray[i], coordinateArray[i+1]);
            }
        }
        CourseDetailDto courseDetailDto = new CourseDetailDto(courseDetail.getCourseDetailId(), map);
        return courseDetailDto;
    }

    public List<String> findCourseGu() {
        List<Course> courseList = courseRepository.findAll();
        List<String> guList = new ArrayList<>();

        for(Course course : courseList) {
            int si = course.getCourseAddress().indexOf('시');
            int gu = course.getCourseAddress().indexOf('구');
            String str = course.getCourseAddress().substring(si+1, gu+1);
            if(!guList.contains(str)) {
                guList.add(str);
            }
        }
        return guList;
    }
}
