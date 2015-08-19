package com.speakingfish.common.type.impl;

import com.speakingfish.common.type.LocalNamed;
import com.speakingfish.common.type.Named;

public class LocalNamedImpl<CONTEXT, T> extends NamedImpl<T> implements LocalNamed<CONTEXT, T> {

    public LocalNamedImpl(String id) {
        super(id);
    }

    public LocalNamedImpl(Named<T> named) {
        this(named.id());
    }
    
}
