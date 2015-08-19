package com.speakingfish.common.type.impl;

import com.speakingfish.common.type.OriginatedGetter;
import com.speakingfish.common.value.ImmutableGetter;

public class ImmutableOriginatedGetterImpl<ORIGIN, T> extends ImmutableGetter<T> implements OriginatedGetter<ORIGIN, T> {
    
    protected final ORIGIN _origin;
    
    public ImmutableOriginatedGetterImpl(ORIGIN origin, T value) {
        super(value);
        _origin = origin;
    }

    @Override public ORIGIN origin() { return _origin; }

}
