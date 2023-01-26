package com.deep.testproject.setting;

import com.deep.testproject.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class SettingServiceImpl {

    @Autowired
    private SettingRepo settingRepo;

    @Autowired
    private FieldsRepo fieldsRepo;

    public Setting saveSetting(Setting setting) {
        Setting setting1 = new Setting();

        // saving setting object
        setting1.setId(setting.getId());
        setting1.setOffset(setting.getOffset());
        setting1.setDateFormat(setting.getDateFormat());
        setting1.setNoOfPreviousPartitionScan(setting.getNoOfPreviousPartitionScan());

        List<Fields> fields = setting.getFields();
        fields.forEach(field -> field.setSetting(setting1));
        setting1.setFields(fields);

        settingRepo.save(setting1);

        return setting1;
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

    public Setting updateSetting(Setting setting) {
        return settingRepo.save(setting);
    }




    public Fields updateField(Fields field, Long fieldId) throws Exception {

        Optional<Fields> fieldExist = fieldsRepo.findById(fieldId);

        List<Setting> settings = settingRepo.findAll();

        Optional<Setting> optionalSetting = settings.stream().filter(f -> f.getFields().forEach(fsingle -> fsingle.equals(field))).findAny();

        if (fieldExist.isEmpty()) {
            throw new Exception("Correlation Field not found");
        }  else {
            log.info("Correlation Field of Id: {} is exist, Updating server...", fieldId);

            fieldExist.get().setId(fieldId);
            fieldExist.get().setType(field.getType());
            fieldExist.get().setSourceCol(field.getSourceCol());
            fieldExist.get().setDestCol(field.getDestCol());

            fieldExist.get().setSetting(settings.get(0));

            fieldsRepo.save(fieldExist.get());

            log.info("Correlation Field updated successfully with server object: {}", fieldExist.get());
        }

        return fieldExist.get();
    }




}
