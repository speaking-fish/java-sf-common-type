package com.speakingfish.common.type;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

import com.speakingfish.common.function.Creator;
import com.speakingfish.common.type.impl.IdentifiedImpl;

import static com.speakingfish.common.type.Typecasts.*;

public class Identifiers {
    
    public static <ID> Typed<ID> idTyped(Identified<ID, ?> id) { return null; }
    
    public static <ID, T> Typed<Entry<ID, T>> entryTyped(Identified<ID, T> id) { return null; }
    
    public static <ID, T> Identified<ID, T> identified(ID id) {
        return new IdentifiedImpl<ID, T>(id);
    }

    public static <ID, T> Identified<ID, T> identified(Identified<ID, ?> id) {
        return new IdentifiedImpl<ID, T>(id.id());
    }

    public static <ID, T> Identified<ID, T> identified(ID id, Typed<T> proto) {
        return new IdentifiedImpl<ID, T>(id);
    }

    @SuppressWarnings("unchecked")
    public static <ID, T> T typedGet(Map<ID, ?> map, Identified<ID, T> key) {
        return (T) map.get(key.id());
    }
    
    public static <ID, T> boolean typedContainsKey(Map<ID, T> map, Identified<ID, T> key) {
        return map.containsKey(key.id());
    }
    
    @SuppressWarnings("unchecked")
    public static <ID, T> T typedPut(Map<ID, Object> map, Identified<ID, T> key, T value) {
        return (T) map.put(key.id(), value);
    }
    
    public static <ID, T> T typedPutIfAbsent(ConcurrentMap<ID, Object> map, Identified<ID, T> key, T value) {
        @SuppressWarnings("unchecked")
        T result = (T) map.putIfAbsent(key.id(), value);
        if(null != result) {
            return result;
        }
        return value;
    }
    
    public static <ID, T, P> T typedPutIfAbsent(ConcurrentMap<ID, Object> map, Identified<ID, T> key, Creator<? extends T, P> creator, P params) {
        T result = typedGet(map, key);
        if(null != result) {
            return result;
        }
        return typedPutIfAbsent(map, key, creator.create(params));
    }
    
    @SuppressWarnings("unchecked")
    public static <ID, T> T typedRemove(Map<ID, Object> map, Identified<ID, T> key) {
        return (T) map.remove(key.id());
    }
    
    public static <ID, T> T castGet(Map<?, ?> map, Identified<ID, T> key) {
        return typedGet(castMap(map, Typecasts.entryTyped(idTyped(key), classTyped(Object.class))), key);
    }
    
    public static <ID, T> T castPut(Map<?, ?> map, Identified<ID, T> key, T value) {
        return typedPut(castMap(map, Typecasts.entryTyped(idTyped(key), classTyped(Object.class))), key, value);
    }
    
    public static <ID, T> T castPutIfAbsent(ConcurrentMap<?, ?> map, Identified<ID, T> key, T value) {
        return typedPutIfAbsent(castConcurrentMap(map, Typecasts.entryTyped(idTyped(key), classTyped(Object.class))), key, value);
    }
    
    public static <ID, T, P> T castPutIfAbsent(ConcurrentMap<?, ?> map, Identified<ID, T> key, Creator<? extends T, P> creator, P params) {
        return typedPutIfAbsent(castConcurrentMap(map, Typecasts.entryTyped(idTyped(key), classTyped(Object.class))), key, creator, params);
    }
    
    public static <ID, T> T castRemove(Map<?, ?> map, Identified<ID, T> key) {
        return typedRemove(castMap(map, Typecasts.entryTyped(idTyped(key), classTyped(Object.class))), key);
    }
    
}
