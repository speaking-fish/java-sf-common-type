package com.speakingfish.common.type.impl;

import com.speakingfish.common.Equals;
import com.speakingfish.common.type.DefaultValue;

import static com.speakingfish.common.Hashes.*;

public class DefaultValueImpl<ORIGIN, T> implements DefaultValue<ORIGIN, T> {
    
    protected final ORIGIN _origin      ; 
    protected final T      _defaultValue; 

    public DefaultValueImpl(ORIGIN origin, T defaultValue) {
        super();
        _origin       = origin      ;
        _defaultValue = defaultValue;
    }

    public ORIGIN origin() { return _origin; }
    public T defaultValue() { return _defaultValue; }

    @Override public int hashCode() {
        return
            hash(origin      (),
            hash(defaultValue()
            ));
    }

    @SuppressWarnings("unchecked")
    @Override public boolean equals(Object obj) {
        if(this == obj) return true ;
        return true
            && (null != obj)
            && (getClass() == obj.getClass())
            && Equals.equals(this.origin      (), ((DefaultValueImpl<Object, Object>) obj).origin      ())
            && Equals.equals(this.defaultValue(), ((DefaultValueImpl<Object, Object>) obj).defaultValue())
            ;
    }

}
