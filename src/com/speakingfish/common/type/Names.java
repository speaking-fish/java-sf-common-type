package com.speakingfish.common.type;

import java.util.Map;

import com.speakingfish.common.type.impl.DefaultValueImpl;
import com.speakingfish.common.type.impl.NamedImpl;

import static com.speakingfish.common.Maps.*;

public class Names {

    public static <T> Named<T> named(String name) {
        return new NamedImpl<T>(name);
    }
    
    public static <T> Named<T> named(Identified<String, ?> name) {
        return new NamedImpl<T>(name.id());
    }
    
    public static <T> Named<T> namedOf(Typed<T> typed, String name) {
        return new NamedImpl<T>(name);
    }
    
    public static <T> Named<T> namedOf(Class<T> typed, String name) {
        return new NamedImpl<T>(name);
    }
    
    public static <T> Map.Entry<String, T> namedValue(Named<T> name, T value) {
        return keyValue(name.id(), value);
    }

    public static <ORIGIN, T> DefaultValue<ORIGIN, T> defaultValue(ORIGIN origin, T defaultValue) {
        return new DefaultValueImpl<ORIGIN, T>(origin, defaultValue);
    }
    
}
