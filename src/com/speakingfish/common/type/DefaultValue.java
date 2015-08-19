package com.speakingfish.common.type;

public interface DefaultValue<ORIGIN, T> extends Originated<ORIGIN> {
    
    T defaultValue();

}
