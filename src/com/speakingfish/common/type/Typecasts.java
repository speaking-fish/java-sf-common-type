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
 * <p>
 * Typed&lt;YYY&gt; XXXtyped(src) - extract XXX type from src as YYY parameter of Typed
 * </p>
 * <p>
 * Typed&lt;YYY&gt; typedXXX(params) - syntesys of YYY parameter of Typed based on params 
 * </p>
 * <p>
 * XXX&lt;YYY&gt; castXXX(XXX&lt;?&gt; src, Typed&lt;YYY&gt; proto) - recast src type parameters to proto type parameters 
 * </p>
 * <p>
 * XXX&lt;YYY&gt; castXXXTo(Typed&lt;YYY&gt; proto, XXX&lt;?&gt; src) - same as castXXX with reverse ordered parameters 
 * </p>
 * 
 * @author borka
 *
 */
public class Typecasts {
    
    public static final Void VOID = null;
    
    
    public static <T> T typeOf(Typed<T> proto) { return null; }
    
    public static <T> Typed<T> typed() { return null; }

    public static <T> Typed<T> typed(T src) { return null; }
    
    public static <T> Typed<Class<T>> typedClass(Typed<T> src) { return null; }
    
    public static <T> Typed<T> classTyped(Class<T> src) { return null; }
    
    public static <T> Typed<T> getterTyped(Getter<T> src) { return null; }
    
    public static <C, A extends C, B extends C> boolean equalsOf(A a, B b, Typed<C> c) {
        return Equals.<C, B>equalsOf(a, b);
    }
    
    //public static <T> Typed<T> elementTyped(Collection<T> src) { return null; }
    public static <T> Typed<T> elementTyped(Iterable<T> src) { return null; }
    
    public static <T> Typed<T> elementTyped(Iterator<T> src) { return null; }

    public static <K, V> Typed<Entry<K, V>> elementTyped(Map<K, V> src) { return null; }
    
    // for maps use elementTyped(map.entrySet()) / elementTyped(map.keySet()) / elementTyped(map.values())
    
    public static <K, V> Typed<Map<K, V>> typedMap(Typed<K> keyTyped, Typed<V> valueTyped) { return null; }
    
    public static <T> Typed<T> mapKeyTyped  (Map<T, ?> src) { return null; }
    public static <T> Typed<T> mapValueTyped(Map<?, T> src) { return null; }
    
    public static <K, V> Typed<Entry<K, V>> typedEntry(Typed<K> keyTyped, Typed<V> valueTyped) { return null; }

    public static <K, V> Typed<Entry<K, V>> typedEntry(Map<K, V> src) { return null; }
    
    public static <T> Typed<T> entryKeyTyped  (Entry<T, ?> src) { return null; }
    public static <T> Typed<T> entryValueTyped(Entry<?, T> src) { return null; }
    
    
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object src, Typed<T> proto) {
        return (T) src;
    }

    @SuppressWarnings("unchecked")
    public static <T> T castTo(Typed<T> proto, Object src) {
        return (T) src;
    }
  
/*
    @SuppressWarnings("unchecked")
    public static <B, S extends B, T extends B> T cast(S src, Typed<T> proto) {
        return (T) src;
    }

    @SuppressWarnings("unchecked")
    public static <B, S extends B, T extends B> T castTo(Typed<T> proto, S src) {
        return (T) src;
    }
*/
    
    @SuppressWarnings("unchecked")
    public static <T> T recast(Object src, Typed<T> proto) {
        return (T) src;
    }

    @SuppressWarnings("unchecked")
    public static <T> T recastTo(Typed<T> proto, Object src) {
        return (T) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <S, T extends S> T downcast(S src, Typed<T> proto) {
        return (T) src;
    }

    @SuppressWarnings("unchecked")
    public static <S, T extends S> T downcastTo(Typed<T> proto, S src) {
        return (T) src;
    }

    @SuppressWarnings("unchecked") // TODO: comment form 1.5
    public static <T, S extends T> T upcast(S src, Typed<T> proto) {
        return (T) src;
    }

    @SuppressWarnings("unchecked") // TODO: comment form 1.5
    public static <T, S extends T> T upcastTo(Typed<T> proto, S src) {
        return (T) src;
    }
    
    /**
     * Type check
     * @param src
     * @param proto
     * @return
     */
    public static <T> T castSame(T src, Typed<T> proto) {
        return src;
    }

    /**
     * Type check
     * @param proto
     * @param src
     * @return
     */
    public static <T> T castSameTo(Typed<T> proto, T src) {
        return src;
    }

    public static <T> Class<T> castClass(Class<?> src, Typed<T> proto) {
        //return (Class<T>) src;
        return cast(src, typedClass(proto));
    }
    
    public static <T> Class<T> castClassTo(Typed<T> proto, Class<?> src) {
        //return (Class<T>) src;
        return castTo(typedClass(proto), src);
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
    public static <T> Iterable<T> castIterable(Iterable<?> src, Typed<T> proto) {
        return (Iterable<T>) src;
    }
    
    @SuppressWarnings("unchecked")
    public static <T> Iterable<T> castIterableTo(Typed<T> proto, Iterable<?> src) {
        return (Iterable<T>) src;
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
