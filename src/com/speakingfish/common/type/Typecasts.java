package com.speakingfish.common.type;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.SortedMap;

import com.speakingfish.common.Equals;
import com.speakingfish.common.function.Acceptor;
import com.speakingfish.common.function.Getter;
import com.speakingfish.common.mapper.Mappers;
/**
 * @goal remove "@SuppressWarnings("unchecked")" from application code into cast* methods
 * 
 * @author borka
 *
 */
public class Typecasts {
    
    @SuppressWarnings("unchecked")
    public static <T> T castObject(Object src, Typed<T> dest) {
        return (T) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Class<T> castClass(Class<?> src, Typed<T> dest) {
        return (Class<T>) src;
    }
    
    public static <T> Typed<T> typed() { return null; }

    public static <T> Typed<T> typed(T src) { return null; }
    
    public static <T> Typed<T> classTyped(Class<T> src) { return null; }
    
    public static <T> Typed<T> getterTyped(Getter<T> src) { return null; }
    
    public static <A extends C, B extends C, C> boolean equals(A a, B b, Typed<C> c) {
        return Equals.equals(a, b);
    }
    
    public static <T> Typed<T> elementTyped(Collection<T> src) { return null; }
    
    public static <T> Typed<T> elementTyped(Iterator  <T> src) { return null; }
    
    public static <K, V> Typed<Entry<K, V>> entryTyped(Typed<K> keyTyped, Typed<V> valueTyped) { return null; }
    
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object value, Typed<T> proto) {
        return (T) value;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T castTo(Typed<T> proto, Object value) {
        return (T) value;
    }
    
    public static <T> T castSame(T value, Typed<T> proto) {
        return value;
    }

    public static <T> T castSameTo(Typed<T> proto, T value) {
        return value;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> castIterator(Iterator<?> src, Typed<T> proto) {
        return (Iterator<T>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Iterator<T> castIteratorTo(Typed<T> proto, Iterator<?> src) {
        return (Iterator<T>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> castMap(Map<?, ?> src, Typed<Entry<K, V>> proto) {
        return (Map<K, V>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> Map<K, V> castMapTo(Typed<Entry<K, V>> proto, Map<?, ?> src) {
        return (Map<K, V>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> castSortedMap(SortedMap<?, ?> src, Typed<Entry<K, V>> proto) {
        return (SortedMap<K, V>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> SortedMap<K, V> castSortedMapTo(Typed<Entry<K, V>> proto, SortedMap<?, ?> src) {
        return (SortedMap<K, V>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> ConcurrentMap<K, V> castConcurrentMap(ConcurrentMap<?, ?> map, Typed<Entry<K, V>> proto) {
        return (ConcurrentMap<K, V>) map;
    }
    
    @SuppressWarnings("unchecked")
    public static <K, V> ConcurrentMap<K, V> castConcurrentMapTo(Typed<Entry<K, V>> proto, ConcurrentMap<?, ?> map) {
        return (ConcurrentMap<K, V>) map;
    }
    
    public static <T> Acceptor<T> acceptAssigned(Typed<T> proto) {
        return Mappers.acceptAssigned();
    }
    
}
