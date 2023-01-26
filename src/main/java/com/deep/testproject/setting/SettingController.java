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
    public ResponseEntity<Response> createSetting(@RequestBody Setting setting) {
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

    @PutMapping(value = "/update-setting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateSetting(@RequestBody Setting setting, @RequestParam Long settingId) throws Exception {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("setting", settingService.updateSetting(setting, settingId)))
                        .build()
        );
    }

    @DeleteMapping(value = "/delete-setting", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteSetting(@RequestBody Long settingId) {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("setting", settingService.deleteSetting(settingId)))
                        .build()
        );
    }

    @GetMapping(value = "/get-setting", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getSetting() {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("setting", settingService.getAllSetting()))
                        .build()
        );
    }

    @PostMapping(value = "/save-fields", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveFields(@RequestBody Fields fields, @RequestParam String settingId) {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("fields", settingService.addField(Long.valueOf(settingId), fields)))
                        .build()
        );
    }

    @PutMapping(value = "/update-fields", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateFields(@RequestBody Fields fields, @RequestParam Long fieldId) throws Exception {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("fields", settingService.updateField(fields, fieldId)))
                        .build()
        );
    }

    @DeleteMapping(value = "/delete-fields", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteFields(@RequestBody Long fieldId) {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("fields", settingService.deleteField(fieldId)))
                        .build()
        );
    }

    @GetMapping(value = "/get-fields", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getFields() {
        return ResponseEntity.ok(
                Response.builder()
                        .responseTime(LocalDateTime.now())
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Simple Search executed successfully!")
                        .method("SimpleSearchController.searchContent")
                        .executionMessage("Implemented business logic of Simple Search class method")
                        .data(Map.of("fields", settingService.getAllField()))
                        .build()
        );
    }
}
