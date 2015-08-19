package com.speakingfish.common.type;

import com.speakingfish.common.type.impl.LocalNamedImpl;

public class Locals {
    
    public static <CONTEXT, T> LocalNamed<CONTEXT, T> local(Typed<CONTEXT> context, Named<T> named) {
        return new LocalNamedImpl<CONTEXT, T>(named);
    }
    
    public static <CONTEXT, T> LocalNamed<CONTEXT, T> local(Typed<CONTEXT> context, String name) {
        return new LocalNamedImpl<CONTEXT, T>(name);
    }
    
}
