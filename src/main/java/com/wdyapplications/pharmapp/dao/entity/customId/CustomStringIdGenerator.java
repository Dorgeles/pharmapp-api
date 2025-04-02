package com.wdyapplications.pharmapp.dao.entity.customId;

import com.wdyapplications.pharmapp.utils.Utilities;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.UUID;

public class CustomStringIdGenerator implements IdentifierGenerator, Configurable {
    private String paramName;
    private SimpleDateFormat dateFormatTime = null;
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

    if(dateFormatTime == null) {
        dateFormatTime = new SimpleDateFormat("yyyyMMddHHmmssSS");
    }

        String currentDate = dateFormatTime.format(Utilities.getCurrentDate());
        String id = UUID.randomUUID().toString().substring(0, 10);
        id = paramName + id.concat("-" + currentDate);

        return id;
    }
    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) {
        paramName = params.getProperty("paramName");
    }
}