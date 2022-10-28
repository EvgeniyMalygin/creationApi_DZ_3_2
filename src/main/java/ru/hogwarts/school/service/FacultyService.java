package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.hogwarts.school.model.Faculty;

import java.util.*;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultyMap = new HashMap<>();

    private long lastId = 0;

    public Faculty creatFaculty(@RequestBody Faculty faculty) {
        faculty.setId(++lastId);
        facultyMap.put(lastId, faculty);
        return faculty;
    }

    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return facultyMap.get(id);
    }

    public Faculty deleteFaculty(long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> getAllFaculty() {
        return facultyMap.values();
    }

    public Collection<Faculty> getFacultyOfColor(String color) {
        List<Faculty> tempList = new ArrayList<>();
        for (Faculty faculty: facultyMap.values()){
            if (faculty.getColor().equals(color)){
                tempList.add(faculty);
            }
        }
        return tempList;
    }
}
