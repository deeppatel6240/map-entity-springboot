package com.deep.testproject.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Fields saveFields(Fields fields) {
        fieldsRepo.save(fields);
        return fields;
    }
}
