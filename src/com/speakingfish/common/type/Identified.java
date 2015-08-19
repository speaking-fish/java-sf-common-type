package com.speakingfish.common.type;

public interface Identified<ID, T> extends Typed<T> {

    ID id();
    
}
