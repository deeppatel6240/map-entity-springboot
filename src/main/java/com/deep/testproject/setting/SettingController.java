package com.deep.testproject.setting;

import com.deep.testproject.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/setting")
@Slf4j
public class SettingController {

    @Autowired
    private SettingServiceImpl settingService;

    @PostMapping(value = "/save-setting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> searchContent(@RequestBody Setting setting) {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("setting", settingService.saveSetting(setting)))
                        .build()
        );
    }

    @PostMapping(value = "/save-fields", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveFields(@RequestBody Fields fields) {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("fields", settingService.saveFields(fields)))
                        .build()
        );
    }

}
