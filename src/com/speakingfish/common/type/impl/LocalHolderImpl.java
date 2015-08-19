package com.speakingfish.common.type.impl;

import com.speakingfish.common.type.LocalNamed;
import com.speakingfish.common.type.Named;

public class LocalHolderImpl<CONTEXT> {
    
    public <T> LocalNamed<CONTEXT, T> local(Named<T> named) {
        return new LocalNamedImpl<CONTEXT, T>(named);
    }
    
}
