package com.speakingfish.common.type.impl;

import com.speakingfish.common.type.Named;

public class NamedImpl<T> extends IdentifiedImpl<String, T> implements Named<T>/*, Comparable<Named<?>>*/ {
    
    public NamedImpl(String id) {
        super(id);
        assert null != id;
    }

}
