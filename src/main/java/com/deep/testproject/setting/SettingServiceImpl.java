package com.deep.testproject.setting;

import com.deep.testproject.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SettingServiceImpl {

    @Autowired
    private SettingRepo settingRepo;

    @Autowired
    private FieldsRepo fieldsRepo;

    public Setting saveSetting(Setting setting) {
          settingRepo.save(setting);
          return setting;
    }

//    public Setting createSetting(Setting setting) {
//        Optional<Setting> settingFromDb = settingRepo.findById(setting.getId());
//        List<Fields> fields = setting.getFields();
//        for (Fields field : fields) {
//            field.setSetting(settingFromDb.get());
//        }
//        settingRepo.save(settingFromDb.get());
//        settingFromDb.get().setFields(fields);
//        return setting;
//    }

    public Setting updateSetting(Setting setting) {
        return settingRepo.save(setting);
    }

    public Map<String, String> deleteSetting(Long settingId) {
        Map<String, String> deleted = new HashMap<>();

        settingRepo.deleteById(settingId);
        deleted.put("deleted", "true");
        return deleted;
    }

    public Fields addField(Long settingId, Fields field) {
        Setting setting = settingRepo.findById(settingId).orElseThrow(() -> new NotFoundException("Setting not found"));
        field.setSetting(setting);
        return fieldsRepo.save(field);
    }

    public Fields updateField(Fields field) {
        return fieldsRepo.save(field);
    }

    public Map<String, String> deleteField(Long fieldId) {
        Map<String, String> deleted = new HashMap<>();
        fieldsRepo.deleteById(fieldId);
        deleted.put("deleted", "true");
        return deleted;
    }

    public List<Setting> getAllSetting() {
        return settingRepo.findAll();
    }

    public List<Fields> getAllField() {
        return fieldsRepo.findAll();
    }
}
