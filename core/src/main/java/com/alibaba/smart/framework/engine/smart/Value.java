package com.alibaba.smart.framework.engine.smart;

import java.util.Map;

import javax.xml.namespace.QName;

import com.alibaba.smart.framework.engine.common.util.MapUtil;
import com.alibaba.smart.framework.engine.constant.ExtensionElementsConstant;
import com.alibaba.smart.framework.engine.constant.SmartBase;
import com.alibaba.smart.framework.engine.model.assembly.ExtensionDecorator;
import com.alibaba.smart.framework.engine.model.assembly.ExtensionElements;
import com.alibaba.smart.framework.engine.model.assembly.NoneIdBasedElement;

import lombok.Data;

/**
 * @author ettear
 * Created by ettear on 06/08/2017.
 */
@Data
public class Value  implements PropertiesElementMarker, ExtensionDecorator {
    public final static QName qtype = new QName(SmartBase.SMART_NS, "value");

    private String name;
    private String value;

    @Override
    public String getDecoratorType() {
        return ExtensionElementsConstant.PROPERTIES;
    }

    @Override
    public void decorate(ExtensionElements extensionElements) {

        Map map =  (Map)extensionElements.getDecorationMap().get(getDecoratorType());

        if(null == map){
            map = MapUtil.newHashMap();
            extensionElements.getDecorationMap().put(this.getDecoratorType(),map);
        }

        map.put(this.getName(),this.getValue());

    }

}
