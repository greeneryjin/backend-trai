package trailProject.trail.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import trailProject.trail.account.entity.Account;
import trailProject.trail.account.repository.AccountRepository;
import trailProject.trail.course.dto.DetailDto;
import trailProject.trail.course.dto.CourseDto;
import trailProject.trail.course.entity.Course;
import trailProject.trail.course.entity.Detail;
import trailProject.trail.course.repository.DetailRepository;
import trailProject.trail.course.repository.CourseRepository;
import trailProject.trail.facility.dto.FacilityDto;
import trailProject.trail.facility.entity.Facility;
import trailProject.trail.facility.repository.FacilityRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final FacilityRepository facilityRepository;
    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final DetailRepository detailRepository;

    public List<CourseDto> findByFilter(String gu, String level, String toilet, String charge, String thirtyMore) {

//        //사용자 가지고 와서 location으로 gu 받아오기
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Account accountId = (Account) authentication.getPrincipal();
//        Account account = accountRepository.findBySnsId(accountId.getSnsId());
//        String gu = account.getLocation();
        List<CourseDto> courseDtoList;

        if(level.isEmpty()){
            //레벨 필터 없고
            if (toilet.isEmpty()) {
                //화장실 필터 없고
                if (charge.isEmpty()) {
                    //충전소 필터 없고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGu(gu);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndThirtyMore(gu, thirtyMore);
                    }
                }
                else {
                    //충전소 필터 있고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndCharge(gu, charge);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndChargeAndThirtyMore(gu, charge, thirtyMore);
                    }
                }
            }
            else {
                //화장실 필터 있고
                if (charge.isEmpty()) {
                    //충전소 필터 없고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndToilet(gu, toilet);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndToiletAndThirtyMore(gu, toilet, thirtyMore);
                    }
                }
                else {
                    //충전소 필터 있고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndToiletAndCharge(gu, toilet, charge);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndToiletAndChargeAndThirtyMore(gu, toilet, charge, thirtyMore);
                    }
                }
            }

        }
        else{
            //레벨 필터 있고
            if (toilet.isEmpty()) {
                //화장실 필터 없고
                if (charge.isEmpty()) {
                    //충전소 필터 없고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndLevel(gu, level);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndLevelAndThirtyMore(gu, level, thirtyMore);
                    }
                }
                else {
                    //충전소 필터 있고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndLevelAndCharge(gu, level, charge);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndLevelAndChargeAndThirtyMore(gu, level, charge, thirtyMore);
                    }
                }
            }
            else {
                //화장실 필터 있고
                if (charge.isEmpty()) {
                    //충전소 필터 없고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndLevelAndToilet(gu, level, toilet);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndLevelAndToiletAndThirtyMore(gu, level, toilet, thirtyMore);
                    }
                }
                else {
                    //충전소 필터 있고
                    if (thirtyMore.isEmpty()) {
                        //장거리 필터 없으면
                        courseDtoList = courseRepository.findByGuAndLevelAndToiletAndCharge(gu, level, toilet, charge);
                    }
                    else {
                        //장거리 필터 있으면
                        courseDtoList = courseRepository.findByGuAndLevelAndToiletAndChargeAndThirtyMore(gu, level, toilet, charge, thirtyMore);
                    }
                }
            }
        }

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

    public DetailDto findDetailByCourseId(Long courseId) {
        Course course = courseRepository.findByCourseId(courseId);
        Detail detail = detailRepository.findByCourse(course);
        String[] coordinateArray = detail.getCoordinateArray().replaceAll("[^0-9.]", " ").trim().split("\\s+");
        Map<String, String> detailmap = new HashMap<>();
        for (int i = 0; i < coordinateArray.length-1; i+=2) {
            for (int j = i; j == i ; j++) {
                detailmap.put(coordinateArray[i], coordinateArray[i+1]);
            }
        }
        DetailDto detailDto = new DetailDto(detail.getDetailId(), detailmap);


        List<FacilityDto> facilityDtoList = new ArrayList<>();
        List<Facility> facilityList = facilityRepository.findByDetail(detail);
        Map<String, String> facilityMap = new HashMap<>();
        for (Facility facility : facilityList) {
            facilityMap.put(facility.getX(), facility.getY());
            FacilityDto facilityDto = new FacilityDto(facility.getFacilityId(), facility.getFacilityName(), facilityMap);
            facilityDtoList.add(facilityDto);
        }
        detailDto.setFacilityDtoList(facilityDtoList);

        return detailDto;
    }

    public List<String> findCourseGu() {
        List<Course> courseList = courseRepository.findAll();
        List<String> guList = new ArrayList<>();

        for(Course course : courseList) {
            int si = course.getCourseAddress().indexOf('시');
            int gu = course.getCourseAddress().indexOf('구');
            String str = course.getCourseAddress().substring(si+1, gu+1);
            course.setGu(str);
            if(!guList.contains(str)) {
                guList.add(str);
            }
        }
        return guList;
    }
}
